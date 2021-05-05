package com.kaltura.playkit.plugins.youbora.pluginconfig;

import java.util.ArrayList;

public class Parse {

    private Boolean parseManifest;
    private Boolean parseCdnNode;
    private Boolean parseCdnSwitchHeader;
    private ArrayList<String> parseCdnNodeList;
    private String parseCdnNameHeader;
    private Integer parseCdnTTL;

    public Boolean getParseManifest() {
        return parseManifest;
    }

    public void setParseManifest(Boolean parseManifest) {
        this.parseManifest = parseManifest;
    }

    public Boolean getParseCdnNode() {
        return parseCdnNode;
    }

    public void setParseCdnNode(Boolean parseCdnNode) {
        this.parseCdnNode = parseCdnNode;
    }

    public Boolean getParseCdnSwitchHeader() {
        return parseCdnSwitchHeader;
    }

    public void setParseCdnSwitchHeader(Boolean parseCdnSwitchHeader) {
        this.parseCdnSwitchHeader = parseCdnSwitchHeader;
    }

    public ArrayList<String> getParseCdnNodeList() {
        return parseCdnNodeList;
    }

    public void setParseCdnNodeList(ArrayList<String> parseCdnNodeList) {
        this.parseCdnNodeList = parseCdnNodeList;
    }

    public String getParseCdnNameHeader() {
        return parseCdnNameHeader;
    }

    public void setParseCdnNameHeader(String parseCdnNameHeader) {
        this.parseCdnNameHeader = parseCdnNameHeader;
    }

    public Integer getParseCdnTTL() {
        return parseCdnTTL;
    }

    public void setParseCdnTTL(Integer parseCdnTTL) {
        this.parseCdnTTL = parseCdnTTL;
    }
}
