package com.kaltura.playkit.plugins.youbora.pluginconfig;

import java.util.ArrayList;

public class Parse {

    private Boolean parseManifest;
    private Boolean parseCdnNode;
    private Boolean parseCdnSwitchHeader;
    private ArrayList<String> cdnNodeList;
    private String cdnNameHeaders;
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

    public ArrayList<String> getCdnNodeList() {
        return cdnNodeList;
    }

    public void setCdnNodeList(ArrayList<String> cdnNodeList) {
        this.cdnNodeList = cdnNodeList;
    }

    public String getCdnNameHeaders() {
        return cdnNameHeaders;
    }

    public void setCdnNameHeaders(String cdnNameHeaders) {
        this.cdnNameHeaders = cdnNameHeaders;
    }

    public Integer getParseCdnTTL() {
        return parseCdnTTL;
    }

    public void setParseCdnTTL(Integer parseCdnTTL) {
        this.parseCdnTTL = parseCdnTTL;
    }
}
