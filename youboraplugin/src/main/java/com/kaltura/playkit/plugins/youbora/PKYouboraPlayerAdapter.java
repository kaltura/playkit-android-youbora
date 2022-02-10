/*
 * ============================================================================
 * Copyright (C) 2017 Kaltura Inc.
 *
 * Licensed under the AGPLv3 license, unless a different license for a
 * particular library is specified in the applicable library path.
 *
 * You may obtain a copy of the License at
 * https://www.gnu.org/licenses/agpl-3.0.html
 * ============================================================================
 */

package com.kaltura.playkit.plugins.youbora;

import android.text.TextUtils;

import com.kaltura.playkit.BuildConfig;
import com.kaltura.playkit.MessageBus;
import com.kaltura.playkit.PKAudioCodec;
import com.kaltura.playkit.PKError;
import com.kaltura.playkit.PKEvent;
import com.kaltura.playkit.PKLog;
import com.kaltura.playkit.PKMediaConfig;
import com.kaltura.playkit.PKMediaEntry;
import com.kaltura.playkit.PKVideoCodec;
import com.kaltura.playkit.PlayKitManager;
import com.kaltura.playkit.PlaybackInfo;
import com.kaltura.playkit.Player;
import com.kaltura.playkit.PlayerEvent;
import com.kaltura.playkit.ads.AdController;
import com.kaltura.playkit.ads.PKAdPluginType;
import com.kaltura.playkit.player.AudioTrack;
import com.kaltura.playkit.player.PKPlayerErrorType;
import com.kaltura.playkit.player.VideoTrack;
import com.kaltura.playkit.plugins.ads.AdCuePoints;
import com.kaltura.playkit.plugins.ads.AdEvent;
import com.kaltura.playkit.utils.Consts;
import com.npaw.youbora.lib6.YouboraUtil;
import com.npaw.youbora.lib6.adapter.PlayerAdapter;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static com.kaltura.playkit.PlayerEvent.Type.PLAYHEAD_UPDATED;

/**
 * @hide
 */

class PKYouboraPlayerAdapter extends PlayerAdapter<Player> {

    private static final PKLog log = PKLog.get("PKYouboraPlayerAdapter");
    private static final String KALTURA_ANDROID = "Kaltura-Android";
    private static final String PLAYER_ERROR_STR = "Player error occurred";

    private MessageBus messageBus;
    private PKMediaConfig mediaConfig;

    private boolean isFirstPlay = true;
    private boolean isBuffering = false;

    private String lastReportedResource = "unknown";
    private Long lastReportedBitrate = -1L;
    private Long lastReportedThroughput;
    private String lastReportedRendition;
    private Double lastReportedMediaPosition;
    private Double lastReportedMediaDuration;
    private PKAdPluginType lastReportedAdPluginType;
    private String lastReportedVideoCodecs;
    private String lastReportedAudioCodecs;
    private Long droppedFrames = 0L;
    private String houseHoldId;
    private boolean isAdPlaying;
    private AdCuePoints adCuePoints;
    private boolean isFatalErrorSent;

    PKYouboraPlayerAdapter(Player player, MessageBus messageBus, PKMediaConfig mediaConfig, String houseHoldId) {
        super(player);
        log.d("Start PKYouboraPlayerAdapter");
        this.messageBus = messageBus;
        this.mediaConfig = mediaConfig;
        updateDurationFromMediaConfig(mediaConfig);
        this.houseHoldId = houseHoldId;
        registerListeners();
    }

    private void updateDurationFromMediaConfig(PKMediaConfig mediaConfig) {
        if (mediaConfig != null && mediaConfig.getMediaEntry() != null) {
            lastReportedMediaDuration = Math.floor((double) mediaConfig.getMediaEntry().getDuration() / Consts.MILLISECONDS_MULTIPLIER);
        }
    }

    private void onStateChangedEvent(PlayerEvent.StateChanged event) {
        //If it is first play, do not continue with the flow.
        if (isFirstPlay) {
            return;
        }

        switch (event.newState) {
            case READY:
                if (isBuffering) {
                    //log.d("fireBufferEnd");
                    isBuffering = false;
                    fireBufferEnd();
                }
                break;
            case BUFFERING:
                //log.d("fireBufferBegin");
                isBuffering = true;
                fireBufferBegin();
                break;
            default:
                break;
        }
        sendReportEvent(event);
    }

    private void sendErrorHandler(PKEvent event) {

        PlayerEvent.Error errorEvent = (PlayerEvent.Error) event;
        String errorMetadata = (errorEvent != null && errorEvent.error != null) ? errorEvent.error.message : PLAYER_ERROR_STR;

        if (errorEvent == null || errorEvent.error == null || errorEvent.error.exception == null) {
            fireFatalError(errorMetadata, event.eventType().name(), null);
            return;
        }

        PKError error = errorEvent.error;
        Exception playerErrorException = (Exception) error.exception;
        String exceptionClass = "";

        if (playerErrorException != null && playerErrorException.getCause() != null && playerErrorException.getCause().getClass() != null) {
            exceptionClass = playerErrorException.getCause().getClass().getName();
            errorMetadata = (playerErrorException.getCause().toString() != null) ? playerErrorException.getCause().toString() : errorMetadata;
        } else {
            if (error.exception.getClass() != null) {
                exceptionClass = error.exception.getClass().getName();
            }
        }

        LinkedHashSet<String> causeMessages = getExceptionMessageChain(playerErrorException);
        StringBuilder exceptionCauseBuilder = new StringBuilder();
        if (playerErrorException != null && causeMessages.isEmpty()) {
            exceptionCauseBuilder.append(playerErrorException.toString()).append("\n");
        } else {
            for (String cause : causeMessages) {
                exceptionCauseBuilder.append(cause).append("\n");
            }
        }

        if ((error.errorType) instanceof PKPlayerErrorType) {
            PKPlayerErrorType errorType = (PKPlayerErrorType)error.errorType;
            String errorCode = String.valueOf(errorType.errorCode);
            fireFatalError(errorCode, exceptionCauseBuilder.toString() + " - " + exceptionClass, errorMetadata, playerErrorException);
        } else {
            fireFatalError(event.eventType().name(), exceptionCauseBuilder.toString() + " - " + exceptionClass , errorMetadata, playerErrorException);
        }
    }

    public static LinkedHashSet<String> getExceptionMessageChain(Throwable throwable) {
        LinkedHashSet<String> result = new LinkedHashSet<>();
        while (throwable != null) {
            if (throwable.getMessage() != null){
                result.add(throwable.getMessage());
            }
            throwable = throwable.getCause();
        }
        return result;
    }

    @Override
    public void registerListeners() {
        super.registerListeners();
        addListeners();
        isFirstPlay = true;
    }

    private void addListeners() {
        if (messageBus == null) {
            log.e("youbora plugin addListeners ignored, messageBus == null");
            return;
        }

        messageBus.addListener(this, PlayerEvent.playbackInfoUpdated, event -> {
            printReceivedPlayerEvent(event);
            PlaybackInfo currentPlaybackInfo = event.playbackInfo;
            lastReportedBitrate = currentPlaybackInfo.getVideoBitrate();
            lastReportedThroughput = currentPlaybackInfo.getVideoThroughput();
            lastReportedRendition = generateRendition(lastReportedBitrate, (int) currentPlaybackInfo.getVideoWidth(), (int) currentPlaybackInfo.getVideoHeight());
            //log.d("lastReportedRendition = " + lastReportedRendition + " lastReportedBitrate = " + lastReportedBitrate);
            sendReportEvent(event);
        });

        messageBus.addListener(this, PlayerEvent.durationChanged, event -> {
            printReceivedPlayerEvent(event);
            lastReportedMediaDuration = Math.floor((double) event.duration / Consts.MILLISECONDS_MULTIPLIER);
            //log.d("DURATION_CHANGE lastReportedMediaDuration = " + lastReportedMediaDuration);
            sendReportEvent(event);
        });

        messageBus.addListener(this, PlayerEvent.playheadUpdated, event -> {
            lastReportedMediaPosition = Math.floor((double) event.position / Consts.MILLISECONDS_MULTIPLIER);
            lastReportedMediaDuration = Math.floor((double) event.duration / Consts.MILLISECONDS_MULTIPLIER);
            //log.d("PLAYHEAD_UPDATED new position/duration = " + lastReportedMediaPosition + "/" + lastReportedMediaDuration);
        });

        messageBus.addListener(this, PlayerEvent.videoFramesDropped, event -> {
            droppedFrames = event.totalDroppedVideoFrames;
        });

        messageBus.addListener(this, PlayerEvent.stateChanged, event -> {
            printReceivedPlayerEvent(event);
            onStateChangedEvent(event);
        });

        messageBus.addListener(this, PlayerEvent.ended, event -> {
            printReceivedPlayerEvent(event);
            if (isNullAdapter()) {
                return;
            }

            if (PKAdPluginType.server.equals(getLastReportedAdPluginType())) {
                getPlugin().getAdapter().fireStop();
                fireStop();
                isFirstPlay = true;
                adCuePoints = null;
            } else {
                if (!isFirstPlay && ((adCuePoints == null) || !adCuePoints.hasPostRoll())) {
                    fireStop();
                    isFirstPlay = true;
                    adCuePoints = null;
                }
            }

            sendReportEvent(event);
        });

        messageBus.addListener(this, PlayerEvent.tracksAvailable, event -> {
            lastReportedVideoCodecs = getVideoCodecs(event.tracksInfo.getVideoTracks());
            lastReportedAudioCodecs = getAudioCodecs(event.tracksInfo.getAudioTracks());
        });

        messageBus.addListener(this, PlayerEvent.audioTrackChanged, event -> {
            lastReportedAudioCodecs = getAudioCodecs(Collections.singletonList(event.newTrack));
        });

        messageBus.addListener(this, PlayerEvent.videoTrackChanged, event -> {
            lastReportedVideoCodecs = getVideoCodecs(Collections.singletonList(event.newTrack));
        });

        messageBus.addListener(this, PlayerEvent.error, event -> {
            printReceivedPlayerEvent(event);
            PKError error = event.error;
            if (isFatalErrorSent || error != null && !error.isFatal()) {
                log.v("Error eventType = " + error.errorType + " severity = " + error.severity + " errorMessage = " + error.message);
                return;
            }

            sendErrorHandler(event);
            isFatalErrorSent = true;
            adCuePoints = null;
            sendReportEvent(event);
        });

        messageBus.addListener(this, PlayerEvent.pause, event -> {
            firePause();
            sendReportEvent(event);
        });

        messageBus.addListener(this, PlayerEvent.play, event -> {
            printReceivedPlayerEvent(event);
            if (!isFirstPlay) {
                fireResume();
            } else {
                isFirstPlay = false;
                if (getPlugin() != null) {
                    log.d("play event fireInit");
                    getPlugin().fireInit();
                }
            }
            sendReportEvent(event);
        });

        messageBus.addListener(this, PlayerEvent.playing, event -> {
            printReceivedPlayerEvent(event);
            if (isFirstPlay) {
                isFirstPlay = false;
                if (getPlugin() != null) {
                    log.d("playing event fireInit");
                    getPlugin().fireInit();
                }
            }

            fireStart();
            fireJoin();
            sendReportEvent(event);
        });

        messageBus.addListener(this, PlayerEvent.seeked, event -> {
            printReceivedPlayerEvent(event);
            fireSeekEnd();
            sendReportEvent(event);
        });

        messageBus.addListener(this, PlayerEvent.seeking, event -> {
            printReceivedPlayerEvent(event);
            fireSeekBegin();
            sendReportEvent(event);
        });

        messageBus.addListener(this, PlayerEvent.sourceSelected, event -> {
            printReceivedPlayerEvent(event);
            lastReportedResource = event.source.getUrl();
            //log.d("SOURCE_SELECTED lastReportedResource = " + lastReportedResource);
            sendReportEvent(event);
        });

        messageBus.addListener(this, AdEvent.contentPauseRequested, event -> {
            printReceivedAdEvent(event);
            isAdPlaying = true;
        });

        messageBus.addListener(this, AdEvent.started, event -> {
            printReceivedAdEvent(event);
            isAdPlaying = true;
        });

        messageBus.addListener(this, AdEvent.error, event -> {
            printReceivedAdEvent(event);
            isAdPlaying = false;
        });

        messageBus.addListener(this, AdEvent.contentResumeRequested, event -> {
            printReceivedAdEvent(event);
            isAdPlaying = false;
        });

        messageBus.addListener(this, AdEvent.cuepointsChanged, event -> {
            printReceivedAdEvent(event);
            adCuePoints = event.cuePoints;
        });

        messageBus.addListener(this, AdEvent.allAdsCompleted, event -> {
            printReceivedAdEvent(event);
            if (isNullAdapter()) {
                return;
            }

            if (adCuePoints != null && adCuePoints.hasPostRoll()) {
                getPlugin().getAdapter().fireStop();
                isFirstPlay = true;
                adCuePoints = null;
            }
        });
    }

    private String getVideoCodecs(List<VideoTrack> tracks) {
        Set<String> codecs = new LinkedHashSet<>();
        for (VideoTrack track : tracks) {
            if (track.getCodecType() != null && !TextUtils.isEmpty(track.getCodecName())) {
                codecs.add(track.getCodecName());
            }
        }
        if (codecs.size() == 0) {
            codecs.add(PKVideoCodec.AVC.name());
        }
        return codecs.toString();
    }

    private String getAudioCodecs(List<AudioTrack> tracks) {
        Set<String> codecs = new LinkedHashSet<>();
        for (AudioTrack track : tracks) {
            if (track.getCodecType() != null && !TextUtils.isEmpty(track.getCodecName())) {
                codecs.add(track.getCodecName());
            }
        }
        if (codecs.size() == 0) {
            codecs.add(PKAudioCodec.AAC.name());
        }
        return codecs.toString();
    }

    private void printReceivedPlayerEvent(PKEvent event) {
        log.d("Player Event = " + event.eventType().name());
    }

    private void printReceivedAdEvent(PKEvent event) {
        log.d("Ad Event: " + event.eventType().name());
    }

    @Override
    public void unregisterListeners() {
        if (messageBus != null) {
            messageBus.removeListeners(this);
        }
        super.unregisterListeners();
    }


    @Override
    public Long getBitrate() {
        return this.lastReportedBitrate;
    }

    @Override
    public Long getThroughput() {
        return this.lastReportedThroughput;
    }

    @Override
    public String getRendition() {
        return (lastReportedRendition != null) ? lastReportedRendition : super.getRendition();
    }

    public String getKalturaPlayerVersion() {
        return Consts.KALTURA + "-" + PlayKitManager.CLIENT_TAG;
    }

    @Override
    public String getVersion() {
        //getPluginVeriosn
        return com.npaw.youbora.lib6.BuildConfig.VERSION_NAME + "-" + BuildConfig.VERSION_NAME + "-" + getPlayerVersion();
    }

    @Override
    public String getVideoCodec() {
        return (lastReportedVideoCodecs != null) ? lastReportedVideoCodecs : super.getVideoCodec();
    }

    @Override
    public String getAudioCodec() {
        return (lastReportedAudioCodecs != null) ? lastReportedAudioCodecs : super.getAudioCodec();
    }

    @Override
    public String getPlayerVersion() {
        return Consts.KALTURA + "-" + PlayKitManager.CLIENT_TAG;
    }

    @Override
    public String getPlayerName() {
        return KALTURA_ANDROID;
    }

    @Override
    public String getHouseholdId() {
        log.d("Household Id: " + houseHoldId);
        return houseHoldId;
    }

    @Override
    public Double getPlayhead() {
        return (lastReportedMediaPosition != null && lastReportedMediaPosition >= 0) ? lastReportedMediaPosition : 0;
    }

    @Override
    public String getResource() {
        //log.d("getResource = " + lastReportedResource);
        return lastReportedResource;
    }

    @Override
    public Double getDuration() {
        //log.d("getDuration lastReportedMediaDuration = " + lastReportedMediaDuration);
        return (lastReportedMediaDuration != null && lastReportedMediaDuration >= 0) ? lastReportedMediaDuration : 0;
    }

    @Override
    public Integer getDroppedFrames() {
        //log.d("getDroppedFrames " + droppedFrames.intValue());
        return droppedFrames.intValue();
    }

    @Override
    public double getPlayrate() {
        double currentPlaybackRate = 1.0;
        if (getPlayer() != null) {
            if (getPlayer().isPlaying()) {
                currentPlaybackRate = getPlayer().getPlaybackRate();
            } else {
                currentPlaybackRate = 0;
            }
        }
        log.d("getPlayrate currentPlaybackRate = " + currentPlaybackRate + " isNullPlayer = " + (getPlayer() == null));
        return currentPlaybackRate;
    }

    @Override
    public String getTitle() {
        if (mediaConfig == null || mediaConfig.getMediaEntry() == null) {
            return "unknown";
        } else {
            return (!TextUtils.isEmpty(mediaConfig.getMediaEntry().getName())) ? mediaConfig.getMediaEntry().getName() :  mediaConfig.getMediaEntry().getId();
        }
    }

    @Override
    public Boolean getIsLive() {
        Boolean isLive = Boolean.FALSE;
        if (mediaConfig != null && mediaConfig.getMediaEntry() != null && (getPlayer() == null || getPlayer().getDuration() <= 0)) {
            isLive = mediaConfig.getMediaEntry().getMediaType() == PKMediaEntry.MediaEntryType.Live || mediaConfig.getMediaEntry().getMediaType() == PKMediaEntry.MediaEntryType.DvrLive;
        } else if (getPlayer() != null) {
            isLive = getPlayer().isLive();
        }
        return isLive;
    }

    private void sendReportEvent(PKEvent event) {
        if (event.eventType() != PLAYHEAD_UPDATED) {
            String reportedEventName = event.eventType().name();
            if (messageBus != null) {
                messageBus.post(new YouboraEvent.YouboraReport(reportedEventName));
            }
        }
    }

    private PKAdPluginType getLastReportedAdPluginType() {
        if (lastReportedAdPluginType != null) {
            return  lastReportedAdPluginType;
        }

        if (getPlayer() != null) {
            AdController adController = getPlayer().getController(AdController.class);
            if (adController != null && !adController.isAdError()) {
                lastReportedAdPluginType = adController.getAdPluginType();
            } else {
                lastReportedAdPluginType = PKAdPluginType.client;
            }
        }
        return lastReportedAdPluginType;
    }

    private boolean isNullAdapter() {
        if (getPlugin() == null || getPlugin().getAdapter() == null) {
            log.e("Player Adapter is null");
            return true;
        }
        return false;
    }

    public String generateRendition(double bitrate, int width, int height) {

        if ((width <= 0 || height <= 0) && bitrate <= 0) {
            return super.getRendition();
        } else {
            return YouboraUtil.buildRenditionString(width, height, bitrate);
        }
    }

    public void onUpdateConfig() {
        log.d("onUpdateConfig");
        unregisterListeners();
        resetValues();
    }

    public void resetValues() {
        lastReportedBitrate = super.getBitrate();
        lastReportedRendition = super.getRendition();
        lastReportedThroughput = super.getThroughput();
        lastReportedAudioCodecs = super.getAudioCodec();
        lastReportedVideoCodecs = super.getVideoCodec();
        lastReportedAdPluginType = null;
        isFirstPlay = true;
        isFatalErrorSent = false;
    }

    public void resetPlaybackValues() {
        lastReportedMediaDuration = super.getDuration();
        lastReportedMediaPosition =  super.getPlayhead();
        droppedFrames = 0L;
        lastReportedResource = null;
        adCuePoints = null;
        resetValues();
    }

    public void setMediaConfig(PKMediaConfig mediaConfig) {
        this.mediaConfig = mediaConfig;
        updateDurationFromMediaConfig(mediaConfig);
    }

    public void setHouseHoldId(String houseHoldId) {
        this.houseHoldId = houseHoldId;
    }

    public void setLastReportedResource(String lastReportedResource) {
        this.lastReportedResource = lastReportedResource;
    }
}
