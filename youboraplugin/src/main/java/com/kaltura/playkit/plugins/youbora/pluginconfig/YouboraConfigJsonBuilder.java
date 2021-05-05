package com.kaltura.playkit.plugins.youbora.pluginconfig;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.Map;


public class YouboraConfigJsonBuilder {

    @NonNull
    static JsonObject getYouboraConfigJsonObject( Map<String, JsonPrimitive> rootLevelParams,
                                                 JsonObject app,
                                                 JsonObject parse,
                                                 JsonObject device,
                                                 JsonObject content,
                                                 JsonObject network,
                                                 JsonObject errors,
                                                 JsonObject ads,
                                                 JsonObject properties,
                                                 JsonObject customDimentions) {
        JsonObject youboraConfig = new JsonObject();
        for (Map.Entry<String, JsonPrimitive> entry :rootLevelParams.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && entry.getValue() != null) {
                youboraConfig.add(entry.getKey(), entry.getValue());
            }
        }

        youboraConfig.add("app", app);
        youboraConfig.add("parse", parse);
        youboraConfig.add("device", device);
        youboraConfig.add("content", content);
        youboraConfig.add("network", network);
        youboraConfig.add("errors", errors);
        youboraConfig.add("ads", ads);
        youboraConfig.add("properties", properties);
        youboraConfig.add("customDimentions", customDimentions);
        return youboraConfig;
    }

    @NonNull
    static JsonObject getAppJsonObject(App app) {
        JsonObject appJsonObject = new JsonObject();
        if (app == null) {
            return appJsonObject;
        }

        if (app.getAppName() != null) {
            appJsonObject.addProperty("appName", app.getAppName());
        }

        if (app.getAppReleaseVersion() != null) {
            appJsonObject.addProperty("appName", app.getAppReleaseVersion());
        }

        return appJsonObject;
    }

    @NonNull
    static JsonObject getParseJsonObject(Parse parse) {

        JsonObject parseJsonObject = new JsonObject();
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

        if (parse.getParseCdnNodeList() != null) {
            JsonArray parseCdnNodeListJsonArray = new JsonArray();
            for(String cdn : parse.getParseCdnNodeList()) {
                parseCdnNodeListJsonArray.add(cdn);
            }
            parseJsonObject.add("parseCdnNodeList", parseCdnNodeListJsonArray);
        }

        if (parse.getParseCdnNameHeader() != null) {
            parseJsonObject.addProperty("parseCdnNameHeader", parse.getParseCdnNameHeader() );
        }

        if (parse.getParseCdnTTL() != null) {
            parseJsonObject.addProperty("parseCdnTTL", parse.getParseCdnTTL());
        }
        return parseJsonObject;
    }

    @NonNull
    static JsonObject getDeviceJsonObject(Device device) {
        JsonObject deviceJsonObject = new JsonObject();
        if (device == null) {
            return deviceJsonObject;
        }

        if (device.getDeviceCode() != null) {
            deviceJsonObject.addProperty("deviceCode", device.getDeviceCode());
        }

        if (device.getDeviceModel() != null) {
            deviceJsonObject.addProperty("deviceModel", device.getDeviceModel());
        }

        if (device.getDeviceId() != null) {
            deviceJsonObject.addProperty("deviceId", device.getDeviceId());
        }

        if (device.getDeviceBrand() != null) {
            deviceJsonObject.addProperty("deviceBrand", device.getDeviceBrand());
        }

        if (device.getDeviceType() != null) {
            deviceJsonObject.addProperty("deviceType", device.getDeviceType());
        }

        if (device.getDeviceOsName() != null) {
            deviceJsonObject.addProperty("deviceOsName", device.getDeviceOsName());
        }

        if (device.getDeviceOsVersion() != null) {
            deviceJsonObject.addProperty("deviceOsVersion", device.getDeviceOsVersion());
        }
        return deviceJsonObject;
    }

    @NonNull
    static JsonObject getContentJsonObject(Content content) {

        JsonObject contentEntry = new JsonObject();
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
        if (content.getContentIsLiveNoSeek() != null) {
            contentEntry.addProperty("contentIsLiveNoSeek", content.getContentIsLiveNoSeek());
        } else if (content.getIsDVR() != null) {
            contentEntry.addProperty("contentIsLiveNoSeek", !content.getIsDVR());
        }

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
        if (content.getContentTransportFormat() != null) {
            contentEntry.addProperty("contentTransportFormat", content.getContentTransportFormat());
        }
        contentEntry.addProperty("contentSendTotalBytes", content.getContentSendTotalBytes());
        if (content.getContentTvShow() != null) {
            contentEntry.addProperty("contentTvShow", content.getContentTvShow());
        }
        if (content.getContentType() != null) {
            contentEntry.addProperty("contentType", content.getContentType());
        }

        return contentEntry;
    }

    @NonNull
    static JsonObject getNetworkJsonObject(Network network) {

        JsonObject networkJsonObject = new JsonObject();
        if (network == null) {
            return networkJsonObject;
        }

        if (network.getNetworkConnectionType() != null) {
            networkJsonObject.addProperty("networkConnectionType", network.getNetworkConnectionType());
        }

        if (network.getNetworkIP() != null) {
            networkJsonObject.addProperty("networkIP", network.getNetworkIP());
        }

        if (network.getNetworkIsp() != null) {
            networkJsonObject.addProperty("setNetworkIsp", network.getNetworkIsp());
        }

        return networkJsonObject;
    }

    @NonNull
    static  JsonObject getErrorsJsonObject(Errors errors) {

        JsonObject errorsJsonObject = new JsonObject();
        if (errors == null) {
            return errorsJsonObject;
        }

        if (errors.getErrorsIgnore() != null) {
            JsonArray errorsIgnoreJsonArray = new JsonArray();
            for(String  errorIgnore : errors.getErrorsIgnore()) {
                errorsIgnoreJsonArray.add(errorIgnore);
            }
            errorsJsonObject.add("errorsIgnore", errorsIgnoreJsonArray);
        }

        if (errors.getErrorsFatal() != null) {
            JsonArray errorsFatalJsonArray = new JsonArray();
            for(String  errorFatal : errors.getErrorsFatal()) {
                errorsFatalJsonArray.add(errorFatal);
            }
            errorsJsonObject.add("errorsFatal", errorsFatalJsonArray);
        }

        if (errors.getErrorsNonFatal() != null) {
            JsonArray errorsNonFatalJsonArray = new JsonArray();

            for(String  errorNonFatal : errors.getErrorsNonFatal()) {
                errorsNonFatalJsonArray.add(errorNonFatal);
            }
            errorsJsonObject.add("errorsNonFatal", errorsNonFatalJsonArray);
        }

        return errorsJsonObject;
    }


    @NonNull
    static JsonObject getAdsJsonObject(Ads ads) {

        JsonObject adsEntry = new JsonObject();
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
        if (ads.getAdGivenAds() != null) {
            adsEntry.addProperty("adGivenAds", ads.getAdGivenAds());
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
    static JsonObject getPropertiesJsonObject(Properties prop) {
        JsonObject propertiesEntry = new JsonObject();
        if (prop == null) {
            return propertiesEntry;
        }

        if (prop.getYear() != null) {
            propertiesEntry.addProperty("year", prop.getYear());
        }
        if (prop.getCast() != null) {
            propertiesEntry.addProperty("cast", prop.getCast());
        }
        if (prop.getDirector() != null) {
            propertiesEntry.addProperty("director",  prop.getDirector());
        }
        if (prop.getOwner() != null) {
            propertiesEntry.addProperty("owner", prop.getOwner());
        }
        if (prop.getParental() != null) {
            propertiesEntry.addProperty("parental", prop.getParental());
        }
        if (prop.getRating() != null) {
            propertiesEntry.addProperty("rating", prop.getRating());
        }
        if (prop.getDevice() != null) {
            propertiesEntry.addProperty("device", prop.getDevice());
        }
        if (prop.getAudioChannels() != null) {
            propertiesEntry.addProperty("audioChannels", prop.getAudioChannels());
        }

        /// LEGACY SUPPORT:
        if (prop.getGenre() != null) {
            propertiesEntry.addProperty("genre", prop.getGenre());
        }
        if (prop.getType() != null) {
            propertiesEntry.addProperty("type", prop.getType());
        }
        if (prop.getTransactionType() != null) {
            propertiesEntry.addProperty("transactionType", prop.getTransactionType());
        }
        if (prop.getDevice() != null) {
            propertiesEntry.addProperty("device", prop.getDevice());
        }
        if (prop.getQuality() != null) {
            propertiesEntry.addProperty("quality", prop.getQuality());
        }
        if (prop.getContentPackage() != null) {
            propertiesEntry.addProperty("contentPackage", prop.getContentPackage());
        }
        if (prop.getContentCdnCode() != null) {
            propertiesEntry.addProperty("contentCdnCode", prop.getContentCdnCode());
        }
        if (prop.getContentSaga() != null) {
            propertiesEntry.addProperty("contentSaga", prop.getContentSaga());
        }
        if (prop.getContentTvShow() != null) {
            propertiesEntry.addProperty("contentTvShow", prop.getContentTvShow());
        }
        if (prop.getContentSeason() != null) {
            propertiesEntry.addProperty("contentSeason", prop.getContentSeason());
        }
        if (prop.getContentEpisodeTitle() != null) {
            propertiesEntry.addProperty("contentEpisodeTitle", prop.getContentEpisodeTitle());
        }
        if (prop.getContentChannel() != null) {
            propertiesEntry.addProperty("contentChannel", prop.getContentChannel());
        }
        if (prop.getContentId() != null) {
            propertiesEntry.addProperty("contentId", prop.getContentId());
        }
        if (prop.getContentImdbId() != null) {
            propertiesEntry.addProperty("contentImdbId", prop.getContentImdbId());
        }
        if (prop.getContentGracenoteId() != null) {
            propertiesEntry.addProperty("contentGracenoteId", prop.getContentGracenoteId());
        }
        if (prop.getContentLanguage() != null) {
            propertiesEntry.addProperty("contentLanguage", prop.getContentLanguage());
        }
        if (prop.getContentSubtitles() != null) {
            propertiesEntry.addProperty("contentSubtitles", prop.getContentSubtitles());
        }
        if (prop.getContentContractedResolution() != null) {
            propertiesEntry.addProperty("contentContractedResolution", prop.getContentContractedResolution());
        }
        if (prop.getContentPlaybackType() != null) {
            propertiesEntry.addProperty("contentPlaybackType", prop.getContentPlaybackType());
        }
        if (prop.getContentDrm() != null) {
            propertiesEntry.addProperty("contentDrm", prop.getContentDrm());
        }
        if (prop.getContentEncodingVideoCodec() != null) {
            propertiesEntry.addProperty("contentEncodingVideoCodec", prop.getContentEncodingVideoCodec());
        }
        if (prop.getContentEncodingAudioCodec() != null) {
            propertiesEntry.addProperty("contentEncodingAudioCodec", prop.getContentEncodingAudioCodec());
        }
        if (prop.getContentEncodingCodecProfile() != null) {
            propertiesEntry.addProperty("contentEncodingCodecProfile", prop.getContentEncodingCodecProfile());
        }
        if (prop.getContentEncodingContainerFormat() != null) {
            propertiesEntry.addProperty("contentEncodingContainerFormat", prop.getContentEncodingContainerFormat());
        }

        return propertiesEntry;
    }

    @NonNull
    static JsonObject getCustomDimentionsJsonObject(CustomDimensions customDimensions) {
        JsonObject customDimensionsEntry = new JsonObject();
        if (customDimensions== null) {
            return customDimensionsEntry;
        }

        if (customDimensions.getCustomDimension1() != null) {
            customDimensionsEntry.addProperty("customDimension1", customDimensions.getCustomDimension1());
        }
        if (customDimensions.getCustomDimension2() != null) {
            customDimensionsEntry.addProperty("customDimension2", customDimensions.getCustomDimension2());
        }
        if (customDimensions.getCustomDimension3() != null) {
            customDimensionsEntry.addProperty("customDimension3", customDimensions.getCustomDimension3());
        }
        if (customDimensions.getCustomDimension4() != null) {
            customDimensionsEntry.addProperty("customDimension4", customDimensions.getCustomDimension4());
        }
        if (customDimensions.getCustomDimension5() != null) {
            customDimensionsEntry.addProperty("customDimension5", customDimensions.getCustomDimension5());
        }
        if (customDimensions.getCustomDimension6() != null) {
            customDimensionsEntry.addProperty("customDimension6", customDimensions.getCustomDimension6());
        }
        if (customDimensions.getCustomDimension7() != null) {
            customDimensionsEntry.addProperty("customDimension7", customDimensions.getCustomDimension7());
        }
        if (customDimensions.getCustomDimension8() != null) {
            customDimensionsEntry.addProperty("customDimension8", customDimensions.getCustomDimension8());
        }
        if (customDimensions.getCustomDimension9() != null) {
            customDimensionsEntry.addProperty("customDimension9", customDimensions.getCustomDimension9());
        }
        if (customDimensions.getCustomDimension10() != null) {
            customDimensionsEntry.addProperty("customDimension10", customDimensions.getCustomDimension10());
        }
        if (customDimensions.getCustomDimension11() != null) {
            customDimensionsEntry.addProperty("customDimension11", customDimensions.getCustomDimension11());
        }
        if (customDimensions.getCustomDimension12() != null) {
            customDimensionsEntry.addProperty("customDimension12", customDimensions.getCustomDimension12());
        }
        if (customDimensions.getCustomDimension13() != null) {
            customDimensionsEntry.addProperty("customDimension13", customDimensions.getCustomDimension13());
        }
        if (customDimensions.getCustomDimension14() != null) {
            customDimensionsEntry.addProperty("customDimension14", customDimensions.getCustomDimension14());
        }
        if (customDimensions.getCustomDimension15() != null) {
            customDimensionsEntry.addProperty("customDimension15", customDimensions.getCustomDimension15());
        }
        if (customDimensions.getCustomDimension16() != null) {
            customDimensionsEntry.addProperty("customDimension16", customDimensions.getCustomDimension16());
        }
        if (customDimensions.getCustomDimension17() != null) {
            customDimensionsEntry.addProperty("customDimension17", customDimensions.getCustomDimension17());
        }
        if (customDimensions.getCustomDimension18() != null) {
            customDimensionsEntry.addProperty("customDimension18", customDimensions.getCustomDimension18());
        }
        if (customDimensions.getCustomDimension19() != null) {
            customDimensionsEntry.addProperty("customDimension19", customDimensions.getCustomDimension19());
        }
        if (customDimensions.getCustomDimension20() != null) {
            customDimensionsEntry.addProperty("customDimension20", customDimensions.getCustomDimension20());
        }
        return customDimensionsEntry;
    }
}
