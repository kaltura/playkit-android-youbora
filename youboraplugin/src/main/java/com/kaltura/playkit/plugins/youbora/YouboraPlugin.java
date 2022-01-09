package com.kaltura.playkit.plugins.youbora;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kaltura.playkit.InterceptorEvent;
import com.kaltura.playkit.MessageBus;
import com.kaltura.playkit.PKDrmParams;
import com.kaltura.playkit.PKLog;
import com.kaltura.playkit.PKMediaConfig;
import com.kaltura.playkit.PKPlugin;
import com.kaltura.playkit.Player;
import com.kaltura.playkit.PlayerEvent;
import com.kaltura.playkit.player.AudioTrack;
import com.kaltura.playkit.player.PKTracks;
import com.kaltura.playkit.player.TextTrack;
import com.kaltura.playkit.plugin.youbora.BuildConfig;
import com.kaltura.playkit.plugins.youbora.pluginconfig.YouboraAdAdapterConfig;
import com.kaltura.playkit.plugins.youbora.pluginconfig.YouboraConfig;
import com.npaw.youbora.lib6.adapter.AdAdapter;
import com.npaw.youbora.lib6.comm.transform.ViewTransform;
import com.npaw.youbora.lib6.constants.FastDataConfigFields;
import com.npaw.youbora.lib6.plugin.Options;

import java.util.List;

import static com.kaltura.playkit.plugins.youbora.pluginconfig.YouboraConfig.KEY_HOUSEHOLD_ID;

/**
 * Created by zivilan on 02/11/2016.
 */

public class YouboraPlugin extends PKPlugin {
    private static final PKLog log = PKLog.get("YouboraPlugin");

    private static PKYouboraPlayerAdapter pluginManager;
    private static PKYouboraAdsAdapter adsManager;

    private PKMediaConfig mediaConfig;
    private Options pluginConfig;
    private NPAWPlugin npawPlugin;
    private Player player;
    private MessageBus messageBus;
    private static String houseHoldId;
    private static AdAdapter<Object> customAdAdapter;
    private static ViewTransform.FastDataConfig fastDataConfig;

    private boolean isMonitoring = false;
    private boolean isAdsMonitoring = false;
    private String interceptedCdnCode;

    public static final Factory factory = new Factory() {
        @Override
        public String getName() {
            return "youbora";
        }

        @Override
        public String getVersion() {
            return BuildConfig.VERSION_NAME;
        }

        @Override
        public PKPlugin newInstance() {
            return new YouboraPlugin();
        }

        @Override
        public void warmUp(Context context) {

        }
    };

    @Override
    protected void onLoad(final Player player, Object config, final MessageBus messageBus, Context context) {
        log.d("onLoad");
        this.player = player;
        this.messageBus = messageBus;

        this.pluginConfig = parseConfig(config);
        //YouboraLog.setDebugLevel(YouboraLog.Level.VERBOSE);
        npawPlugin = new NPAWPlugin(pluginConfig, context, fastDataConfig);
        loadPlugin();
    }

    private void loadPlugin() {

        messageBus.addListener(this, PlayerEvent.sourceSelected, event -> {
            PlayerEvent.SourceSelected sourceSelectedEvent = event;
            if (sourceSelectedEvent != null && sourceSelectedEvent.source != null) {
                log.d("YouboraPlugin SOURCE_SELECTED = " + sourceSelectedEvent.source.getUrl());
                if (pluginManager != null) {
                    pluginManager.setLastReportedResource(sourceSelectedEvent.source.getUrl());
                    updateContentDRMScheme(sourceSelectedEvent);
                    updateStreamingProtocol(sourceSelectedEvent);
                }
            }
        });

        messageBus.addListener(this, PlayerEvent.tracksAvailable, event -> {
            if (npawPlugin != null && npawPlugin.getOptions() != null) {
                handleTracksAvailable(event, npawPlugin);
            }
        });

        messageBus.addListener(this, PlayerEvent.textTrackChanged, event -> {
            if (npawPlugin != null && npawPlugin.getOptions() != null) {
                npawPlugin.getOptions().setContentSubtitles(event.newTrack.getLanguage());
            }
        });

        messageBus.addListener(this, PlayerEvent.audioTrackChanged, event -> {
            if (npawPlugin != null && npawPlugin.getOptions() != null) {
                npawPlugin.getOptions().setContentLanguage(event.newTrack.getLanguage());
            }
        });

        messageBus.addListener(this, PlayerEvent.durationChanged, event -> {
            log.d("YouboraPlugin DURATION_CHANGE");
        });

        messageBus.addListener(this, PlayerEvent.stopped, event -> {
            log.d("YouboraPlugin STOPPED");
        });

        messageBus.addListener(this, InterceptorEvent.cdnSwitched, event -> {
            if (npawPlugin != null && npawPlugin.getOptions() != null) {
                log.d("InterceptorEvent.cdnSwitched " + event.getCdnCode());
                interceptedCdnCode = event.getCdnCode();
            }
        });
    }

    private void updateStreamingProtocol(PlayerEvent.SourceSelected sourceSelectedEvent) {
        if (sourceSelectedEvent != null && sourceSelectedEvent.source != null && sourceSelectedEvent.source.getMediaFormat() != null) {
            npawPlugin.getOptions().setContentStreamingProtocol(sourceSelectedEvent.source.getMediaFormat().name().toUpperCase());
        }
    }

    private void updateContentDRMScheme(PlayerEvent.SourceSelected sourceSelectedEvent) {

        String drmSchema = PKDrmParams.Scheme.Unknown.name();
        if (sourceSelectedEvent != null && sourceSelectedEvent.source != null && sourceSelectedEvent.source.hasDrmParams()) {
            List<PKDrmParams> drmParams = sourceSelectedEvent.source.getDrmData();
            if (drmParams != null) {
                for (PKDrmParams params : drmParams) {
                    if (params.isSchemeSupported()) {
                        drmSchema = params.getScheme().name();
                        break;
                    }
                }
            }
        } else {
            drmSchema = "Clear";
        }
        if (npawPlugin != null && npawPlugin.getOptions() != null && npawPlugin.getOptions().getContentDrm() == null) {
            log.d("YouboraPlugin ContentDrm = " + drmSchema);
            npawPlugin.getOptions().setContentDrm(drmSchema);
        }
    }

    @Override
    protected void onUpdateMedia(PKMediaConfig mediaConfig) {
        if (pluginManager != null) {
            pluginManager.onUpdateConfig();
            if (adsManager != null) {
                adsManager.onUpdateConfig();
            }
        }

        stopMonitoring();
        log.d("youbora - onUpdateMedia");

        this.mediaConfig = mediaConfig;
        // Refresh options with updated media
        if (!isMonitoring) {
            isMonitoring = true;
            if (pluginManager == null) {
                pluginManager = new PKYouboraPlayerAdapter(player, messageBus, mediaConfig, houseHoldId);
            } else {
                pluginManager.setPlayer(player);
                pluginManager.resetPlaybackValues();
                pluginManager.registerListeners();
            }
            addKalturaInfoProperty(mediaConfig);
            pluginManager.setMediaConfig(mediaConfig);
            pluginManager.setHouseHoldId(houseHoldId);
        }

        npawPlugin.setOptions(pluginConfig);
        npawPlugin.setAdapter(pluginManager);

        if (!isAdsMonitoring) {
            if (adsManager == null) {
                adsManager = new PKYouboraAdsAdapter(player, messageBus);
            } else {
                adsManager.setPlayer(player);
                adsManager.resetAdValues();
                adsManager.registerListeners();
            }
            if (customAdAdapter != null) {
                npawPlugin.setAdsAdapter(customAdAdapter);
            } else {
                npawPlugin.setAdsAdapter(adsManager);
            }

            isAdsMonitoring = true;
        }
    }

    private void addKalturaInfoProperty(PKMediaConfig mediaConfig) {
        if (npawPlugin != null &&
                npawPlugin.getOptions() != null &&
                npawPlugin.getOptions().getContentMetadata() != null &&
                player != null &&
                mediaConfig != null &&
                mediaConfig.getMediaEntry() != null &&
                mediaConfig.getMediaEntry().getMetadata() != null
        ) {
            Bundle kalturaInfoBundle = new Bundle();
            String entryId = mediaConfig.getMediaEntry().getMetadata().get("entryId");
            if (TextUtils.isEmpty(entryId)) {
                entryId = mediaConfig.getMediaEntry().getId();
            }
            kalturaInfoBundle.putString("entryId", entryId);
            kalturaInfoBundle.putString("sessionId", player.getSessionId());
            npawPlugin.getOptions().getContentMetadata().putBundle("kalturaInfo", kalturaInfoBundle);
        }
    }

    @Override
    protected void onUpdateConfig(Object config) {
        log.d("youbora - onUpdateConfig");
        if (config == null) {
            return;
        }

        this.pluginConfig = parseConfig(config);
        // Refresh options with updated media
        if (npawPlugin != null && pluginConfig != null) {
            if (!TextUtils.isEmpty(interceptedCdnCode)) {
                // If intercepted cdn code is there from smart switch then update it
                this.pluginConfig.setContentCdn(interceptedCdnCode);
            }
            npawPlugin.setOptions(pluginConfig);
        }

        interceptedCdnCode = null;
    }

    @Override
    protected void onApplicationPaused() {
        log.d("YOUBORA onApplicationPaused");
        if (npawPlugin != null) {
            if (npawPlugin.getAdsAdapter() != null) {
                npawPlugin.getAdsAdapter().fireStop();
            }
            if (adsManager != null) {
                adsManager.resetAdValues();
            }
            if (npawPlugin.getAdapter() != null) {
                npawPlugin.getAdapter().fireStop();
            }
            if (pluginManager != null) {
                pluginManager.resetValues();
            }
        }
    }

    @Override
    protected void onApplicationResumed() {
        log.d("YOUBORA onApplicationResumed");
    }

    @Override
    public void onDestroy() {
        if (isMonitoring) {
            stopMonitoring();
        }
        if (messageBus != null) {
            messageBus.removeListeners(this);
        }
        if (pluginManager != null) {
            pluginManager.unregisterListeners();
            pluginManager = null;
        }
        if (adsManager != null) {
            adsManager.unregisterListeners();
            adsManager = null;
        }
    }

    private void stopMonitoring() {
        log.d("stop monitoring");
        if (npawPlugin != null) {
            if (isAdsMonitoring) {
                if (npawPlugin.getAdsAdapter() != null) {
                    npawPlugin.removeAdsAdapter();
                }
                isAdsMonitoring = false;
            }
            if (isMonitoring) {
                if (npawPlugin.getAdapter() != null) {
                    npawPlugin.removeAdapter();
                }
                isMonitoring = false;
            }
        }
    }

    /**
     * Player tracks available handler.
     *
     * @param event =  TracksAvailable event.
     */
    private void handleTracksAvailable(PlayerEvent.TracksAvailable event, NPAWPlugin npawPlugin) {
        PKTracks trackInfo = event.tracksInfo;
        if (trackInfo != null) {
            List<AudioTrack> trackInfoAudioTracks = trackInfo.getAudioTracks();
            int defaultAudioTrackIndex = trackInfo.getDefaultAudioTrackIndex();
            if (defaultAudioTrackIndex < trackInfoAudioTracks.size() && trackInfoAudioTracks.get(defaultAudioTrackIndex) != null) {
                npawPlugin.getOptions().setContentLanguage(trackInfoAudioTracks.get(defaultAudioTrackIndex).getLanguage());
            }

            List<TextTrack> trackInfoTextTracks = trackInfo.getTextTracks();
            int defaultTextTrackIndex = trackInfo.getDefaultTextTrackIndex();
            if (defaultTextTrackIndex < trackInfoTextTracks.size() && trackInfoTextTracks.get(defaultTextTrackIndex) != null) {
                npawPlugin.getOptions().setContentSubtitles(trackInfoTextTracks.get(defaultTextTrackIndex).getLanguage());
            }
        }
    }

    private static Options parseConfig(Object config) {
        if (config instanceof YouboraConfig) {
            houseHoldId = ((YouboraConfig) config).getHouseHoldId();
            fastDataConfig = ((YouboraConfig) config).getFastDataConfig();
            return ((YouboraConfig) config).getYouboraOptions();
        } else if (config instanceof JsonObject) {
            YouboraConfig youboraConfig = new Gson().fromJson(((JsonObject) config), YouboraConfig.class);
            houseHoldId = youboraConfig.getHouseHoldId();
            fastDataConfig = youboraConfig.getFastDataConfig();
            return youboraConfig.getYouboraOptions();
        } else if (config instanceof Bundle) {
            Bundle configBundle = (Bundle) config;
            Options options = new Options(configBundle);
            houseHoldId = ((Bundle) config).getString(KEY_HOUSEHOLD_ID);
            fillFastDataConfig(configBundle);
            return options;
        } else if (config instanceof YouboraAdAdapterConfig) {
            YouboraAdAdapterConfig adAdapterConfig = (YouboraAdAdapterConfig) config;
            Options options = new Options(adAdapterConfig.getOptBundle());
            houseHoldId = adAdapterConfig.getOptBundle().getString(KEY_HOUSEHOLD_ID);
            customAdAdapter = adAdapterConfig.getCustomAdsAdapter();
            fillFastDataConfig(adAdapterConfig.getOptBundle());
            return options;
        }
        return null;
    }

    private static void fillFastDataConfig(Bundle configBundle) {

        fastDataConfig = null;
        if (configBundle == null) {
            return;
        }

        fastDataConfig = new ViewTransform.FastDataConfig();
        fastDataConfig.host = configBundle.getString(FastDataConfigFields.FASTDATA_CONFIG_HOST);
        fastDataConfig.code = configBundle.getString(FastDataConfigFields.FASTDATA_CONFIG_CODE);
        fastDataConfig.pingTime = configBundle.getInt(FastDataConfigFields.FASTDATA_CONFIG_PINGTIME);
        fastDataConfig.beatTime = configBundle.getInt(FastDataConfigFields.FASTDATA_CONFIG_BEATTIME);
        fastDataConfig.expirationTime = configBundle.getInt(FastDataConfigFields.FASTDATA_CONFIG_EXPIRATIONTIME);
    }
}

