package com.kaltura.playkit.plugins.youbora.pluginconfig;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
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

    public static final String KEY_CONTENT_METADATA_QUALITY = "quality";

    private String accountCode;

    private String username;

    private String userType;        // any string - free / paid etc.

    private String houseHoldId;    // which device is used to play

    private boolean userObfuscateIp; // Option to obfuscate the IP.

    private boolean httpSecure = true; // youbora events will be sent via https

    private Device device;

    private Media media;

    private Ads ads;

    private Properties properties;

    private ExtraParams extraParams;

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


    public Options getYouboraOptions() {
        Options youboraOptions =  new Options();

        youboraOptions.setAccountCode(accountCode);
        youboraOptions.setUsername(username);
        youboraOptions.setUserType(userType);
        youboraOptions.setUserObfuscateIp(userObfuscateIp);
        youboraOptions.setHttpSecure(httpSecure);

        youboraOptions.setParseHls(false);
        youboraOptions.setParseCdnNode(false);

        youboraOptions.setDeviceCode(null); //TODO  // List of device codes http://mapi.youbora.com:8081/devices
        youboraOptions.setContentCdn(null);


        if (device != null) {
            if (device.getDeviceCode() != null) {
                //Generic Data by code see in Device class what Codes are available
                youboraOptions.setDeviceCode(device.getDeviceCode());
            }
            // Specific Data
            if (device.getModel() != null) {
                youboraOptions.setDeviceModel(device.getModel());
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
            youboraOptions.setContentIsLive(media.getIsLive());
            youboraOptions.setContentIsLiveNoSeek((media.getIsDVR() != null) ? !media.getIsDVR() : Boolean.FALSE);
            youboraOptions.setContentDuration(media.getDuration());
            youboraOptions.setContentTitle(media.getTitle());
            youboraOptions.setProgram(media.getTitle2());
        }

        youboraOptions.setAdResource(null);
        if (ads != null) {
            youboraOptions.setAdCampaign(ads.getCampaign());
        }
        youboraOptions.setAdTitle("");

        setContentPropertiesBundle(youboraOptions);

        youboraOptions.setContentMetadata(getContentMetaDataBundle());

        if (ads != null && ads.getExtraParams() != null) {
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

    private void setContentPropertiesBundle(Options youboraOptions) {
        Properties prop = getProperties();
        if (prop == null) {
            return;
        }

        youboraOptions.setContentGenre(prop.getGenre());
        youboraOptions.setContentType(prop.getType());
        youboraOptions.setContentTransactionCode(prop.getTransactionType());
        youboraOptions.setContentPrice(prop.getPrice());
        youboraOptions.setContentRendition(prop.getQuality()); // Name or value of the current rendition (quality) of the content.
        youboraOptions.setContentPackage(prop.getContentPackage());
        youboraOptions.setContentSaga(prop.getContentSaga());
        youboraOptions.setContentTvShow(prop.getContentTvShow());
        youboraOptions.setContentSeason(prop.getContentSeason());
        youboraOptions.setContentEpisodeTitle(prop.getContentEpisodeTitle());
        youboraOptions.setContentChannel(prop.getContentChannel());
        youboraOptions.setContentId(prop.getContentId());
        youboraOptions.setContentImdbId(prop.getContentImdbId());
        youboraOptions.setContentGracenoteId(prop.getContentGracenoteId());
        youboraOptions.setContentLanguage(prop.getContentLanguage());
        youboraOptions.setContentSubtitles(prop.getContentSubtitles());
        youboraOptions.setContentContractedResolution(prop.getContentContractedResolution());
        youboraOptions.setContentPlaybackType(prop.getContentPlaybackType());
        youboraOptions.setContentDrm(prop.getContentDrm());
        youboraOptions.setContentEncodingVideoCodec(prop.getContentEncodingVideoCodec());
        youboraOptions.setContentEncodingAudioCodec(prop.getContentEncodingAudioCodec());
        youboraOptions.setContentEncodingCodecProfile(prop.getContentEncodingCodecProfile());
        youboraOptions.setContentEncodingContainerFormat(prop.getContentEncodingContainerFormat());
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
        propertiesBundle.putString("audioType", (prop.getAudioType() != null) ? prop.getAudioType() : "");
        propertiesBundle.putString("audioChannels", (prop.getAudioChannels() != null) ? prop.getAudioChannels() : "");
        propertiesBundle.putString("device", (prop.getDevice() != null) ? prop.getDevice() : "");
        propertiesBundle.putString("rating", (prop.getRating() != null) ? prop.getRating() : "");
        propertiesBundle.putString("year", (prop.getYear() != null) ? prop.getYear() : "");
        propertiesBundle.putString("cast", (prop.getCast() != null) ? prop.getCast() : "");
        propertiesBundle.putString("owner", (prop.getOwner() != null) ? prop.getOwner() : "");

        return propertiesBundle;
    }

    public JsonObject toJson() {
        JsonPrimitive accountCode = new JsonPrimitive(getAccountCode() != null ? getAccountCode() : "");
        JsonPrimitive username = new JsonPrimitive(getUsername() != null ? getUsername() : "");
        JsonPrimitive userType = new JsonPrimitive(getUserType() != null ? getUserType() : "");
        JsonPrimitive houseHoldId = new JsonPrimitive(getHouseHoldId() != null ? getHouseHoldId() : "");
        JsonPrimitive isUserObfuscateIp = new JsonPrimitive(isUserObfuscateIp());
        JsonPrimitive httpSecure = new JsonPrimitive(getHttpSecure());
        JsonObject device = getDeviceJsonObject();
        JsonObject mediaEntry = getMediaJsonObject();
        JsonObject adsEntry = new JsonObject();
        adsEntry.addProperty("campaign", (getAds() != null && getAds().getCampaign() != null) ? getAds().getCampaign() : "");
        JsonObject propertiesEntry = getPropertiesJsonObject();
        JsonObject extraParamEntry = getExtraParamJsonObject();
        return getYouboraConfigJsonObject(accountCode, username, userType, houseHoldId, isUserObfuscateIp, httpSecure, device, mediaEntry, adsEntry, propertiesEntry, extraParamEntry);
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

        if (device.getBrand() != null) {
            deviceJsonObject.addProperty("brand", device.getBrand());
        }

        if (device.getType() != null) {
            deviceJsonObject.addProperty("deviceCode", device.getType());
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

        mediaEntry.addProperty("resource", media.getResource() != null ? media.getResource() : "");
        mediaEntry.addProperty("isLive", media.getIsLive() != null ? media.getIsLive() : Boolean.FALSE);
        mediaEntry.addProperty("isDVR",  media.getIsDVR() != null ? media.getIsDVR() : Boolean.FALSE);
        mediaEntry.addProperty("title",  media.getTitle() != null ? media.getTitle() : "");
        mediaEntry.addProperty("title2",  media.getTitle2() != null ? media.getTitle2() : "");
        if (media.getDuration() != null) {
            mediaEntry.addProperty("duration", media.getDuration());
        }
        mediaEntry.addProperty("transactionCode",  media.getTransactionCode() != null ? media.getTransactionCode() : "");
        return mediaEntry;
    }

    @NonNull
    private JsonObject getYouboraConfigJsonObject(JsonPrimitive accountCode, JsonPrimitive username, JsonPrimitive userType, JsonPrimitive houseHoldId, JsonPrimitive isUserObfuscateIp, JsonPrimitive httpSecure,
                                                  JsonObject device, JsonObject mediaEntry, JsonObject adsEntry, JsonObject propertiesEntry, JsonObject extraParamEntry) {
        JsonObject youboraConfig = new JsonObject();
        youboraConfig.add("accountCode", accountCode);
        youboraConfig.add("username", username);
        youboraConfig.add("userType", userType);
        youboraConfig.add("houseHoldId", houseHoldId);
        youboraConfig.add("userObfuscateIp", isUserObfuscateIp);
        youboraConfig.add("httpSecure", httpSecure);

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
        propertiesEntry.addProperty("genre", (prop.getGenre() != null) ? prop.getGenre() : "");
        propertiesEntry.addProperty("type", (prop.getType() != null) ? prop.getType() : "");
        propertiesEntry.addProperty("transactionType", (prop.getTransactionType() != null) ? prop.getTransactionType() : "");
        propertiesEntry.addProperty("year", (prop.getYear() != null) ? prop.getYear() : "");
        propertiesEntry.addProperty("cast", (prop.getCast() != null) ? prop.getCast() : "");
        propertiesEntry.addProperty("director", (prop.getDirector() != null) ? prop.getDirector() : "");
        propertiesEntry.addProperty("owner", (prop.getOwner() != null) ? prop.getOwner() : "");
        propertiesEntry.addProperty("parental", (prop.getParental() != null) ? prop.getParental() : "");
        propertiesEntry.addProperty("price", (prop.getPrice() != null) ? prop.getPrice() : "");
        propertiesEntry.addProperty("rating", (prop.getRating() != null) ? prop.getRating() : "");
        propertiesEntry.addProperty("audioType", (prop.getAudioType() != null) ? prop.getAudioType() : "");
        propertiesEntry.addProperty("audioChannels", (prop.getAudioChannels() != null) ? prop.getAudioChannels() : "");
        propertiesEntry.addProperty("device", (prop.getDevice() != null) ? prop.getDevice() : "");
        propertiesEntry.addProperty("quality", (prop.getQuality() != null) ? prop.getQuality() : "");

        propertiesEntry.addProperty("contentPackage", (prop.getContentPackage() != null) ? prop.getContentPackage() : "");
        propertiesEntry.addProperty("contentSaga", (prop.getContentSaga() != null) ? prop.getContentSaga() : "");
        propertiesEntry.addProperty("contentTvShow", (prop.getContentTvShow() != null) ? prop.getContentTvShow() : "");
        propertiesEntry.addProperty("contentSeason", (prop.getContentSeason() != null) ? prop.getContentSeason() : "");
        propertiesEntry.addProperty("contentEpisodeTitle", (prop.getContentEpisodeTitle() != null) ? prop.getContentEpisodeTitle() : "");
        propertiesEntry.addProperty("contentChannel", (prop.getContentChannel() != null) ? prop.getContentChannel() : "");
        propertiesEntry.addProperty("contentId", (prop.getContentId() != null) ? prop.getContentId() : "");
        propertiesEntry.addProperty("contentImdbId", (prop.getContentImdbId() != null) ? prop.getContentImdbId() : "");
        propertiesEntry.addProperty("contentGracenoteId", (prop.getContentGracenoteId() != null) ? prop.getContentGracenoteId() : "");
        propertiesEntry.addProperty("contentLanguage", (prop.getContentLanguage() != null) ? prop.getContentLanguage() : "");
        propertiesEntry.addProperty("contentSubtitles", (prop.getContentSubtitles() != null) ? prop.getContentSubtitles() : "");
        propertiesEntry.addProperty("contentContractedResolution", (prop.getContentContractedResolution() != null) ? prop.getContentContractedResolution() : "");
        propertiesEntry.addProperty("contentPlaybackType", (prop.getContentPlaybackType() != null) ? prop.getContentPlaybackType() : "");
        propertiesEntry.addProperty("contentDrm", (prop.getContentDrm() != null) ? prop.getContentDrm() : "");
        propertiesEntry.addProperty("contentEncodingVideoCodec", (prop.getContentEncodingVideoCodec() != null) ? prop.getContentEncodingVideoCodec() : "");
        propertiesEntry.addProperty("contentEncodingAudioCodec", (prop.getContentEncodingAudioCodec() != null) ? prop.getContentEncodingAudioCodec() : "");
        propertiesEntry.addProperty("contentEncodingCodecProfile", (prop.getContentEncodingCodecProfile() != null) ? prop.getContentEncodingCodecProfile() : "");
        propertiesEntry.addProperty("contentEncodingContainerFormat", (prop.getContentEncodingContainerFormat() != null) ? prop.getContentEncodingContainerFormat() : "");

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

        if (media != null) {
            if (youboraConfigUiConf.getMedia() != null) {
                if (media.getIsLive() == null) {
                    media.setIsLive(youboraConfigUiConf.getMedia().getIsLive());
                }
                if (media.getTitle() == null) {
                    media.setTitle(youboraConfigUiConf.getMedia().getTitle());
                }
                if (media.getDuration() == null) {
                    media.setDuration(youboraConfigUiConf.getMedia().getDuration());
                }
            }
        } else {
            media = youboraConfigUiConf.getMedia();
        }

        if (ads != null) {
            if (ads.getCampaign() == null) {
                if (youboraConfigUiConf.getAds() != null) {
                    ads.setCampaign(youboraConfigUiConf.getAds().getCampaign());
                }
            }
        } else {
            ads = youboraConfigUiConf.getAds();
        }

        if (properties != null) {
            if (youboraConfigUiConf.getProperties() != null) {
                Properties propUiConf = youboraConfigUiConf.getProperties();
                if (TextUtils.isEmpty((properties.getGenre()))) {
                    properties.setGenre(propUiConf.getGenre());
                }
                if (TextUtils.isEmpty((properties.getType()))) {
                    properties.setType(propUiConf.getType());
                }
                if (TextUtils.isEmpty((properties.getTransactionType()))) {
                    properties.setTransactionType(propUiConf.getTransactionType());
                }
                if (TextUtils.isEmpty((properties.getAudioChannels()))) {
                    properties.setAudioChannels(propUiConf.getAudioChannels());
                }
                if (TextUtils.isEmpty((properties.getAudioType()))) {
                    properties.setAudioType(propUiConf.getAudioType());
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
                if (TextUtils.isEmpty((properties.getQuality()))) {
                    properties.setQuality(propUiConf.getQuality());
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