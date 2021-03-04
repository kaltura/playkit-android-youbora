package com.kaltura.playkit.plugins.youbora.pluginconfig;

import android.os.Bundle;

public class YouboraSmartSwitchConfig {

    private SmartSwitchInfo smartSwitchInfo;
    private Bundle optBundle;

    public YouboraSmartSwitchConfig() {}

    public YouboraSmartSwitchConfig(SmartSwitchInfo smartSwitchInfo, Bundle optBundle) {
        this.smartSwitchInfo = smartSwitchInfo;
        this.optBundle = optBundle;
    }

    public SmartSwitchInfo getSmartSwitchInfo() {
        return smartSwitchInfo;
    }

    public Bundle getOptBundle() {
        return optBundle;
    }

    public void setSmartSwitchInfo(SmartSwitchInfo smartSwitchInfo) {
        this.smartSwitchInfo = smartSwitchInfo;
    }

    public void setOptBundle(Bundle optBundle) {
        this.optBundle = optBundle;
    }

}
