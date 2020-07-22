package com.kaltura.playkit.plugins.youbora.pluginconfig;

import android.os.Bundle;

import com.npaw.youbora.lib6.adapter.AdAdapter;

public class YouboraAdAdapterConfig {

    private AdAdapter<Object> adAdapter;

    private Bundle optBundle;

    public YouboraAdAdapterConfig(AdAdapter<Object> adAdapter, Bundle optBundle) {
        this.adAdapter = adAdapter;
        this.optBundle = optBundle;
    }

    public void setCustomAdsAdapter(AdAdapter<Object> adAdapter) {
        this.adAdapter = adAdapter;
    }

    public AdAdapter<Object> getCustomAdsAdapter() {
        return adAdapter;
    }

    public Bundle getOptBundle() {
        return optBundle;
    }

    public void setOptBundle(Bundle optBundle) {
        this.optBundle = optBundle;
    }
}
