package com.kaltura.playkit.plugins.youbora.pluginconfig;

public class Network {
    /**
     * See a list of codes in <a href="http://mapi.youbora.com:8081/connectionTypes">
     * http://mapi.youbora.com:8081/connectionTypes</a>.
     */
    private String networkConnectionType;

    /**
     * IP of the viewer/user, e.g. "48.15.16.23".
     */
    private String networkIP;

    /**
     * Name of the internet service provider of the viewer/user.
     */
    private String networkIsp;


    public String getNetworkConnectionType() {
        return networkConnectionType;
    }

    public void setNetworkConnectionType(String networkConnectionType) {
        this.networkConnectionType = networkConnectionType;
    }

    public String getNetworkIP() {
        return networkIP;
    }

    public void setNetworkIP(String networkIP) {
        this.networkIP = networkIP;
    }

    public String getNetworkIsp() {
        return networkIsp;
    }

    public void setNetworkIsp(String networkIsp) {
        this.networkIsp = networkIsp;
    }
}
