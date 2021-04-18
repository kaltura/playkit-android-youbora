package com.kaltura.playkit.plugins.youbora.pluginconfig;

import com.google.gson.annotations.SerializedName;

public class Media {

    private Long contentBitrate;
    private String contentCdn;
    private String contentCdnNode;
    private String contentCdnType;
    private String contentChannel;
    private String contentContractedResolution;
    private String contentCost;

    private String contentDrm;
    @SerializedName(value="contentDuration", alternate={"duration"})
    private Double contentDuration;

    private String contentEncodingAudioCodec;
    private String contentEncodingCodecProfile;
    //private Bundle contentEncodingCodecSettings
    private String contentEncodingContainerFormat;
    private String contentEncodingVideoCodec;
    @SerializedName(value="contentEpisodeTitle", alternate={"title2"})
    private String contentEpisodeTitle;

    private Double contentFps;

    private String contentGenre;
    private String contentGracenoteId;

    private String contentId;
    private String contentImdbId;
    @SerializedName(value="contentIsLive", alternate={"isLive"})
    private Boolean contentIsLive;
    @SerializedName(value="contentIsLiveNoSeek", alternate={"isDVR"})
    private Boolean contentIsLiveNoSeek;

    private String contentLanguage;

    //private Bundle contentMetadata
    //private Bundle contentMetrics;

    private String contentPackage;
    private String contentPlaybackType;
    private String contentPrice;
    private String contentProgram;

    private String contentRendition;
    @SerializedName(value="contentResource", alternate={"resource"})
    private String contentResource;

    private String contentSaga;
    private String contentSeason;
    private String contentStreamingProtocol;
    private String contentSubtitles;

    private Long contentThroughput;
    @SerializedName(value="contentTitle", alternate={"title"})
    private String contentTitle;
    @SerializedName(value="contentTransactionCode", alternate={"transactionCode"})
    private String contentTransactionCode;
    private Long contentTotalBytes;
    private Boolean contentSendTotalBytes;
    private String contentTvShow;
    private String contentType;


    public Long getContentBitrate() {
        return contentBitrate;
    }

    public void setContentBitrate(Long contentBitrate) {
        this.contentBitrate = contentBitrate;
    }

    public String getContentCdn() {
        return contentCdn;
    }

    public void setContentCdn(String contentCdn) {
        this.contentCdn = contentCdn;
    }

    public String getContentCdnNode() {
        return contentCdnNode;
    }

    public void setContentCdnNode(String contentCdnNode) {
        this.contentCdnNode = contentCdnNode;
    }

    public String getContentCdnType() {
        return contentCdnType;
    }

    public void setContentCdnType(String contentCdnType) {
        this.contentCdnType = contentCdnType;
    }

    public String getContentChannel() {
        return contentChannel;
    }

    public void setContentChannel(String contentChannel) {
        this.contentChannel = contentChannel;
    }

    public String getContentContractedResolution() {
        return contentContractedResolution;
    }

    public void setContentContractedResolution(String contentContractedResolution) {
        this.contentContractedResolution = contentContractedResolution;
    }

    public String getContentCost() {
        return contentCost;
    }

    public void setContentCost(String contentCost) {
        this.contentCost = contentCost;
    }

    public String getContentDrm() {
        return contentDrm;
    }

    public void setContentDrm(String contentDrm) {
        this.contentDrm = contentDrm;
    }

    public Double getContentDuration() {
        return contentDuration;
    }

    public void setContentDuration(Double contentDuration) {
        this.contentDuration = contentDuration;
    }

    public String getContentEncodingAudioCodec() {
        return contentEncodingAudioCodec;
    }

    public void setContentEncodingAudioCodec(String contentEncodingAudioCodec) {
        this.contentEncodingAudioCodec = contentEncodingAudioCodec;
    }

    public String getContentEncodingCodecProfile() {
        return contentEncodingCodecProfile;
    }

    public void setContentEncodingCodecProfile(String contentEncodingCodecProfile) {
        this.contentEncodingCodecProfile = contentEncodingCodecProfile;
    }

    public String getContentEncodingContainerFormat() {
        return contentEncodingContainerFormat;
    }

    public void setContentEncodingContainerFormat(String contentEncodingContainerFormat) {
        this.contentEncodingContainerFormat = contentEncodingContainerFormat;
    }

    public String getContentEncodingVideoCodec() {
        return contentEncodingVideoCodec;
    }

    public void setContentEncodingVideoCodec(String contentEncodingVideoCodec) {
        this.contentEncodingVideoCodec = contentEncodingVideoCodec;
    }

    public String getContentEpisodeTitle() {
        return contentEpisodeTitle;
    }

    public void setContentEpisodeTitle(String contentEpisodeTitle) {
        this.contentEpisodeTitle = contentEpisodeTitle;
    }

    public Double getContentFps() {
        return contentFps;
    }

    public void setContentFps(Double contentFps) {
        this.contentFps = contentFps;
    }

    public String getContentGenre() {
        return contentGenre;
    }

    public void setContentGenre(String contentGenre) {
        this.contentGenre = contentGenre;
    }

    public String getContentGracenoteId() {
        return contentGracenoteId;
    }

    public void setContentGracenoteId(String contentGracenoteId) {
        this.contentGracenoteId = contentGracenoteId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContentImdbId() {
        return contentImdbId;
    }

    public void setContentImdbId(String contentImdbId) {
        this.contentImdbId = contentImdbId;
    }

    public Boolean getContentIsLive() {
        return contentIsLive;
    }

    public void setContentIsLive(Boolean contentIsLive) {
        this.contentIsLive = contentIsLive;
    }

    public Boolean getContentIsLiveNoSeek() {
        return contentIsLiveNoSeek;
    }

    public void setContentIsLiveNoSeek(Boolean contentIsLiveNoSeek) {
        this.contentIsLiveNoSeek = contentIsLiveNoSeek;
    }

    public String getContentLanguage() {
        return contentLanguage;
    }

    public void setContentLanguage(String contentLanguage) {
        this.contentLanguage = contentLanguage;
    }

    public String getContentPackage() {
        return contentPackage;
    }

    public void setContentPackage(String contentPackage) {
        this.contentPackage = contentPackage;
    }

    public String getContentPlaybackType() {
        return contentPlaybackType;
    }

    public void setContentPlaybackType(String contentPlaybackType) {
        this.contentPlaybackType = contentPlaybackType;
    }

    public String getContentPrice() {
        return contentPrice;
    }

    public void setContentPrice(String contentPrice) {
        this.contentPrice = contentPrice;
    }

    public String getContentProgram() {
        return contentProgram;
    }

    public void setContentProgram(String contentProgram) {
        this.contentProgram = contentProgram;
    }

    public String getContentRendition() {
        return contentRendition;
    }

    public void setContentRendition(String contentRendition) {
        this.contentRendition = contentRendition;
    }

    public String getContentResource() {
        return contentResource;
    }

    public void setContentResource(String contentResource) {
        this.contentResource = contentResource;
    }

    public String getContentSaga() {
        return contentSaga;
    }

    public void setContentSaga(String contentSaga) {
        this.contentSaga = contentSaga;
    }

    public String getContentSeason() {
        return contentSeason;
    }

    public void setContentSeason(String contentSeason) {
        this.contentSeason = contentSeason;
    }

    public String getContentStreamingProtocol() {
        return contentStreamingProtocol;
    }

    public void setContentStreamingProtocol(String contentStreamingProtocol) {
        this.contentStreamingProtocol = contentStreamingProtocol;
    }

    public String getContentSubtitles() {
        return contentSubtitles;
    }

    public void setContentSubtitles(String contentSubtitles) {
        this.contentSubtitles = contentSubtitles;
    }

    public Long getContentThroughput() {
        return contentThroughput;
    }

    public void setContentThroughput(Long contentThroughput) {
        this.contentThroughput = contentThroughput;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentTransactionCode() {
        return contentTransactionCode;
    }

    public void setContentTransactionCode(String contentTransactionCode) {
        this.contentTransactionCode = contentTransactionCode;
    }

    public Long getContentTotalBytes() {
        return contentTotalBytes;
    }

    public void setContentTotalBytes(Long contentTotalBytes) {
        this.contentTotalBytes = contentTotalBytes;
    }

    public Boolean getContentSendTotalBytes() {
        return contentSendTotalBytes;
    }

    public void setContentSendTotalBytes(Boolean contentSendTotalBytes) {
        this.contentSendTotalBytes = contentSendTotalBytes;
    }

    public String getContentTvShow() {
        return contentTvShow;
    }

    public void setContentTvShow(String contentTvShow) {
        this.contentTvShow = contentTvShow;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}