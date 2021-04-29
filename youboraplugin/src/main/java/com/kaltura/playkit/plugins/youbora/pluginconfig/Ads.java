package com.kaltura.playkit.plugins.youbora.pluginconfig;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Ads {

    private ArrayList<Integer> adBreaksTime;
    @SerializedName(value="adCampaign", alternate={"campaign"})
    private String adCampaign;
    private String adCreativeId;
    private Integer adExpectedBreaks;
    //private Bundle adExpectedPattern;
    private Integer givenAds;
    private Integer adGivenBreaks;
    //private Bundle adMetadata;
    private String adProvider;
    private String adResource;
    private String adTitle;

    @SerializedName(value="adCustomDimensions", alternate={"extraParams"})
    private AdCustomDimensions adCustomDimensions;

    public ArrayList<Integer> getAdBreaksTime() {
        return adBreaksTime;
    }

    public void setAdBreaksTime(ArrayList<Integer> adBreaksTime) {
        this.adBreaksTime = adBreaksTime;
    }

    public String getAdCampaign() {
        return adCampaign;
    }

    public void setAdCampaign(String adCampaign) {
        this.adCampaign = adCampaign;
    }

    public String getAdCreativeId() {
        return adCreativeId;
    }

    public void setAdCreativeId(String adCreativeId) {
        this.adCreativeId = adCreativeId;
    }

    public Integer getAdExpectedBreaks() {
        return adExpectedBreaks;
    }

    public void setAdExpectedBreaks(Integer adExpectedBreaks) {
        this.adExpectedBreaks = adExpectedBreaks;
    }

    public Integer getGivenAds() {
        return givenAds;
    }

    public void setGivenAds(Integer givenAds) {
        this.givenAds = givenAds;
    }

    public Integer getAdGivenBreaks() {
        return adGivenBreaks;
    }

    public void setAdGivenBreaks(Integer adGivenBreaks) {
        this.adGivenBreaks = adGivenBreaks;
    }

    public String getAdProvider() {
        return adProvider;
    }

    public void setAdProvider(String adProvider) {
        this.adProvider = adProvider;
    }

    public String getAdResource() {
        return adResource;
    }

    public void setAdResource(String adResource) {
        this.adResource = adResource;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public AdCustomDimensions getAdCustomDimensions() {
        return adCustomDimensions;
    }

    public void setAdCustomDimensions(AdCustomDimensions adCustomDimensions) {
        this.adCustomDimensions = adCustomDimensions;
    }
}