package com.kaltura.playkit.plugins.youbora.pluginconfig;

import com.google.gson.annotations.SerializedName;

public class App {
    @SerializedName(value="appName", alternate={"name"})
    private String appName = "";

    @SerializedName(value="appReleaseVersion", alternate={"releaseVersion"})
    private String appReleaseVersion = "";

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppReleaseVersion() {
        return appReleaseVersion;
    }

    public void setAppReleaseVersion(String appReleaseVersion) {
        this.appReleaseVersion = appReleaseVersion;
    }
}
