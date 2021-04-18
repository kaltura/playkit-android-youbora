package com.kaltura.playkit.plugins.youbora.pluginconfig;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import com.npaw.youbora.lib6.comm.transform.ViewTransform;
import com.npaw.youbora.lib6.plugin.Options;

public class YouboraConfig {

    // Kaltura Youbora Keys for Bundle

    public static final String KEY_HOUSEHOLD_ID = "houseHoldId";

    public static final String KEY_CONTENT_METADATA_YEAR = "year";

    public static final String KEY_CONTENT_METADATA_CAST = "cast";

    public static final String KEY_CONTENT_METADATA_DIRECTOR = "director";

    public static final String KEY_CONTENT_METADATA_OWNER = "owner";

    public static final String KEY_CONTENT_METADATA_PARENTAL = "parental";

    public static final String KEY_CONTENT_METADATA_RATING = "rating";

    private String accountCode;

    private String username;

    private String userEmail;

    private String userAnonymousId;

    private String userType;        // any string - free / paid etc.

    private String houseHoldId;    // which device is used to play

    private boolean userObfuscateIp; // Option to obfuscate the IP.

    private boolean httpSecure = true; // youbora events will be sent via https

    private String appName = "";

    private String appReleaseVersion = "";

    private Parse parse;

    private Device device;

    @SerializedName(value="content", alternate={"media"})
    private Content content;

    private Ads ads;

    private Properties properties;

    private ExtraParams extraParams;

    private ViewTransform.FastDataConfig fastDataConfig;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAnonymousId() {
        return userAnonymousId;
    }

    public void setUserAnonymousId(String userAnonymousId) {
        this.userAnonymousId = userAnonymousId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean getHttpSecure() {
        return httpSecure;
    }

    public void setHttpSecure(boolean httpSecure) {
        this.httpSecure = httpSecure;
    }

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

    public String getHouseHoldId() {
        return houseHoldId;
    }

    public void setHouseHoldId(String houseHoldId) {
        this.houseHoldId = houseHoldId;
    }

    public boolean isUserObfuscateIp() {
        return userObfuscateIp;
    }

    public void setUserObfuscateIp(boolean userObfuscateIp) {
        this.userObfuscateIp = userObfuscateIp;
    }

    public Parse getParse() {
        return parse;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Ads getAds() {
        return ads;
    }

    public void setAds(Ads ads) {
        this.ads = ads;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public ExtraParams getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(ExtraParams extraParams) {
        this.extraParams = extraParams;
    }

    public ViewTransform.FastDataConfig getFastDataConfig() {
        return fastDataConfig;
    }

    public void setFastDataConfig(ViewTransform.FastDataConfig fastDataConfig) {
        this.fastDataConfig = fastDataConfig;
    }

    public Options getYouboraOptions() {
        Options youboraOptions =  new Options();

        youboraOptions.setAccountCode(accountCode);
        youboraOptions.setUsername(username);
        youboraOptions.setUserEmail(userEmail);
        youboraOptions.setUserAnonymousId(userAnonymousId);
        youboraOptions.setUserType(userType);
        youboraOptions.setAppName(appName);
        youboraOptions.setAppReleaseVersion(appReleaseVersion);
        youboraOptions.setUserObfuscateIp(userObfuscateIp);
        youboraOptions.setHttpSecure(httpSecure);

        if (parse != null) {
            if (parse.getParseManifest() != null) {
                youboraOptions.setParseManifest(parse.getParseManifest());
            }
            if (parse.getParseCdnNode() != null) {
                youboraOptions.setParseCdnNode(parse.getParseCdnNode());
            }
            if (parse.getParseCdnSwitchHeader() != null) {
                youboraOptions.setParseCdnSwitchHeader(parse.getParseCdnSwitchHeader());
            }
            if (parse.getCdnNodeList() != null) {
                youboraOptions.setParseCdnNodeList(parse.getCdnNodeList());
            }
            if (parse.getCdnNameHeaders() != null) {
                youboraOptions.setParseCdnNameHeader(parse.getCdnNameHeaders());
            }
            if (parse.getParseCdnTTL() != null) {
                youboraOptions.setParseCdnTTL(parse.getParseCdnTTL());
            }
        }

        if (device != null) {
            if (device.getDeviceCode() != null) {
                //Generic Data by code see in Device class what Codes are available
                youboraOptions.setDeviceCode(device.getDeviceCode());
            }
            // Specific Data
            if (device.getModel() != null) {
                youboraOptions.setDeviceModel(device.getModel());
            }

            if (device.getId() != null) {
                youboraOptions.setDeviceId(device.getId());
            }

            if (device.getBrand() != null) {
                youboraOptions.setDeviceBrand(device.getBrand());
            }

            if (device.getType() != null) {
                youboraOptions.setDeviceType(device.getType());
            }

            if (device.getOsName() != null) {
                youboraOptions.setDeviceOsName(device.getOsName());
            }

            if (device.getOsVersion() != null) {
                youboraOptions.setDeviceOsVersion(device.getOsVersion());
            }
        }

        if (content != null) {
            if (content.getContentBitrate() != null) {
                youboraOptions.setContentBitrate(content.getContentBitrate());
            }
            if (content.getContentCdn() != null) {
                youboraOptions.setContentCdn(content.getContentCdn());
            }
            if (content.getContentCdnNode() != null) {
                youboraOptions.setContentCdnNode(content.getContentCdnNode());
            }
            if (content.getContentCdnType() != null) {
                youboraOptions.setContentCdnType(content.getContentCdnType());
            }
            if (content.getContentChannel() != null) {
                youboraOptions.setContentChannel(content.getContentChannel());
            }
            if (content.getContentContractedResolution() != null) {
                youboraOptions.setContentContractedResolution(content.getContentContractedResolution());
            }
            if (content.getContentCost() != null) {
                youboraOptions.setContentCost(content.getContentCost());
            }
            if (content.getContentDrm() != null) {
                youboraOptions.setContentDrm(content.getContentDrm());
            }
            if (content.getContentDuration() != null) {
                youboraOptions.setContentDuration(content.getContentDuration());
            }
            if (content.getContentEncodingAudioCodec() != null) {
                youboraOptions.setContentEncodingAudioCodec(content.getContentEncodingAudioCodec());
            }
            if (content.getContentEncodingCodecProfile() != null) {
                youboraOptions.setContentEncodingCodecProfile(content.getContentEncodingCodecProfile());
            }
            if (content.getContentEncodingContainerFormat() != null) {
                youboraOptions.setContentEncodingContainerFormat(content.getContentEncodingContainerFormat());
            }
            if (content.getContentEncodingVideoCodec() != null) {
                youboraOptions.setContentEncodingVideoCodec(content.getContentEncodingVideoCodec());
            }
            if (content.getContentEpisodeTitle() != null) {
                youboraOptions.setContentEpisodeTitle(content.getContentEpisodeTitle());
            }
            if (content.getContentFps() != null) {
                youboraOptions.setContentFps(content.getContentFps());
            }
            if (content.getContentGenre() != null) {
                youboraOptions.setContentGenre(content.getContentGenre());
            }
            if (content.getContentGracenoteId() != null) {
                youboraOptions.setContentGracenoteId(content.getContentGracenoteId());
            }
            if (content.getContentId() != null) {
                youboraOptions.setContentId(content.getContentId());
            }
            if (content.getContentImdbId() != null) {
                youboraOptions.setContentImdbId(content.getContentImdbId());
            }
            youboraOptions.setContentIsLive(content.getContentIsLive() != null ? content.getContentIsLive() : Boolean.FALSE);
            youboraOptions.setContentIsLiveNoSeek((content.getContentIsLiveNoSeek() != null) ? content.getContentIsLiveNoSeek() : Boolean.FALSE);
            if (content.getContentLanguage() != null) {
                youboraOptions.setContentLanguage(content.getContentLanguage());
            }
            if (content.getContentPackage() != null) {
                youboraOptions.setContentPackage(content.getContentPackage());
            }
            if (content.getContentPlaybackType() != null) {
                youboraOptions.setContentPlaybackType(content.getContentPlaybackType());
            }
            if (content.getContentPrice() != null) {
                youboraOptions.setContentPrice(content.getContentPrice());
            }
            if (content.getContentProgram() != null) {
                youboraOptions.setProgram(content.getContentProgram());
            }
            if (content.getContentRendition() != null) {
                youboraOptions.setContentRendition(content.getContentRendition());
            }
            if (content.getContentResource() != null) {
                youboraOptions.setContentResource(content.getContentResource());
            }
            if (content.getContentSaga() != null) {
                youboraOptions.setContentSaga(content.getContentSaga());
            }
            if (content.getContentSeason() != null) {
                youboraOptions.setContentSeason(content.getContentSeason());
            }
            if (content.getContentStreamingProtocol() != null) {
                youboraOptions.setContentStreamingProtocol(content.getContentStreamingProtocol());
            }
            if (content.getContentSubtitles() != null) {
                youboraOptions.setContentSubtitles(content.getContentSubtitles());
            }
            if (content.getContentThroughput() != null) {
                youboraOptions.setContentThroughput(content.getContentThroughput());
            }
            if (content.getContentTitle() != null) {
                youboraOptions.setContentTitle(content.getContentTitle());
            }
            if (content.getContentTransactionCode() != null) {
                youboraOptions.setContentTransactionCode(content.getContentTransactionCode());
            }
            if (content.getContentTotalBytes() != null) {
                youboraOptions.setContentTotalBytes(content.getContentTotalBytes());
            }
            youboraOptions.setContentSendTotalBytes(content.getContentSendTotalBytes() != null ? content.getContentSendTotalBytes() : Boolean.FALSE);
            if (content.getContentTvShow() != null) {
                youboraOptions.setContentTvShow(content.getContentTvShow());
            }
            if (content.getContentType() != null) {
                youboraOptions.setContentType(content.getContentType());
            }
        }

        setLegacyContentPropertiesBundle(youboraOptions);

        youboraOptions.setContentMetadata(getContentMetaDataBundle());

        //UNSUPPORTED YET
        //youboraOptions.setContentMetrics(getContentMetricsBundle());
        //youboraOptions.setContentEncodingCodecSettings(getContentEncodingCodecSettingsBundle());
        //youboraOptions.setAdMetadata(getAdMetaDataBundle());
        //youboraOptions.setAdExpectedPattern(getAdExpectedPatternBundle());

        if (ads != null) {
            if (ads.getAdBreaksTime() != null) {
                youboraOptions.setAdBreaksTime(ads.getAdBreaksTime());
            }
            youboraOptions.setAdCampaign(ads.getAdCampaign());
            youboraOptions.setAdCreativeId(ads.getAdCreativeId());


            if (ads.getAdExpectedBreaks() != null) {
                youboraOptions.setAdExpectedBreaks(ads.getAdExpectedBreaks());
            }
            if (ads.getAdGivenBreaks() != null) {
                youboraOptions.setAdGivenBreaks(ads.getAdGivenBreaks());
            }

            youboraOptions.setAdProvider(ads.getAdProvider());
            youboraOptions.setAdResource(ads.getAdResource());
            youboraOptions.setAdTitle(ads.getAdTitle());

            if (ads.getExtraParams() != null) {
                youboraOptions.setAdCustomDimension1(ads.getExtraParams().getParam1());
                youboraOptions.setAdCustomDimension2(ads.getExtraParams().getParam2());
                youboraOptions.setAdCustomDimension3(ads.getExtraParams().getParam3());
                youboraOptions.setAdCustomDimension4(ads.getExtraParams().getParam4());
                youboraOptions.setAdCustomDimension5(ads.getExtraParams().getParam5());
                youboraOptions.setAdCustomDimension6(ads.getExtraParams().getParam6());
                youboraOptions.setAdCustomDimension7(ads.getExtraParams().getParam7());
                youboraOptions.setAdCustomDimension8(ads.getExtraParams().getParam8());
                youboraOptions.setAdCustomDimension9(ads.getExtraParams().getParam9());
                youboraOptions.setAdCustomDimension10(ads.getExtraParams().getParam10());
            }
        }

        if (extraParams != null) {
            youboraOptions.setContentCustomDimension1(extraParams.getParam1());
            youboraOptions.setContentCustomDimension2(extraParams.getParam2());
            youboraOptions.setContentCustomDimension3(extraParams.getParam3());
            youboraOptions.setContentCustomDimension4(extraParams.getParam4());
            youboraOptions.setContentCustomDimension5(extraParams.getParam5());
            youboraOptions.setContentCustomDimension6(extraParams.getParam6());
            youboraOptions.setContentCustomDimension7(extraParams.getParam7());
            youboraOptions.setContentCustomDimension8(extraParams.getParam8());
            youboraOptions.setContentCustomDimension9(extraParams.getParam9());
            youboraOptions.setContentCustomDimension10(extraParams.getParam10());
        }
        return youboraOptions;
    }

    private void setLegacyContentPropertiesBundle(Options youboraOptions) {
        Properties prop = getProperties();
        if (prop == null) {
            return;
        }

        // For Legacy
        if (prop.getGenre() != null) {
            youboraOptions.setContentGenre(prop.getGenre());
        }
        if (prop.getType() != null) {
            youboraOptions.setContentType(prop.getType());
        }
        if (prop.getTransactionType() != null) {
            youboraOptions.setContentTransactionCode(prop.getTransactionType());
        }
        if (prop.getPrice() != null) {
            youboraOptions.setContentPrice(prop.getPrice());
        }
        if (prop.getQuality() != null) {
            youboraOptions.setContentRendition(prop.getQuality()); // Name or value of the current rendition (quality) of the content.
        }
        if (prop.getContentPackage() != null) {
            youboraOptions.setContentPackage(prop.getContentPackage());
        }
        if (prop.getContentCdnCode() != null) {
            youboraOptions.setContentCdn(prop.getContentCdnCode());
        }
        if (prop.getContentSaga() != null) {
            youboraOptions.setContentSaga(prop.getContentSaga());
        }
        if (prop.getContentTvShow() != null) {
            youboraOptions.setContentTvShow(prop.getContentTvShow());
        }
        if (prop.getContentSeason() != null) {
            youboraOptions.setContentSeason(prop.getContentSeason());
        }
        if (prop.getContentEpisodeTitle() != null) {
            youboraOptions.setContentEpisodeTitle(prop.getContentEpisodeTitle());
        }
        if (prop.getContentChannel() != null) {
            youboraOptions.setContentChannel(prop.getContentChannel());
        }
        if (prop.getContentId() != null) {
            youboraOptions.setContentId(prop.getContentId());
        }
        if (prop.getContentImdbId() != null) {
            youboraOptions.setContentImdbId(prop.getContentImdbId());
        }
        if (prop.getContentGracenoteId() != null) {
            youboraOptions.setContentGracenoteId(prop.getContentGracenoteId());
        }
        if (prop.getContentLanguage() != null) {
            youboraOptions.setContentLanguage(prop.getContentLanguage());
        }
        if (prop.getContentSubtitles() != null) {
            youboraOptions.setContentSubtitles(prop.getContentSubtitles());
        }
        if (prop.getContentContractedResolution() != null) {
            youboraOptions.setContentContractedResolution(prop.getContentContractedResolution());
        }
        if (prop.getContentPlaybackType() != null) {
            youboraOptions.setContentPlaybackType(prop.getContentPlaybackType());
        }
        if (prop.getContentDrm() != null) {
            youboraOptions.setContentDrm(prop.getContentDrm());
        }
        if (prop.getContentEncodingVideoCodec() != null) {
            youboraOptions.setContentEncodingVideoCodec(prop.getContentEncodingVideoCodec());
        }
        if (prop.getContentEncodingAudioCodec() != null) {
            youboraOptions.setContentEncodingAudioCodec(prop.getContentEncodingAudioCodec());
        }
        if (prop.getContentEncodingCodecProfile() != null) {
            youboraOptions.setContentEncodingCodecProfile(prop.getContentEncodingCodecProfile());
        }
        if (prop.getContentEncodingContainerFormat() != null) {
            youboraOptions.setContentEncodingContainerFormat(prop.getContentEncodingContainerFormat());
        }
    }

    /**
     * Containing mixed extra information about the content like: director,
     * parental rating, device info or the audio channels.
     * @return bundle having properties
     */
    private Bundle getContentMetaDataBundle() {
        Properties prop = getProperties();
        if (prop == null) {
            return new Bundle();
        }

        Bundle propertiesBundle = new Bundle();
        propertiesBundle.putString("director", (prop.getDirector() != null) ? prop.getDirector() : "");
        propertiesBundle.putString("parental", (prop.getParental() != null) ? prop.getParental() : "");
        propertiesBundle.putString("audioChannels", (prop.getAudioChannels() != null) ? prop.getAudioChannels() : "");
        propertiesBundle.putString("device", (prop.getDevice() != null) ? prop.getDevice() : "");
        propertiesBundle.putString("rating", (prop.getRating() != null) ? prop.getRating() : "");
        propertiesBundle.putString("year", (prop.getYear() != null) ? prop.getYear() : "");
        propertiesBundle.putString("cast", (prop.getCast() != null) ? prop.getCast() : "");
        propertiesBundle.putString("owner", (prop.getOwner() != null) ? prop.getOwner() : "");

        return propertiesBundle;
    }

    private Bundle getContentMetricsBundle() {
        return new Bundle();
    }

    private Bundle getContentEncodingCodecSettingsBundle() {
        return new Bundle();
    }

    private Bundle getAdMetaDataBundle() {
        return new Bundle();
//        AdProperties prop = getAdProperties();
//        if (prop == null) {
//            return new Bundle();
//        }
//
//        Bundle propertiesBundle = new Bundle();
//        propertiesBundle.putString("director", (prop.getDirector() != null) ? prop.getDirector() : "");
//        propertiesBundle.putString("parental", (prop.getParental() != null) ? prop.getParental() : "");
//        propertiesBundle.putString("audioChannels", (prop.getAudioChannels() != null) ? prop.getAudioChannels() : "");
//        propertiesBundle.putString("device", (prop.getDevice() != null) ? prop.getDevice() : "");
//        propertiesBundle.putString("rating", (prop.getRating() != null) ? prop.getRating() : "");
//        propertiesBundle.putString("year", (prop.getYear() != null) ? prop.getYear() : "");
//        propertiesBundle.putString("cast", (prop.getCast() != null) ? prop.getCast() : "");
//        propertiesBundle.putString("owner", (prop.getOwner() != null) ? prop.getOwner() : "");
//
//        return propertiesBundle;
    }

    private Bundle getAdExpectedPatternBundle() {
        return new Bundle();
    }


    public JsonObject toJson() {
        JsonPrimitive accountCode = new JsonPrimitive(getAccountCode() != null ? getAccountCode() : "");
        JsonPrimitive username = new JsonPrimitive(getUsername() != null ? getUsername() : "");
        JsonPrimitive userEmail = new JsonPrimitive(getUserEmail() != null ? getUserEmail() : "");
        JsonPrimitive userAnonymousId = new JsonPrimitive(getUserAnonymousId() != null ? getUserAnonymousId() : "");

        JsonPrimitive userType = new JsonPrimitive(getUserType() != null ? getUserType() : "");
        JsonPrimitive appName = new JsonPrimitive(getAppName() != null ? getAppName() : "");
        JsonPrimitive appReleaseVersion = new JsonPrimitive(getAppReleaseVersion() != null ? getAppReleaseVersion() : "");
        JsonPrimitive houseHoldId = new JsonPrimitive(getHouseHoldId() != null ? getHouseHoldId() : "");
        JsonPrimitive isUserObfuscateIp = new JsonPrimitive(isUserObfuscateIp());
        JsonPrimitive httpSecure = new JsonPrimitive(getHttpSecure());
        JsonObject parse = getParseJsonObject();
        JsonObject device = getDeviceJsonObject();
        JsonObject content = getContentJsonObject();
        JsonObject adsEntry = getAdsJsonObject();
        JsonObject propertiesEntry = getPropertiesJsonObject();
        JsonObject extraParamEntry = getExtraParamJsonObject();
        return getYouboraConfigJsonObject(accountCode,
                username,
                userEmail,
                userAnonymousId,
                userType,
                appName,
                appReleaseVersion,
                houseHoldId,
                isUserObfuscateIp,
                httpSecure,
                parse,
                device,
                content,
                adsEntry,
                propertiesEntry,
                extraParamEntry);
    }

    private JsonObject getParseJsonObject() {
        JsonObject parseJsonObject = new JsonObject();
        Parse parse = getParse();
        if (parse == null) {
            return parseJsonObject;
        }

        if (parse.getParseManifest() != null) {
            parseJsonObject.addProperty("parseManifest", parse.getParseManifest());
        }

        if (parse.getParseCdnNode() != null) {
            parseJsonObject.addProperty("parseCdnNode", parse.getParseCdnNode());
        }

        if (parse.getParseCdnSwitchHeader() != null) {
            parseJsonObject.addProperty("parseCdnSwitchHeader", parse.getParseCdnSwitchHeader());
        }

        if (parse.getCdnNodeList() != null) {
            JsonArray cdnNodeListJsonArray = new JsonArray();
            for(String cdn : parse.getCdnNodeList()) {
                cdnNodeListJsonArray.add(cdn);
            }
            parseJsonObject.add("cdnNodeList", cdnNodeListJsonArray);
        }

        if (parse.getCdnNameHeaders() != null) {
            parseJsonObject.addProperty("cdnNameHeaders", parse.getCdnNameHeaders() );
        }

        if (parse.getParseCdnTTL() != null) {
            parseJsonObject.addProperty("parseCdnTTL", parse.getParseCdnTTL());
        }
        return parseJsonObject;
    }

    private JsonObject getDeviceJsonObject() {
        JsonObject deviceJsonObject = new JsonObject();
        Device device = getDevice();
        if (device == null) {
            return deviceJsonObject;
        }

        if (device.getDeviceCode() != null) {
            deviceJsonObject.addProperty("deviceCode", device.getDeviceCode());
        }

        if (device.getModel() != null) {
            deviceJsonObject.addProperty("model", device.getModel());
        }

        if (device.getId() != null) {
            deviceJsonObject.addProperty("id", device.getId());
        }

        if (device.getBrand() != null) {
            deviceJsonObject.addProperty("brand", device.getBrand());
        }

        if (device.getType() != null) {
            deviceJsonObject.addProperty("type", device.getType());
        }

        if (device.getOsName() != null) {
            deviceJsonObject.addProperty("osName", device.getOsName());
        }

        if (device.getOsVersion() != null) {
            deviceJsonObject.addProperty("osName", device.getOsVersion());
        }
        return deviceJsonObject;
    }

    @NonNull
    private JsonObject getContentJsonObject() {
        JsonObject contentEntry = new JsonObject();
        Content content = getContent();
        if (content == null) {
            return contentEntry;
        }

        if (content.getContentBitrate() != null) {
            contentEntry.addProperty("contentBitrate", content.getContentBitrate());
        }
        if (content.getContentCdn() != null) {
            contentEntry.addProperty("contentCdn", content.getContentCdn());
        }
        if (content.getContentCdnNode() != null) {
            contentEntry.addProperty("contentCdnNode", content.getContentCdnNode());
        }
        if (content.getContentCdnType() != null) {
            contentEntry.addProperty("contentCdnType", content.getContentCdnType());
        }
        if (content.getContentChannel() != null) {
            contentEntry.addProperty("contentChannel", content.getContentChannel());
        }
        if (content.getContentContractedResolution() != null) {
            contentEntry.addProperty("contentContractedResolution", content.getContentContractedResolution());
        }
        if (content.getContentCost() != null) {
            contentEntry.addProperty("contentCost", content.getContentCost());
        }
        if (content.getContentDrm() != null) {
            contentEntry.addProperty("contentDrm", content.getContentDrm());
        }
        if (content.getContentDuration() != null) {
            contentEntry.addProperty("contentDuration", content.getContentDuration());
        }
        if (content.getContentEncodingAudioCodec() != null) {
            contentEntry.addProperty("contentEncodingAudioCodec", content.getContentEncodingAudioCodec());
        }
        if (content.getContentEncodingCodecProfile() != null) {
            contentEntry.addProperty("contentEncodingCodecProfile", content.getContentEncodingCodecProfile());
        }
        if (content.getContentEncodingContainerFormat() != null) {
            contentEntry.addProperty("contentEncodingContainerFormat", content.getContentEncodingContainerFormat());
        }
        if (content.getContentEncodingVideoCodec() != null) {
            contentEntry.addProperty("contentEncodingVideoCodec", content.getContentEncodingVideoCodec());
        }
        if (content.getContentEpisodeTitle() != null) {
            contentEntry.addProperty("contentEpisodeTitle", content.getContentEpisodeTitle());
        }
        if (content.getContentFps() != null) {
            contentEntry.addProperty("contentFps", content.getContentFps());
        }
        if (content.getContentGenre() != null) {
            contentEntry.addProperty("contentGenre", content.getContentGenre());
        }
        if (content.getContentGracenoteId() != null) {
            contentEntry.addProperty("contentGracenoteId", content.getContentGracenoteId());
        }
        if (content.getContentId() != null) {
            contentEntry.addProperty("contentId", content.getContentId());
        }
        if (content.getContentImdbId() != null) {
            contentEntry.addProperty("contentImdbId", content.getContentImdbId());
        }
        contentEntry.addProperty("contentisLive", content.getContentIsLive() != null ? content.getContentIsLive() : Boolean.FALSE);
        contentEntry.addProperty("contentIsLiveNoSeek",  content.getContentIsLiveNoSeek() != null ? content.getContentIsLiveNoSeek() : Boolean.FALSE);
        if (content.getContentLanguage() != null) {
            contentEntry.addProperty("contentLanguage", content.getContentLanguage());
        }
        if (content.getContentPackage() != null) {
            contentEntry.addProperty("contentPackage", content.getContentPackage());
        }
        if (content.getContentPlaybackType() != null) {
            contentEntry.addProperty("contentPlaybackType", content.getContentPlaybackType());
        }
        if (content.getContentPrice() != null) {
            contentEntry.addProperty("contentPrice", content.getContentPrice());
        }
        if  (content.getContentProgram() != null) {
            contentEntry.addProperty("contentProgram", content.getContentProgram());
        }
        if (content.getContentRendition() != null) {
            contentEntry.addProperty("conetentRendition", content.getContentRendition());
        }
        if (content.getContentResource() != null) {
            contentEntry.addProperty("contentResource", content.getContentResource());
        }
        if (content.getContentSaga() != null) {
            contentEntry.addProperty("contentSaga", content.getContentSaga());
        }
        if (content.getContentSeason() != null) {
            contentEntry.addProperty("contentSeason", content.getContentSeason());
        }
        if (content.getContentStreamingProtocol() != null) {
            contentEntry.addProperty("contentStreamingProtocol", content.getContentStreamingProtocol());
        }
        if (content.getContentSubtitles() != null) {
            contentEntry.addProperty("contentSubtitles", content.getContentSubtitles());
        }
        if (content.getContentThroughput() != null) {
            contentEntry.addProperty("contentThroughput", content.getContentThroughput());
        }
        if (content.getContentTitle() != null) {
            contentEntry.addProperty("contentTitle", content.getContentTitle());
        }
        if (content.getContentTransactionCode() != null) {
            contentEntry.addProperty("contentTransactionCode", content.getContentTransactionCode());
        }
        if (content.getContentTotalBytes() != null) {
            contentEntry.addProperty("contentTotalBytes", content.getContentTotalBytes());
        }
        contentEntry.addProperty("contentSendTotalBytes", (content.getContentSendTotalBytes() != null) ? content.getContentSendTotalBytes() : Boolean.FALSE);
        if (content.getContentTvShow() != null) {
            contentEntry.addProperty("contentTvShow", content.getContentTvShow());
        }
        if (content.getContentType() != null) {
            contentEntry.addProperty("contentType", content.getContentType());
        }

        return contentEntry;
    }

    @NonNull
    private JsonObject getAdsJsonObject() {

        //new JsonObject();
        // adsEntry.addProperty("campaign", (getAds() != null && getAds().getAdCampaign() != null) ? getAds().getAdCampaign() : "");

        JsonObject adsEntry = new JsonObject();
        Ads ads = getAds();
        if (ads == null) {
            return adsEntry;
        }

        if (ads.getAdBreaksTime() != null) {
            JsonArray adBreaksTimeArray = new JsonArray();
            for (Integer adBreak : ads.getAdBreaksTime()) {
                adBreaksTimeArray.add(adBreak);
            }
            adsEntry.add("adBreaksTime", adBreaksTimeArray);
        }
        if (ads.getAdCampaign() != null) {
            adsEntry.addProperty("adCampaign", ads.getAdCampaign());
        }
        if (ads.getAdCreativeId() != null) {
            adsEntry.addProperty("adCreativeId", ads.getAdCreativeId());
        }
        if (ads.getAdExpectedBreaks() != null) {
            adsEntry.addProperty("adExpectedBreaks", ads.getAdExpectedBreaks());
        }
        if (ads.getAdGivenBreaks() != null) {
            adsEntry.addProperty("adGivenBreaks", ads.getAdGivenBreaks());
        }
        if (ads.getAdProvider() != null) {
            adsEntry.addProperty("adProvider", ads.getAdProvider());
        }
        if (ads.getAdResource() != null) {
            adsEntry.addProperty("adResource", ads.getAdResource());
        }
        if (ads.getAdTitle() != null) {
            adsEntry.addProperty("adTitle", ads.getAdTitle());
        }

        return adsEntry;
    }

    @NonNull
    private JsonObject getYouboraConfigJsonObject(JsonPrimitive accountCode,
                                                  JsonPrimitive username,
                                                  JsonPrimitive userEmail,
                                                  JsonPrimitive userAnonymousId,
                                                  JsonPrimitive userType,
                                                  JsonPrimitive appName,
                                                  JsonPrimitive appReleaseVersion,
                                                  JsonPrimitive houseHoldId,
                                                  JsonPrimitive isUserObfuscateIp,
                                                  JsonPrimitive httpSecure,
                                                  JsonObject parse,
                                                  JsonObject device,
                                                  JsonObject content,
                                                  JsonObject adsEntry,
                                                  JsonObject propertiesEntry,
                                                  JsonObject extraParamEntry) {
        JsonObject youboraConfig = new JsonObject();
        youboraConfig.add("accountCode", accountCode);
        youboraConfig.add("username", username);
        youboraConfig.add("userEmail", userEmail);
        youboraConfig.add("userAnonymousId", userAnonymousId);
        youboraConfig.add("userType", userType);
        youboraConfig.add("appName", appName);
        youboraConfig.add("appReleaseVersion", appReleaseVersion);
        youboraConfig.add("houseHoldId", houseHoldId);
        youboraConfig.add("userObfuscateIp", isUserObfuscateIp);
        youboraConfig.add("httpSecure", httpSecure);
        youboraConfig.add("parse", parse);
        youboraConfig.add("device", device);
        youboraConfig.add("content", content);
        youboraConfig.add("ads", adsEntry);
        youboraConfig.add("properties", propertiesEntry);
        youboraConfig.add("extraParams", extraParamEntry);
        return youboraConfig;
    }

    @NonNull
    private JsonObject getPropertiesJsonObject() {
        JsonObject propertiesEntry = new JsonObject();
        if (getProperties() == null) {
            return propertiesEntry;
        }

        Properties prop = getProperties();
        propertiesEntry.addProperty("year", (prop.getYear() != null) ? prop.getYear() : "");
        propertiesEntry.addProperty("cast", (prop.getCast() != null) ? prop.getCast() : "");
        propertiesEntry.addProperty("director", (prop.getDirector() != null) ? prop.getDirector() : "");
        propertiesEntry.addProperty("owner", (prop.getOwner() != null) ? prop.getOwner() : "");
        propertiesEntry.addProperty("parental", (prop.getParental() != null) ? prop.getParental() : "");
        propertiesEntry.addProperty("rating", (prop.getRating() != null) ? prop.getRating() : "");
        propertiesEntry.addProperty("device", (prop.getDevice() != null) ? prop.getDevice() : "");
        propertiesEntry.addProperty("audioChannels", (prop.getAudioChannels() != null) ? prop.getAudioChannels() : "");

        return propertiesEntry;
    }

    @NonNull
    private JsonObject getExtraParamJsonObject() {
        JsonObject extraParamEntry = new JsonObject();
        if (getExtraParams() == null) {
            return extraParamEntry;
        }
        ExtraParams extraParams = getExtraParams();
        if (extraParams.getParam1() != null) {
            extraParamEntry.addProperty("param1", extraParams.getParam1());
        }
        if (extraParams.getParam2() != null) {
            extraParamEntry.addProperty("param2", extraParams.getParam2());
        }
        if (extraParams.getParam3() != null) {
            extraParamEntry.addProperty("param3", extraParams.getParam3());
        }
        if (extraParams.getParam4() != null) {
            extraParamEntry.addProperty("param4", extraParams.getParam4());
        }
        if (extraParams.getParam5() != null) {
            extraParamEntry.addProperty("param5", extraParams.getParam5());
        }
        if (extraParams.getParam6() != null) {
            extraParamEntry.addProperty("param6", extraParams.getParam6());
        }
        if (extraParams.getParam7() != null) {
            extraParamEntry.addProperty("param7", extraParams.getParam7());
        }
        if (extraParams.getParam8() != null) {
            extraParamEntry.addProperty("param8", extraParams.getParam8());
        }
        if (extraParams.getParam9() != null) {
            extraParamEntry.addProperty("param9", extraParams.getParam9());
        }
        if (extraParams.getParam10() != null) {
            extraParamEntry.addProperty("param10", extraParams.getParam10());
        }
        return extraParamEntry;
    }

    public void merge(YouboraConfig youboraConfigUiConf) {
        if (youboraConfigUiConf == null) {
            return;
        }

        if (TextUtils.isEmpty(accountCode)) {
            accountCode = youboraConfigUiConf.getAccountCode();
        }
        if (TextUtils.isEmpty(username)) {
            username =  youboraConfigUiConf.getUsername();
        }
        if (TextUtils.isEmpty(userEmail)) {
            userEmail =  youboraConfigUiConf.getUserEmail();
        }
        if (TextUtils.isEmpty(userAnonymousId)) {
            userAnonymousId =  youboraConfigUiConf.getUserAnonymousId();
        }
        if (TextUtils.isEmpty(userType)) {
            userType =  youboraConfigUiConf.getUserType();
        }

        if (content != null) {
            if (youboraConfigUiConf.getContent() != null) {
                if (content.getContentBitrate() == null) {
                    content.setContentBitrate(youboraConfigUiConf.getContent().getContentBitrate());
                }
                if (content.getContentCdn() == null) {
                    content.setContentCdn(youboraConfigUiConf.getContent().getContentCdn());
                }
                if (content.getContentCdnNode() == null) {
                    content.setContentCdnNode(youboraConfigUiConf.getContent().getContentCdnNode());
                }
                if (content.getContentCdnType() == null) {
                    content.setContentCdnType(youboraConfigUiConf.getContent().getContentCdnType());
                }
                if (content.getContentChannel() == null) {
                    content.setContentChannel(youboraConfigUiConf.getContent().getContentChannel());
                }
                if (content.getContentContractedResolution() == null) {
                    content.setContentContractedResolution(youboraConfigUiConf.getContent().getContentContractedResolution());
                }
                if (content.getContentCost() == null) {
                    content.setContentCost(youboraConfigUiConf.getContent().getContentCost());
                }
                if (content.getContentDrm() == null) {
                    content.setContentDrm(youboraConfigUiConf.getContent().getContentDrm());
                }
                if (content.getContentDuration() == null) {
                    content.setContentDuration(youboraConfigUiConf.getContent().getContentDuration());
                }
                if (content.getContentEncodingAudioCodec() == null) {
                    content.setContentEncodingAudioCodec(youboraConfigUiConf.getContent().getContentEncodingAudioCodec());
                }
                if (content.getContentEncodingCodecProfile() == null) {
                    content.setContentEncodingCodecProfile(youboraConfigUiConf.getContent().getContentEncodingCodecProfile());
                }
                if (content.getContentEncodingContainerFormat() == null) {
                    content.setContentEncodingContainerFormat(youboraConfigUiConf.getContent().getContentEncodingContainerFormat());
                }
                if (content.getContentEncodingVideoCodec() == null) {
                    content.setContentEncodingVideoCodec(youboraConfigUiConf.getContent().getContentEncodingVideoCodec());
                }
                if (content.getContentEpisodeTitle() == null) {
                    content.setContentEpisodeTitle(youboraConfigUiConf.getContent().getContentEpisodeTitle());
                }
                if (content.getContentFps() == null) {
                    content.setContentFps(youboraConfigUiConf.getContent().getContentFps());
                }
                if (content.getContentGenre() == null) {
                    content.setContentGenre(youboraConfigUiConf.getContent().getContentGenre());
                }
                if (content.getContentGracenoteId() == null) {
                    content.setContentGracenoteId(youboraConfigUiConf.getContent().getContentGracenoteId());
                }
                if (content.getContentId() == null) {
                    content.setContentId(youboraConfigUiConf.getContent().getContentId());
                }
                if (content.getContentImdbId() == null) {
                    content.setContentImdbId(youboraConfigUiConf.getContent().getContentImdbId());
                }
                if (content.getContentIsLive() == null) {
                    content.setContentIsLive(youboraConfigUiConf.getContent().getContentIsLive());
                }
                if (content.getContentIsLiveNoSeek() == null) {
                    content.setContentIsLiveNoSeek(youboraConfigUiConf.getContent().getContentIsLiveNoSeek());
                }
                if (content.getContentLanguage() == null) {
                    content.setContentLanguage(youboraConfigUiConf.getContent().getContentLanguage());
                }
                if (content.getContentPackage() == null) {
                    content.setContentPackage(youboraConfigUiConf.getContent().getContentPackage());
                }
                if (content.getContentPlaybackType() == null) {
                    content.setContentPlaybackType(youboraConfigUiConf.getContent().getContentPlaybackType());
                }
                if (content.getContentPrice() == null) {
                    content.setContentPrice(youboraConfigUiConf.getContent().getContentPrice());
                }
                if (content.getContentProgram() == null) {
                    content.setContentProgram(youboraConfigUiConf.getContent().getContentProgram());
                }
                if (content.getContentRendition() == null) {
                    content.setContentRendition(youboraConfigUiConf.getContent().getContentRendition());
                }
                if (content.getContentResource() == null) {
                    content.setContentResource(youboraConfigUiConf.getContent().getContentResource());
                }
                if (content.getContentSaga() == null) {
                    content.setContentSaga(youboraConfigUiConf.getContent().getContentSaga());
                }
                if (content.getContentSeason() == null) {
                    content.setContentSeason(youboraConfigUiConf.getContent().getContentSeason());
                }
                if (content.getContentStreamingProtocol() == null) {
                    content.setContentStreamingProtocol(youboraConfigUiConf.getContent().getContentStreamingProtocol());
                }
                if (content.getContentSubtitles() == null) {
                    content.setContentSubtitles(youboraConfigUiConf.getContent().getContentSubtitles());
                }
                if (content.getContentThroughput() == null) {
                    content.setContentThroughput(youboraConfigUiConf.getContent().getContentThroughput());
                }
                if (content.getContentTitle() == null) {
                    content.setContentTitle(youboraConfigUiConf.getContent().getContentTitle());
                }
                if (content.getContentTransactionCode() == null) {
                    content.setContentTransactionCode(youboraConfigUiConf.getContent().getContentTransactionCode());
                }
                if (content.getContentTotalBytes() == null) {
                    content.setContentTotalBytes(youboraConfigUiConf.getContent().getContentTotalBytes());
                }
                if (content.getContentSendTotalBytes() == null) {
                    content.setContentSendTotalBytes(youboraConfigUiConf.getContent().getContentSendTotalBytes());
                }
                if (content.getContentTvShow() == null) {
                    content.setContentTvShow(youboraConfigUiConf.getContent().getContentTvShow());
                }
                if (content.getContentType() == null) {
                    content.setContentType(youboraConfigUiConf.getContent().getContentType());
                }
            }
        } else {
            content = youboraConfigUiConf.getContent();
        }

        if (parse != null) {
            if (youboraConfigUiConf.getParse() != null) {
                if (parse.getParseManifest() == null) {
                    parse.setParseManifest(youboraConfigUiConf.getParse().getParseManifest());
                }
                if (parse.getParseCdnNode() == null) {
                    parse.setParseCdnNode(youboraConfigUiConf.getParse().getParseCdnNode());
                }
                if (parse.getCdnNodeList() == null) {
                    parse.setCdnNodeList(youboraConfigUiConf.getParse().getCdnNodeList());
                }
                if (parse.getParseCdnTTL() == null) {
                    parse.setParseCdnTTL(youboraConfigUiConf.getParse().getParseCdnTTL());
                }
                if (parse.getCdnNameHeaders() == null) {
                    parse.setCdnNameHeaders(youboraConfigUiConf.getParse().getCdnNameHeaders());
                }
                if (parse.getParseCdnSwitchHeader() == null) {
                    parse.setParseCdnSwitchHeader(youboraConfigUiConf.getParse().getParseCdnSwitchHeader());
                }
            }
        } else {
            parse = youboraConfigUiConf.getParse();
        }

        if (ads != null) {
            if (youboraConfigUiConf.getAds() != null) {
                if (ads.getAdBreaksTime() == null) {
                    ads.setAdBreaksTime(youboraConfigUiConf.getAds().getAdBreaksTime());
                }
                if (ads.getAdCampaign() == null) {
                    ads.setAdCampaign(youboraConfigUiConf.getAds().getAdCampaign());
                }
                if (ads.getAdCreativeId() == null) {
                    ads.setAdCreativeId(youboraConfigUiConf.getAds().getAdCreativeId());
                }
                if (ads.getAdExpectedBreaks() == null) {
                    ads.setAdExpectedBreaks(youboraConfigUiConf.getAds().getAdExpectedBreaks());
                }
                if (ads.getAdGivenBreaks() == null) {
                    ads.setAdGivenBreaks(youboraConfigUiConf.getAds().getAdGivenBreaks());
                }
                if (ads.getAdProvider() == null) {
                    ads.setAdProvider(youboraConfigUiConf.getAds().getAdProvider());
                }
                if (ads.getAdResource() == null) {
                    ads.setAdResource(youboraConfigUiConf.getAds().getAdResource());
                }
                if (ads.getAdTitle() == null) {
                    ads.setAdTitle(youboraConfigUiConf.getAds().getAdTitle());
                }
            }
        } else {
            ads = youboraConfigUiConf.getAds();
        }

        if (properties != null) {
            if (youboraConfigUiConf.getProperties() != null) {
                Properties propUiConf = youboraConfigUiConf.getProperties();

                if (TextUtils.isEmpty((properties.getAudioChannels()))) {
                    properties.setAudioChannels(propUiConf.getAudioChannels());
                }
                if (TextUtils.isEmpty((properties.getCast()))) {
                    properties.setCast(propUiConf.getCast());
                }
                if (TextUtils.isEmpty((properties.getDevice()))) {
                    properties.setDevice(propUiConf.getDevice());
                }
                if (TextUtils.isEmpty((properties.getDirector()))) {
                    properties.setDirector(propUiConf.getDirector());
                }
                if (TextUtils.isEmpty((properties.getOwner()))) {
                    properties.setOwner(propUiConf.getOwner());
                }
                if (TextUtils.isEmpty((properties.getParental()))) {
                    properties.setParental(propUiConf.getParental());
                }
                if (TextUtils.isEmpty((properties.getYear()))) {
                    properties.setYear(propUiConf.getYear());
                }
                if (TextUtils.isEmpty((properties.getRating()))) {
                    properties.setRating(propUiConf.getRating());
                }
            }
        } else {
            properties = youboraConfigUiConf.getProperties();
        }

        if (extraParams != null) {
            if (youboraConfigUiConf.getExtraParams() != null) {
                ExtraParams extraParamsUiConf = youboraConfigUiConf.getExtraParams();
                if (TextUtils.isEmpty((extraParams.getParam1()))) {
                    extraParams.setParam1(extraParamsUiConf.getParam1());
                }
                if (TextUtils.isEmpty((extraParams.getParam1()))) {
                    extraParams.setParam1(extraParamsUiConf.getParam1());
                }
                if (TextUtils.isEmpty((extraParams.getParam2()))) {
                    extraParams.setParam2(extraParamsUiConf.getParam2());
                }
                if (TextUtils.isEmpty((extraParams.getParam3()))) {
                    extraParams.setParam3(extraParamsUiConf.getParam3());
                }
                if (TextUtils.isEmpty((extraParams.getParam4()))) {
                    extraParams.setParam4(extraParamsUiConf.getParam4());
                }
                if (TextUtils.isEmpty((extraParams.getParam5()))) {
                    extraParams.setParam5(extraParamsUiConf.getParam5());
                }
                if (TextUtils.isEmpty((extraParams.getParam6()))) {
                    extraParams.setParam6(extraParamsUiConf.getParam6());
                }
                if (TextUtils.isEmpty((extraParams.getParam7()))) {
                    extraParams.setParam7(extraParamsUiConf.getParam7());
                }
                if (TextUtils.isEmpty((extraParams.getParam8()))) {
                    extraParams.setParam8(extraParamsUiConf.getParam8());
                }
                if (TextUtils.isEmpty((extraParams.getParam1()))) {
                    extraParams.setParam9(extraParamsUiConf.getParam9());
                }
                if (TextUtils.isEmpty((extraParams.getParam10()))) {
                    extraParams.setParam10(extraParamsUiConf.getParam10());
                }
            }
        } else {
            extraParams = youboraConfigUiConf.getExtraParams();
        }
    }
}