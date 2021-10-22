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

import com.kaltura.playkit.BuildConfig;
import com.kaltura.playkit.MessageBus;
import com.kaltura.playkit.PKError;
import com.kaltura.playkit.PKEvent;
import com.kaltura.playkit.PKLog;
import com.kaltura.playkit.PlayKitManager;
import com.kaltura.playkit.Player;
import com.kaltura.playkit.ads.AdController;
import com.kaltura.playkit.ads.PKAdErrorType;
import com.kaltura.playkit.ads.PKAdPluginType;
import com.kaltura.playkit.plugins.ads.AdEvent;
import com.kaltura.playkit.plugins.ads.AdInfo;
import com.kaltura.playkit.plugins.ads.AdPositionType;
import com.kaltura.playkit.utils.Consts;
import com.npaw.youbora.lib6.adapter.AdAdapter;

/**
 * @hide
 */

class PKYouboraAdsAdapter extends AdAdapter<Player> {
    private static final PKLog log = PKLog.get("PKYouboraAdsAdapter");

    private boolean isFirstPlay = true;
    private boolean isBuffering = false;
    private MessageBus messageBus;

    private AdInfo currentAdInfo;
    private String lastReportedAdResource;
    private String lastReportedAdTitle;
    private Double lastReportedAdPlayhead;
    private Double lastReportedAdDuration;
    private long lastReportedAdBitrate;
    private PKAdPluginType lastReportedAdPluginType;

    PKYouboraAdsAdapter(Player player, MessageBus messageBus) {
        super(player);
        this.messageBus = messageBus;
        registerListeners();
    }

    @Override
    public void registerListeners() {
        super.registerListeners();
        addListeners();
    }

    private void printLastReportedAdPlayhead() {
        log.d("lastReportedAdPlayhead = " + lastReportedAdPlayhead);
    }

    private void printEventName(PKEvent event) {
        log.d("PKYouboraAdsAdapter on event " + event.eventType());
    }

    private boolean isNullAdapter() {
        if (getPlugin() == null || getPlugin().getAdapter() == null) {
            log.e("Player Adapter is null");
            return true;
        }
        return false;
    }

    private void sendReportEvent(Enum anEnum) {
        messageBus.post(new YouboraEvent.YouboraReport(anEnum.name()));
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
        return lastReportedAdBitrate;
    }

    @Override
    public String getTitle() {
        //log.d("getAdTitle ");
        return lastReportedAdTitle != null ? lastReportedAdTitle : "No Info";
    }

    @Override
    public Double getDuration() {
        double adDuration = currentAdInfo != null ? currentAdInfo.getAdDuration() / Consts.MILLISECONDS_MULTIPLIER : 0D;
        return adDuration;
    }

    @Override
    public String getPlayerVersion() {
        //log.d("getAdPlayerVersion " + PlayKitManager.CLIENT_TAG);
        return Consts.KALTURA + "-" + PlayKitManager.CLIENT_TAG;
    }

    @Override
    public String getVersion() {
        return BuildConfig.VERSION_NAME + "-" + getPlayerVersion();
    }

    @Override
    public Double getPlayhead() {
        log.d("getAdPlayhead = " + lastReportedAdPlayhead);
        return lastReportedAdPlayhead;
    }

    @Override
    public AdPosition getPosition() {
        AdPosition adPosition = AdPosition.UNKNOWN;

        if (currentAdInfo == null) {
            return adPosition;
        }

        switch (currentAdInfo.getAdPositionType()) {
            case PRE_ROLL:
                adPosition = AdPosition.PRE;
                break;
            case MID_ROLL:
                adPosition = AdPosition.MID;
                break;
            case POST_ROLL:
                adPosition = AdPosition.POST;
                break;
            default:
                break;
        }
        //log.d("adPosition = " + adPosition);
        return adPosition;
    }

    @Override
    public String getResource() {
        log.d("getAdResource = " + lastReportedAdResource);
        return lastReportedAdResource;
    }

    private void populateAdValues() {
        if (currentAdInfo == null) {
            return;
        }

        lastReportedAdDuration = Long.valueOf(currentAdInfo.getAdDuration() / Consts.MILLISECONDS_MULTIPLIER).doubleValue();
        lastReportedAdTitle = currentAdInfo.getAdTitle();
        lastReportedAdPlayhead = Long.valueOf(currentAdInfo.getAdPlayHead() / Consts.MILLISECONDS_MULTIPLIER).doubleValue();
        lastReportedAdBitrate = currentAdInfo.getMediaBitrate();
        log.d("lastReportedAdResource: " + lastReportedAdResource);
        log.d("lastReportedAdDuration: " + lastReportedAdDuration);
        log.d("lastReportedAdTitle: " + lastReportedAdTitle);
        log.d("lastReportedAdPlayhead: " + lastReportedAdPlayhead);
        log.d("lastReportedAdBitrate: " + lastReportedAdBitrate);
    }

    void resetAdValues() {
        isFirstPlay = true;
        currentAdInfo = null;
        lastReportedAdDuration = super.getDuration();
        lastReportedAdTitle = super.getTitle();
        lastReportedAdPlayhead = super.getPlayhead();
        lastReportedAdPluginType = null;
    }

    public void onUpdateConfig() {
        unregisterListeners();
        resetAdValues();
        lastReportedAdBitrate = -1L;
        lastReportedAdResource = super.getResource();
    }

    public void setLastAdResource(String lastReportedAdResource) {
        this.lastReportedAdResource = lastReportedAdResource;
    }

    private void addListeners() {
        messageBus.addListener(this, AdEvent.adRequested, event -> {
            printEventName(event);
            lastReportedAdResource = event.adTagUrl;
            log.d("lastReportedAdResource: " + lastReportedAdResource);
            if (isNullAdapter()) {
                return;
            }
            if (event.isAutoPlay) {
                getPlugin().fireInit();
                getPlugin().getAdapter().fireStart();
            }
            sendReportEvent(event.eventType());
        });

        messageBus.addListener(this, AdEvent.adBreakStarted, event -> {
            if(currentAdInfo != null && currentAdInfo.getAdPositionType() != AdPositionType.PRE_ROLL) {
                fireAdBreakStart();
            }
        });

        messageBus.addListener(this, AdEvent.adBreakEnded, event -> {
            fireAdBreakStop();
        });

        messageBus.addListener(this, AdEvent.loaded, event -> {
            printEventName(event);
            if (isNullAdapter()) {
                return;
            }
            log.d("AD LOADED: isFirstPlay = " + isFirstPlay);
            if (isFirstPlay) {
                isFirstPlay = false;
                if (PKAdPluginType.server.equals(getLastReportedAdPluginType())) {
                    getPlugin().fireInit();
                    getPlugin().getAdapter().fireStart();
                    getPlugin().getAdapter().fireJoin();
                }
            }
            currentAdInfo = event.adInfo;
            populateAdValues();
            if (PKAdPluginType.server.equals(getLastReportedAdPluginType())) {
                getPlugin().fireInit();
                getPlugin().getAdapter().fireStart();
            }
            sendReportEvent(event.eventType());
        });

        messageBus.addListener(this, AdEvent.started, event -> {
            printEventName(event);
            if (isNullAdapter()) {
                return;
            }
            currentAdInfo = event.adInfo;
            lastReportedAdPlayhead = Long.valueOf(currentAdInfo.getAdPlayHead() / Consts.MILLISECONDS_MULTIPLIER).doubleValue();
            lastReportedAdBitrate = currentAdInfo.getMediaBitrate();
            log.d("lastReportedAdPlayhead: " + lastReportedAdPlayhead);
            fireStart();
            fireJoin();
            sendReportEvent(event.eventType());
        });

        messageBus.addListener(this, AdEvent.paused, event -> {
            printEventName(event);
            if (isNullAdapter()) {
                return;
            }

            currentAdInfo = event.adInfo;
            lastReportedAdPlayhead = Long.valueOf(currentAdInfo.getAdPlayHead() / Consts.MILLISECONDS_MULTIPLIER).doubleValue();
            lastReportedAdBitrate = currentAdInfo.getMediaBitrate();
            log.d("lastReportedAdPlayhead: " + lastReportedAdPlayhead);
            firePause();
            sendReportEvent(event.eventType());
        });

        messageBus.addListener(this, AdEvent.resumed, event -> {
            printEventName(event);
            if (isNullAdapter()) {
                return;
            }
            currentAdInfo = event.adInfo;
            lastReportedAdPlayhead = Long.valueOf(currentAdInfo.getAdPlayHead() / Consts.MILLISECONDS_MULTIPLIER).doubleValue();
            lastReportedAdBitrate = currentAdInfo.getMediaBitrate();
            log.d("lastReportedAdPlayhead: " + lastReportedAdPlayhead);
            fireResume();
            sendReportEvent(event.eventType());
        });

        messageBus.addListener(this, AdEvent.completed, event -> {
            printEventName(event);
            if (isNullAdapter()) {
                return;
            }
            lastReportedAdPlayhead = lastReportedAdDuration;
            log.d("lastReportedAdPlayhead: " + lastReportedAdPlayhead);
            fireStop();
            sendReportEvent(event.eventType());
        });

        messageBus.addListener(this, AdEvent.adBreakIgnored, event -> {
            printEventName(event);
            if (isNullAdapter()) {
                return;
            }
            fireStop();
            sendReportEvent(event.eventType());
        });

        messageBus.addListener(this, AdEvent.contentResumeRequested, event -> {
            printEventName(event);
            if (isNullAdapter()) {
                return;
            }
            fireStop();
            sendReportEvent(event.eventType());
        });

        messageBus.addListener(this, AdEvent.skipped, event -> {
            printEventName(event);
            if (isNullAdapter()) {
                return;
            }
            currentAdInfo = event.adInfo;
            lastReportedAdPlayhead = Long.valueOf(currentAdInfo.getAdPlayHead() / Consts.MILLISECONDS_MULTIPLIER).doubleValue();
            printLastReportedAdPlayhead();
            //fireStop(new HashMap<String, String>(){{put("skipped","true");}});
            fireSkip();
            sendReportEvent(event.eventType());
        });

        messageBus.addListener(this, AdEvent.firstQuartile, event -> {
            fireQuartile(1);
        });

        messageBus.addListener(this, AdEvent.midpoint, event -> {
            fireQuartile(2);
        });

        messageBus.addListener(this, AdEvent.thirdQuartile, event -> {
            fireQuartile(3);
        });

        messageBus.addListener(this, AdEvent.error, event -> {
            printEventName(event);
            if (isNullAdapter()) {
                return;
            }
            log.e("ERROR " + event.error.errorType);
            handleAdError(event.error);
            sendReportEvent(event.eventType());
        });

        messageBus.addListener(this, AdEvent.adClickedEvent, event -> {
            printEventName(event);
            if (isNullAdapter()) {
                return;
            }
            if (event.clickThruUrl != null) {
                fireClick(event.clickThruUrl);
            }
            sendReportEvent(event.eventType());
        });

        messageBus.addListener(this, AdEvent.playHeadChanged, event -> {
            lastReportedAdPlayhead = Long.valueOf(event.adPlayHead).doubleValue();
            //We are not sending this event to youbora,
            //so prevent it from dispatching through YouboraEvent.YouboraReport.
        });

        messageBus.addListener(this, AdEvent.adProgress, event -> {
            //We are not sending this event to youbora,
            //so prevent it from dispatching through YouboraEvent.YouboraReport.
        });

        messageBus.addListener(this, AdEvent.adBufferStart, event -> {
            printEventName(event);
            if (isNullAdapter()) {
                return;
            }
            
            getPlugin().getAdapter().fireStart();
            fireStart();
            printLastReportedAdPlayhead();
            fireBufferBegin();
            sendReportEvent(event.eventType());
        });

        messageBus.addListener(this, AdEvent.adBufferEnd, event -> {
            printEventName(event);
            if (isNullAdapter()) {
                return;
            }
            printLastReportedAdPlayhead();
            fireBufferEnd();
            sendReportEvent(event.eventType());
        });

        messageBus.addListener(this, AdEvent.allAdsCompleted, event -> {
            printEventName(event);
            if (isNullAdapter()) {
                return;
            }
            printLastReportedAdPlayhead();
            sendReportEvent(event.eventType());
        });
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

    private void handleAdError(PKError error) {

        PKAdErrorType adErrorType = (PKAdErrorType) error.errorType;

        if (adErrorType == PKAdErrorType.QUIET_LOG_ERROR) {
            log.d("QUIET_LOG_ERROR. Avoid sending to Youbora.");
            fireError(error.message, PKAdErrorType.QUIET_LOG_ERROR.name(), null, null);
            return;
        } else {
            log.e("onAdError " + adErrorType.name());
            Exception adException = null;
            if (error.exception instanceof Exception) {
                adException = (Exception) error.exception;
            }
            fireFatalError(String.valueOf(adErrorType.errorCode), error.message, adErrorType.name(), adException);
        }
        sendReportEvent(adErrorType);
    }
}
