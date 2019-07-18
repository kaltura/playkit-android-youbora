package com.kaltura.playkit.plugins.youbora;

import android.content.Context;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kaltura.playkit.MessageBus;
import com.kaltura.playkit.PKLog;
import com.kaltura.playkit.PKMediaConfig;
import com.kaltura.playkit.PKPlugin;
import com.kaltura.playkit.Player;
import com.kaltura.playkit.PlayerEvent;
import com.kaltura.playkit.plugin.youbora.BuildConfig;
import com.kaltura.playkit.plugins.youbora.pluginconfig.YouboraConfig;
import com.npaw.youbora.lib6.plugin.Options;

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

    private boolean isMonitoring = false;
    private boolean isAdsMonitoring = false;

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
        npawPlugin = new NPAWPlugin(pluginConfig);
        loadPlugin();
    }

    private void loadPlugin() {

        messageBus.addListener(this, PlayerEvent.sourceSelected, event -> {
            PlayerEvent.SourceSelected sourceSelected = event;
            if (sourceSelected != null && sourceSelected.source != null) {
                log.d("YouboraPlugin SOURCE_SELECTED = " + sourceSelected.source.getUrl());
                if (pluginManager != null) {
                    pluginManager.setLastReportedResource(sourceSelected.source.getUrl());
                }
            }
        });

        messageBus.addListener(this, PlayerEvent.durationChanged, event -> {
            log.d("YouboraPlugin DURATION_CHANGE");
        });

        messageBus.addListener(this, PlayerEvent.stopped, event -> {
            log.d("YouboraPlugin STOPPED");
        });
    }

    @Override
    protected void onUpdateMedia(PKMediaConfig mediaConfig) {
        stopMonitoring();
        log.d("youbora - onUpdateMedia");

        this.mediaConfig = mediaConfig;
        // Refresh options with updated media
        if (!isMonitoring) {
            isMonitoring = true;
            if (pluginManager == null) {
                pluginManager = new PKYouboraPlayerAdapter(player, messageBus, mediaConfig, houseHoldId);
            } else {
                pluginManager.resetPlaybackValues();
                pluginManager.registerListeners();
            }
            pluginManager.setMediaConfig(mediaConfig);
            pluginManager.setHouseHoldId(houseHoldId);
        }

        npawPlugin.setOptions(pluginConfig);
        npawPlugin.setAdapter(pluginManager);

        if (!isAdsMonitoring) {
            if (adsManager == null) {
                adsManager = new PKYouboraAdsAdapter(player, messageBus);
            } else {
                adsManager.resetAdValues();
                adsManager.registerListeners();
            }
            npawPlugin.setAdsAdapter(adsManager);
            isAdsMonitoring = true;
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
            npawPlugin.setOptions(pluginConfig);
        }

        if (pluginManager == null) {
            return;
        }
        pluginManager.onUpdateConfig();
        if (adsManager != null) {
            adsManager.onUpdateConfig();
        }

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

    private static Options parseConfig(Object config) {
        if (config instanceof YouboraConfig) {
            houseHoldId = ((YouboraConfig) config).getHouseHoldId();
            return ((YouboraConfig) config).getYouboraOptions();
        } else if (config instanceof JsonObject) {
            YouboraConfig youboraConfig = new Gson().fromJson(((JsonObject) config), YouboraConfig.class);
            houseHoldId = youboraConfig.getHouseHoldId();
            return youboraConfig.getYouboraOptions();
        } else if (config instanceof Bundle) {
            Options options = new Options((Bundle) config);
            houseHoldId = ((Bundle) config).getString(KEY_HOUSEHOLD_ID);
            return options;
        }
        return null;
    }
}
