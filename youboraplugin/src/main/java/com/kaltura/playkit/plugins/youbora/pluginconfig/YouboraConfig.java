package com.kaltura.playkit.plugins.youbora.pluginconfig;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.npaw.youbora.lib6.comm.transform.ViewTransform;
import com.npaw.youbora.lib6.plugin.Options;

import java.util.ArrayList;

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

    private Media media;

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

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
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

        if (media != null) {
            if (media.getContentBitrate() != null) {
                youboraOptions.setContentBitrate(media.getContentBitrate());
            }
            if (media.getContentCdn() != null) {
                youboraOptions.setContentCdn(media.getContentCdn());
            }
            if (media.getContentCdnNode() != null) {
                youboraOptions.setContentCdnNode(media.getContentCdnNode());
            }
            if (media.getContentCdnType() != null) {
                youboraOptions.setContentCdnType(media.getContentCdnType());
            }
            if (media.getContentChannel() != null) {
                youboraOptions.setContentChannel(media.getContentChannel());
            }
            if (media.getContentContractedResolution() != null) {
                youboraOptions.setContentContractedResolution(media.getContentContractedResolution());
            }
            if (media.getContentCost() != null) {
                youboraOptions.setContentCost(media.getContentCost());
            }
            if (media.getContentDrm() != null) {
                youboraOptions.setContentDrm(media.getContentDrm());
            }
            if (media.getContentDuration() != null) {
                youboraOptions.setContentDuration(media.getContentDuration());
            }
            if (media.getContentEncodingAudioCodec() != null) {
                youboraOptions.setContentEncodingAudioCodec(media.getContentEncodingAudioCodec());
            }
            if (media.getContentEncodingCodecProfile() != null) {
                youboraOptions.setContentEncodingCodecProfile(media.getContentEncodingCodecProfile());
            }
            if (media.getContentEncodingContainerFormat() != null) {
                youboraOptions.setContentEncodingContainerFormat(media.getContentEncodingContainerFormat());
            }
            if (media.getContentEncodingVideoCodec() != null) {
                youboraOptions.setContentEncodingVideoCodec(media.getContentEncodingVideoCodec());
            }
            if (media.getContentEpisodeTitle() != null) {
                youboraOptions.setContentEpisodeTitle(media.getContentEpisodeTitle());
            }
            if (media.getContentFps() != null) {
                youboraOptions.setContentFps(media.getContentFps());
            }
            if (media.getContentGenre() != null) {
                youboraOptions.setContentGenre(media.getContentGenre());
            }
            if (media.getContentGracenoteId() != null) {
                youboraOptions.setContentGracenoteId(media.getContentGracenoteId());
            }
            if (media.getContentId() != null) {
                youboraOptions.setContentId(media.getContentId());
            }
            if (media.getContentImdbId() != null) {
                youboraOptions.setContentImdbId(media.getContentImdbId());
            }
            youboraOptions.setContentIsLive(media.getContentIsLive() != null ? media.getContentIsLive() : Boolean.FALSE);
            youboraOptions.setContentIsLiveNoSeek((media.getContentIsLiveNoSeek() != null) ? media.getContentIsLiveNoSeek() : Boolean.FALSE);
            if (media.getContentLanguage() != null) {
                youboraOptions.setContentLanguage(media.getContentLanguage());
            }
            if (media.getContentPackage() != null) {
                youboraOptions.setContentPackage(media.getContentPackage());
            }
            if (media.getContentPlaybackType() != null) {
                youboraOptions.setContentPlaybackType(media.getContentPlaybackType());
            }
            if (media.getContentPrice() != null) {
                youboraOptions.setContentPrice(media.getContentPrice());
            }
            if (media.getContentProgram() != null) {
                youboraOptions.setProgram(media.getContentProgram());
            }
            if (media.getContentRendition() != null) {
                youboraOptions.setContentRendition(media.getContentRendition());
            }
            if (media.getContentResource() != null) {
                youboraOptions.setContentResource(media.getContentResource());
            }
            if (media.getContentSaga() != null) {
                youboraOptions.setContentSaga(media.getContentSaga());
            }
            if (media.getContentSeason() != null) {
                youboraOptions.setContentSeason(media.getContentSeason());
            }
            if (media.getContentStreamingProtocol() != null) {
                youboraOptions.setContentStreamingProtocol(media.getContentStreamingProtocol());
            }
            if (media.getContentSubtitles() != null) {
                youboraOptions.setContentSubtitles(media.getContentSubtitles());
            }
            if (media.getContentThroughput() != null) {
                youboraOptions.setContentThroughput(media.getContentThroughput());
            }
            if (media.getContentTitle() != null) {
                youboraOptions.setContentTitle(media.getContentTitle());
            }
            if (media.getContentTransactionCode() != null) {
                youboraOptions.setContentTransactionCode(media.getContentTransactionCode());
            }
            if (media.getContentTotalBytes() != null) {
                youboraOptions.setContentTotalBytes(media.getContentTotalBytes());
            }
            youboraOptions.setContentSendTotalBytes(media.getContentSendTotalBytes() != null ? media.getContentSendTotalBytes() : Boolean.FALSE);
            if (media.getContentTvShow() != null) {
                youboraOptions.setContentTvShow(media.getContentTvShow());
            }
            if (media.getContentType() != null) {
                youboraOptions.setContentType(media.getContentType());
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
        JsonObject mediaEntry = getMediaJsonObject();
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
                mediaEntry,
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
    private JsonObject getMediaJsonObject() {
        JsonObject mediaEntry = new JsonObject();
        Media media = getMedia();
        if (media == null) {
            return mediaEntry;
        }

        if (media.getContentBitrate() != null) {
            mediaEntry.addProperty("contentBitrate", media.getContentBitrate());
        }
        if (media.getContentCdn() != null) {
            mediaEntry.addProperty("contentCdn", media.getContentCdn());
        }
        if (media.getContentCdnNode() != null) {
            mediaEntry.addProperty("contentCdnNode", media.getContentCdnNode());
        }
        if (media.getContentCdnType() != null) {
            mediaEntry.addProperty("contentCdnType", media.getContentCdnType());
        }
        if (media.getContentChannel() != null) {
            mediaEntry.addProperty("contentChannel", media.getContentChannel());
        }
        if (media.getContentContractedResolution() != null) {
            mediaEntry.addProperty("contentContractedResolution", media.getContentContractedResolution());
        }
        if (media.getContentCost() != null) {
            mediaEntry.addProperty("contentCost", media.getContentCost());
        }
        if (media.getContentDrm() != null) {
            mediaEntry.addProperty("contentDrm", media.getContentDrm());
        }
        if (media.getContentDuration() != null) {
            mediaEntry.addProperty("contentDuration", media.getContentDuration());
        }
        if (media.getContentEncodingAudioCodec() != null) {
            mediaEntry.addProperty("contentEncodingAudioCodec", media.getContentEncodingAudioCodec());
        }
        if (media.getContentEncodingCodecProfile() != null) {
            mediaEntry.addProperty("contentEncodingCodecProfile", media.getContentEncodingCodecProfile());
        }
        if (media.getContentEncodingContainerFormat() != null) {
            mediaEntry.addProperty("contentEncodingContainerFormat", media.getContentEncodingContainerFormat());
        }
        if (media.getContentEncodingVideoCodec() != null) {
            mediaEntry.addProperty("contentEncodingVideoCodec", media.getContentEncodingVideoCodec());
        }
        if (media.getContentEpisodeTitle() != null) {
            mediaEntry.addProperty("contentEpisodeTitle", media.getContentEpisodeTitle());
        }
        if (media.getContentFps() != null) {
            mediaEntry.addProperty("contentFps", media.getContentFps());
        }
        if (media.getContentGenre() != null) {
            mediaEntry.addProperty("contentGenre", media.getContentGenre());
        }
        if (media.getContentGracenoteId() != null) {
            mediaEntry.addProperty("contentGracenoteId", media.getContentGracenoteId());
        }
        if (media.getContentId() != null) {
            mediaEntry.addProperty("contentId", media.getContentId());
        }
        if (media.getContentImdbId() != null) {
            mediaEntry.addProperty("contentImdbId", media.getContentImdbId());
        }
        mediaEntry.addProperty("contentisLive", media.getContentIsLive() != null ? media.getContentIsLive() : Boolean.FALSE);
        mediaEntry.addProperty("contentIsLiveNoSeek",  media.getContentIsLiveNoSeek() != null ? media.getContentIsLiveNoSeek() : Boolean.FALSE);
        if (media.getContentLanguage() != null) {
            mediaEntry.addProperty("contentLanguage", media.getContentLanguage());
        }
        if (media.getContentPackage() != null) {
            mediaEntry.addProperty("contentPackage", media.getContentPackage());
        }
        if (media.getContentPlaybackType() != null) {
            mediaEntry.addProperty("contentPlaybackType", media.getContentPlaybackType());
        }
        if (media.getContentPrice() != null) {
            mediaEntry.addProperty("contentPrice", media.getContentPrice());
        }
        if  (media.getContentProgram() != null) {
            mediaEntry.addProperty("contentProgram", media.getContentProgram());
        }
        if (media.getContentRendition() != null) {
            mediaEntry.addProperty("conetentRendition", media.getContentRendition());
        }
        if (media.getContentResource() != null) {
            mediaEntry.addProperty("contentResource", media.getContentResource());
        }
        if (media.getContentSaga() != null) {
            mediaEntry.addProperty("contentSaga", media.getContentSaga());
        }
        if (media.getContentSeason() != null) {
            mediaEntry.addProperty("contentSeason", media.getContentSeason());
        }
        if (media.getContentStreamingProtocol() != null) {
            mediaEntry.addProperty("contentStreamingProtocol", media.getContentStreamingProtocol());
        }
        if (media.getContentSubtitles() != null) {
            mediaEntry.addProperty("contentSubtitles", media.getContentSubtitles());
        }
        if (media.getContentThroughput() != null) {
            mediaEntry.addProperty("contentThroughput", media.getContentThroughput());
        }
        if (media.getContentTitle() != null) {
            mediaEntry.addProperty("contentTitle", media.getContentTitle());
        }
        if (media.getContentTransactionCode() != null) {
            mediaEntry.addProperty("contentTransactionCode", media.getContentTransactionCode());
        }
        if (media.getContentTotalBytes() != null) {
            mediaEntry.addProperty("contentTotalBytes", media.getContentTotalBytes());
        }
        mediaEntry.addProperty("contentSendTotalBytes", (media.getContentSendTotalBytes() != null) ? media.getContentSendTotalBytes() : Boolean.FALSE);
        if (media.getContentTvShow() != null) {
            mediaEntry.addProperty("contentTvShow", media.getContentTvShow());
        }
        if (media.getContentType() != null) {
            mediaEntry.addProperty("contentType", media.getContentType());
        }

        return mediaEntry;
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
                                                  JsonObject mediaEntry,
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
        youboraConfig.add("media", mediaEntry);
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

        if (media != null) {
            if (youboraConfigUiConf.getMedia() != null) {
                if (media.getContentBitrate() == null) {
                    media.setContentBitrate(youboraConfigUiConf.getMedia().getContentBitrate());
                }
                if (media.getContentCdn() == null) {
                    media.setContentCdn(youboraConfigUiConf.getMedia().getContentCdn());
                }
                if (media.getContentCdnNode() == null) {
                    media.setContentCdnNode(youboraConfigUiConf.getMedia().getContentCdnNode());
                }
                if (media.getContentCdnType() == null) {
                    media.setContentCdnType(youboraConfigUiConf.getMedia().getContentCdnType());
                }
                if (media.getContentChannel() == null) {
                    media.setContentChannel(youboraConfigUiConf.getMedia().getContentChannel());
                }
                if (media.getContentContractedResolution() == null) {
                    media.setContentContractedResolution(youboraConfigUiConf.getMedia().getContentContractedResolution());
                }
                if (media.getContentCost() == null) {
                    media.setContentCost(youboraConfigUiConf.getMedia().getContentCost());
                }
                if (media.getContentDrm() == null) {
                    media.setContentDrm(youboraConfigUiConf.getMedia().getContentDrm());
                }
                if (media.getContentDuration() == null) {
                    media.setContentDuration(youboraConfigUiConf.getMedia().getContentDuration());
                }
                if (media.getContentEncodingAudioCodec() == null) {
                    media.setContentEncodingAudioCodec(youboraConfigUiConf.getMedia().getContentEncodingAudioCodec());
                }
                if (media.getContentEncodingCodecProfile() == null) {
                    media.setContentEncodingCodecProfile(youboraConfigUiConf.getMedia().getContentEncodingCodecProfile());
                }
                if (media.getContentEncodingContainerFormat() == null) {
                    media.setContentEncodingContainerFormat(youboraConfigUiConf.getMedia().getContentEncodingContainerFormat());
                }
                if (media.getContentEncodingVideoCodec() == null) {
                    media.setContentEncodingVideoCodec(youboraConfigUiConf.getMedia().getContentEncodingVideoCodec());
                }
                if (media.getContentEpisodeTitle() == null) {
                    media.setContentEpisodeTitle(youboraConfigUiConf.getMedia().getContentEpisodeTitle());
                }
                if (media.getContentFps() == null) {
                    media.setContentFps(youboraConfigUiConf.getMedia().getContentFps());
                }
                if (media.getContentGenre() == null) {
                    media.setContentGenre(youboraConfigUiConf.getMedia().getContentGenre());
                }
                if (media.getContentGracenoteId() == null) {
                    media.setContentGracenoteId(youboraConfigUiConf.getMedia().getContentGracenoteId());
                }
                if (media.getContentId() == null) {
                    media.setContentId(youboraConfigUiConf.getMedia().getContentId());
                }
                if (media.getContentImdbId() == null) {
                    media.setContentImdbId(youboraConfigUiConf.getMedia().getContentImdbId());
                }
                if (media.getContentIsLive() == null) {
                    media.setContentIsLive(youboraConfigUiConf.getMedia().getContentIsLive());
                }
                if (media.getContentIsLiveNoSeek() == null) {
                    media.setContentIsLiveNoSeek(youboraConfigUiConf.getMedia().getContentIsLiveNoSeek());
                }
                if (media.getContentLanguage() == null) {
                    media.setContentLanguage(youboraConfigUiConf.getMedia().getContentLanguage());
                }
                if (media.getContentPackage() == null) {
                    media.setContentPackage(youboraConfigUiConf.getMedia().getContentPackage());
                }
                if (media.getContentPlaybackType() == null) {
                    media.setContentPlaybackType(youboraConfigUiConf.getMedia().getContentPlaybackType());
                }
                if (media.getContentPrice() == null) {
                    media.setContentPrice(youboraConfigUiConf.getMedia().getContentPrice());
                }
                if (media.getContentProgram() == null) {
                    media.setContentProgram(youboraConfigUiConf.getMedia().getContentProgram());
                }
                if (media.getContentRendition() == null) {
                    media.setContentRendition(youboraConfigUiConf.getMedia().getContentRendition());
                }
                if (media.getContentResource() == null) {
                    media.setContentResource(youboraConfigUiConf.getMedia().getContentResource());
                }
                if (media.getContentSaga() == null) {
                    media.setContentSaga(youboraConfigUiConf.getMedia().getContentSaga());
                }
                if (media.getContentSeason() == null) {
                    media.setContentSeason(youboraConfigUiConf.getMedia().getContentSeason());
                }
                if (media.getContentStreamingProtocol() == null) {
                    media.setContentStreamingProtocol(youboraConfigUiConf.getMedia().getContentStreamingProtocol());
                }
                if (media.getContentSubtitles() == null) {
                    media.setContentSubtitles(youboraConfigUiConf.getMedia().getContentSubtitles());
                }
                if (media.getContentThroughput() == null) {
                    media.setContentThroughput(youboraConfigUiConf.getMedia().getContentThroughput());
                }
                if (media.getContentTitle() == null) {
                    media.setContentTitle(youboraConfigUiConf.getMedia().getContentTitle());
                }
                if (media.getContentTransactionCode() == null) {
                    media.setContentTransactionCode(youboraConfigUiConf.getMedia().getContentTransactionCode());
                }
                if (media.getContentTotalBytes() == null) {
                    media.setContentTotalBytes(youboraConfigUiConf.getMedia().getContentTotalBytes());
                }
                if (media.getContentSendTotalBytes() == null) {
                    media.setContentSendTotalBytes(youboraConfigUiConf.getMedia().getContentSendTotalBytes());
                }
                if (media.getContentTvShow() == null) {
                    media.setContentTvShow(youboraConfigUiConf.getMedia().getContentTvShow());
                }
                if (media.getContentType() == null) {
                    media.setContentType(youboraConfigUiConf.getMedia().getContentType());
                }
            }
        } else {
            media = youboraConfigUiConf.getMedia();
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