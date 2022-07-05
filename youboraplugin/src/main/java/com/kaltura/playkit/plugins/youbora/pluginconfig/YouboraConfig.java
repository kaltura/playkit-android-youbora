package com.kaltura.playkit.plugins.youbora.pluginconfig;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import com.npaw.youbora.lib6.comm.transform.ViewTransform;
import com.npaw.youbora.lib6.plugin.Options;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    private String host;

    /**
     * Optional: auth token to validate all the requests.
     */
    private String authToken;

    /**
     * Optional: auth type. Used if authToken is set.
     */
    private String authType;

    private String username;

    private String houseHoldId; // which device is used to play

    /**
     * @deprecated This value is part of {@link User}
     */
    @Deprecated
    private String userEmail; // backward compatibility

    /**
     * @deprecated This value is part of {@link User}
     */
    @Deprecated
    private String userAnonymousId; // backward compatibility

    /**
     * @deprecated This value is part of {@link User}
     */
    @Deprecated
    private String userType; // any string - free / paid etc.   // backward compatibility

    /**
     * @deprecated This value is part of {@link User}
     */
    @Deprecated
    private boolean userObfuscateIp; // Option to obfuscate the IP. // backward compatibility

    private boolean httpSecure = true; // youbora events will be sent via https

    /**
     * @deprecated This value is part of {@link App}
     */
    @Deprecated
    private String appName = "";

    /**
     * @deprecated This value is part of {@link App}
     */
    @Deprecated
    private String appReleaseVersion = "";

    private String urlToParse;

    private String linkedViewId;

    private boolean isAutoStart = true;

    @SerializedName(value="isAutoDetectBackground", alternate={"autoDetectBackground"})
    private boolean isAutoDetectBackground = true; // backward compatible

    @SerializedName(value="isEnabled", alternate={"enabled"})
    private boolean isEnabled = true; // backward compatible

    @SerializedName(value="isForceInit", alternate={"forceInit"})
    private boolean isForceInit; // backward compatible

    @SerializedName(value="isOffline", alternate={"offline"})
    private boolean isOffline; // backward compatible

    /**
     * Enabling this option enables the posibility of getting the /start request later on the view,
     * making the flow go as follows: /init is sent when the player starts to load content,
     * then when the playback starts /joinTime event will be sent, but with the difference of no
     * /start request, instead it will be delayed until all the option keys from
     * {@link #pendingMetadata} are not <b>null</b>, this is very important, since an empty string
     * is considered a not null and therefore is a valid value.
     */
    private boolean waitForMetadata;

    private ArrayList<String> pendingMetadata;

    @SerializedName(value="sessionMetrics", alternate={"session"})
    private HashMap<String, String> sessionMetrics;

    /**
     * Use user object to pass
     * userEmail, userAnonymousId, userType, userObfuscateIp
     * If User object is passed along with that individually the values are also passed
     * apart from User's object then User object will be prioritized
     *
     * Either pass User object or pass individual values (backward compatibility)
     */
    private User user;

    private App app;

    private Parse parse;

    private Device device;

    @SerializedName(value="content", alternate={"media"})
    private Content content;

    private Network network;

    private Errors errors;

    @SerializedName(value="ads", alternate={"ad"})
    private Ads ads; // backward compatible

    /**
     * @deprecated This is moved internally to {@link Content} metadata and {@link Ads} metadata
     */
    @Deprecated
    private Properties properties;

    /**
     * @deprecated This is moved internally to {@link Content} and {@link Ads} custom dimensions
     */
    @Deprecated
    @SerializedName(value="contentCustomDimensions", alternate={"extraParams", "customDimension", "customDimensions"})
    private ContentCustomDimensions contentCustomDimensions;

    private ViewTransform.FastDataConfig fastDataConfig;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    @Nullable
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Nullable
    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Deprecated
    public String getUserEmail() {
        return userEmail;
    }

    @Deprecated
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Deprecated
    public String getUserAnonymousId() {
        return userAnonymousId;
    }

    @Deprecated
    public void setUserAnonymousId(String userAnonymousId) {
        this.userAnonymousId = userAnonymousId;
    }

    @Deprecated
    public String getUserType() {
        return userType;
    }

    @Deprecated
    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean getHttpSecure() {
        return httpSecure;
    }

    public void setHttpSecure(boolean httpSecure) {
        this.httpSecure = httpSecure;
    }

    @Deprecated
    public String getAppName() {
        return appName;
    }

    @Deprecated
    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Deprecated
    public String getAppReleaseVersion() {
        return appReleaseVersion;
    }

    @Deprecated
    public void setAppReleaseVersion(String appReleaseVersion) {
        this.appReleaseVersion = appReleaseVersion;
    }

    public String getUrlToParse() {
        return urlToParse;
    }

    public void setUrlToParse(String urlToParse) {
        this.urlToParse = urlToParse;
    }

    public String getLinkedViewId() {
        return linkedViewId;
    }

    public void setLinkedViewId(String linkedViewId) {
        this.linkedViewId = linkedViewId;
    }

    public String getHouseHoldId() {
        return houseHoldId;
    }

    public void setHouseHoldId(String houseHoldId) {
        this.houseHoldId = houseHoldId;
    }

    @Deprecated
    public boolean getUserObfuscateIp() {
        return userObfuscateIp;
    }

    @Deprecated
    public void setUserObfuscateIp(boolean userObfuscateIp) {
        this.userObfuscateIp = userObfuscateIp;
    }

    public boolean getIsAutoStart() {
        return isAutoStart;
    }

    public void setIsAutoStart(boolean isAutoStart) {
        this.isAutoStart = isAutoStart;
    }

    public boolean getIsAutoDetectBackground() {
        return isAutoDetectBackground;
    }

    public void setIsAutoDetectBackground(boolean isAutoDetectBackground) {
        this.isAutoDetectBackground = isAutoDetectBackground;
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean getIsForceInit() {
        return isForceInit;
    }

    public void setIsForceInit(boolean forceInit) {
        isForceInit = forceInit;
    }

    public boolean getIsOffline() {
        return isOffline;
    }

    public void setIsOffline(boolean isOffline) {
        this.isOffline = isOffline;
    }

    public boolean isWaitForMetadata() {
        return waitForMetadata;
    }

    public void setWaitForMetadata(boolean waitForMetadata) {
        this.waitForMetadata = waitForMetadata;
    }

    public ArrayList<String> getPendingMetadata() {
        return pendingMetadata;
    }

    public void setPendingMetadata(ArrayList<String> pendingMetadata) {
        this.pendingMetadata = pendingMetadata;
    }

    public HashMap<String, String> getSessionMetrics() {
        return sessionMetrics;
    }

    public void setSessionMetrics(HashMap<String, String> sessionMetrics) {
        this.sessionMetrics = sessionMetrics;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public Parse getParse() {
        return parse;
    }

    public void setParse(Parse parse) {
        this.parse = parse;
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

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }

    public Ads getAds() {
        return ads;
    }

    public void setAds(Ads ads) {
        this.ads = ads;
    }

    @Deprecated
    public Properties getProperties() {
        return properties;
    }

    @Deprecated
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Deprecated
    public ContentCustomDimensions getContentCustomDimensions() {
        return contentCustomDimensions;
    }

    @Deprecated
    public void setContentCustomDimensions(ContentCustomDimensions contentCustomDimensions) {
        this.contentCustomDimensions = contentCustomDimensions;
    }

    public ViewTransform.FastDataConfig getFastDataConfig() {
        return fastDataConfig;
    }

    public void setFastDataConfig(ViewTransform.FastDataConfig fastDataConfig) {
        this.fastDataConfig = fastDataConfig;
    }

    public Options getYouboraOptions() {
        Options youboraOptions = new Options();

        youboraOptions.setAccountCode(accountCode);
        if (!TextUtils.isEmpty(host)) {
            youboraOptions.setHost(host);
        }
        youboraOptions.setAuthToken(authToken);
        if (!TextUtils.isEmpty(authType)) {
            youboraOptions.setAuthType(authType);
        }
        youboraOptions.setUsername(username);

        youboraOptions.setUserEmail((user != null && !TextUtils.isEmpty(user.getEmail())) ? user.getEmail() : userEmail);
        youboraOptions.setUserAnonymousId((user != null && !TextUtils.isEmpty(user.getAnonymousId())) ? user.getAnonymousId() : userAnonymousId);
        youboraOptions.setUserType((user != null && !TextUtils.isEmpty(user.getType())) ? user.getType() : userType);
        youboraOptions.setUserObfuscateIp((user != null && user.getObfuscateIp() != null) ? user.getObfuscateIp() : userObfuscateIp);

        youboraOptions.setAppName((app != null && !TextUtils.isEmpty(app.getAppName())) ? app.getAppName() : appName);
        youboraOptions.setAppReleaseVersion((app != null && !TextUtils.isEmpty(app.getAppReleaseVersion())) ? app.getAppReleaseVersion() : appReleaseVersion);

        youboraOptions.setUrlToParse(urlToParse);
        youboraOptions.setLinkedViewId(linkedViewId);

        youboraOptions.setHttpSecure(httpSecure);
        youboraOptions.setAutoStart(isAutoStart);
        youboraOptions.setAutoDetectBackground(isAutoDetectBackground);
        youboraOptions.setEnabled(isEnabled);
        youboraOptions.setForceInit(isForceInit);
        youboraOptions.setOffline(isOffline);
        youboraOptions.setWaitForMetadata(waitForMetadata);

        if (pendingMetadata != null && !pendingMetadata.isEmpty()) {
            youboraOptions.setPendingMetadata(pendingMetadata);
        }

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
            if (parse.getParseCdnNodeList() != null) {
                youboraOptions.setParseCdnNodeList(parse.getParseCdnNodeList());
            }
            if (parse.getParseCdnNameHeader() != null) {
                youboraOptions.setParseCdnNameHeader(parse.getParseCdnNameHeader());
            }
            if (parse.getParseNodeHeader() != null) {
                youboraOptions.setParseNodeHeader(parse.getParseNodeHeader());
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
            if (device.getDeviceId() != null) {
                youboraOptions.setDeviceId(device.getDeviceId());
            }

            // Specific Data
            if (device.getDeviceModel() != null) {
                youboraOptions.setDeviceModel(device.getDeviceModel());
            }

            if (device.getDeviceBrand() != null) {
                youboraOptions.setDeviceBrand(device.getDeviceBrand());
            }

            if (device.getDeviceType() != null) {
                youboraOptions.setDeviceType(device.getDeviceType());
            }

            if (device.getDeviceOsName() != null) {
                youboraOptions.setDeviceOsName(device.getDeviceOsName());
            }

            if (device.getDeviceOsVersion() != null) {
                youboraOptions.setDeviceOsVersion(device.getDeviceOsVersion());
            }

            if (device.getDeviceEdId() != null) {
                youboraOptions.setDeviceEDID(device.getDeviceEdId());
            }

            if (device.getDeviceIsAnonymous() != null) {
                youboraOptions.setDeviceIsAnonymous(device.getDeviceIsAnonymous());
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
            if (content.getContentIsLive() != null) {
                youboraOptions.setContentIsLive(content.getContentIsLive());
            }
            if (content.getContentIsLiveNoSeek() != null) {
                youboraOptions.setContentIsLiveNoSeek(content.getContentIsLiveNoSeek());
            } else if (content.isDVR() != null) {
                youboraOptions.setContentIsLiveNoSeek(!content.isDVR());
            }

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
            if (content.getContentTransportFormat() != null) {
                youboraOptions.setTransportFormat(content.getContentTransportFormat());
            }
            if (content.getContentTotalBytes() != null) {
                youboraOptions.setContentTotalBytes(content.getContentTotalBytes());
            }
            youboraOptions.setContentSendTotalBytes(content.getContentSendTotalBytes());
            if (content.getContentTvShow() != null) {
                youboraOptions.setContentTvShow(content.getContentTvShow());
            }
            if (content.getContentType() != null) {
                youboraOptions.setContentType(content.getContentType());
            }
            if (content.getContentMetaData() != null) {
                youboraOptions.setContentMetadata(getContentMetaDataBundle(content.getContentMetaData()));
            }
            if (content.getContentMetrics() != null) {
                youboraOptions.setContentMetrics(getBundleFromMap(content.getContentMetrics()));
            }
            if (content.getContentEncodingCodecSettings() != null) {
                youboraOptions.setContentEncodingCodecSettings(getBundleFromMap(content.getContentEncodingCodecSettings()));
            }
            if (content.getCustomDimensions() != null) {
                populateContentCustomDimensions(youboraOptions, content.getCustomDimensions());
            }
        }

        // Backward compatibility if app passes the custom dimension on top level instead of content
        if ((content == null || content.getCustomDimensions() == null) &&  getContentCustomDimensions() != null) {
            populateContentCustomDimensions(youboraOptions, getContentCustomDimensions());
        }

        setLegacyContentPropertiesBundle(youboraOptions);

        // Backward compatibility if app passes the metadata Properties on top level instead of content and Ads
        if ((content == null || content.getContentMetaData() == null) && getProperties() != null) {
            youboraOptions.setContentMetadata(getContentMetaDataBundle(getProperties()));
        }

        if (network != null) {
            if (network.getNetworkConnectionType() != null) {
                youboraOptions.setNetworkConnectionType(network.getNetworkConnectionType());
            }
            if (network.getNetworkIP() != null) {
                youboraOptions.setNetworkIP(network.getNetworkIP());
            }
            if (network.getNetworkIsp() != null) {
                youboraOptions.setNetworkIsp(network.getNetworkIsp());
            }
        }

        if (errors != null) {
            if (errors.getErrorsIgnore() != null) {
                youboraOptions.setErrorsToIgnore(errors.getErrorsIgnore());
            }
            if (errors.getErrorsFatal() != null) {
                youboraOptions.setFatalErrors(errors.getErrorsFatal());
            }
            if (errors.getErrorsNonFatal() != null) {
                youboraOptions.setNonFatalErrors(errors.getErrorsNonFatal());
            }
        }

        if (ads != null) {
            if (ads.getAdBreaksTime() != null) {
                youboraOptions.setAdBreaksTime(ads.getAdBreaksTime());
            }
            youboraOptions.setAdCampaign(ads.getAdCampaign());
            youboraOptions.setAdCreativeId(ads.getAdCreativeId());

            if (ads.getAdExpectedBreaks() != null) {
                youboraOptions.setAdExpectedBreaks(ads.getAdExpectedBreaks());
            }
            if (ads.getAdGivenAds() != null) {
                youboraOptions.setGivenAds(ads.getAdGivenAds());
            }
            if (ads.getAdGivenBreaks() != null) {
                youboraOptions.setAdGivenBreaks(ads.getAdGivenBreaks());
            }

            youboraOptions.setAdProvider(ads.getAdProvider());
            youboraOptions.setAdResource(ads.getAdResource());
            youboraOptions.setAdTitle(ads.getAdTitle());

            if (ads.getAdCustomDimensions() != null) {
                youboraOptions.setAdCustomDimension1(ads.getAdCustomDimensions().getAdCustomDimension1());
                youboraOptions.setAdCustomDimension2(ads.getAdCustomDimensions().getAdCustomDimension2());
                youboraOptions.setAdCustomDimension3(ads.getAdCustomDimensions().getAdCustomDimension3());
                youboraOptions.setAdCustomDimension4(ads.getAdCustomDimensions().getAdCustomDimension4());
                youboraOptions.setAdCustomDimension5(ads.getAdCustomDimensions().getAdCustomDimension5());
                youboraOptions.setAdCustomDimension6(ads.getAdCustomDimensions().getAdCustomDimension6());
                youboraOptions.setAdCustomDimension7(ads.getAdCustomDimensions().getAdCustomDimension7());
                youboraOptions.setAdCustomDimension8(ads.getAdCustomDimensions().getAdCustomDimension8());
                youboraOptions.setAdCustomDimension9(ads.getAdCustomDimensions().getAdCustomDimension9());
                youboraOptions.setAdCustomDimension10(ads.getAdCustomDimensions().getAdCustomDimension10());
            }

            youboraOptions.setAdMetadata(getAdMetaDataBundle(ads.getMetadata()));
            youboraOptions.setAdExpectedPattern(getAdExpectedPatternBundle(ads.getExpectedPattern()));
            youboraOptions.setAdBlockerDetected(ads.getBlockerDetected());
        }

        if (sessionMetrics != null) {
            youboraOptions.setSessionMetrics(getBundleFromMap(sessionMetrics));
        }

        return youboraOptions;
    }

    private void populateContentCustomDimensions(Options youboraOptions, ContentCustomDimensions customDimensions) {
        if (customDimensions != null) {
            youboraOptions.setContentCustomDimension1(customDimensions.getContentCustomDimension1());
            youboraOptions.setContentCustomDimension2(customDimensions.getContentCustomDimension2());
            youboraOptions.setContentCustomDimension3(customDimensions.getContentCustomDimension3());
            youboraOptions.setContentCustomDimension4(customDimensions.getContentCustomDimension4());
            youboraOptions.setContentCustomDimension5(customDimensions.getContentCustomDimension5());
            youboraOptions.setContentCustomDimension6(customDimensions.getContentCustomDimension6());
            youboraOptions.setContentCustomDimension7(customDimensions.getContentCustomDimension7());
            youboraOptions.setContentCustomDimension8(customDimensions.getContentCustomDimension8());
            youboraOptions.setContentCustomDimension9(customDimensions.getContentCustomDimension9());
            youboraOptions.setContentCustomDimension10(customDimensions.getContentCustomDimension10());
            youboraOptions.setContentCustomDimension11(customDimensions.getContentCustomDimension11());
            youboraOptions.setContentCustomDimension12(customDimensions.getContentCustomDimension12());
            youboraOptions.setContentCustomDimension13(customDimensions.getContentCustomDimension13());
            youboraOptions.setContentCustomDimension14(customDimensions.getContentCustomDimension14());
            youboraOptions.setContentCustomDimension15(customDimensions.getContentCustomDimension15());
            youboraOptions.setContentCustomDimension16(customDimensions.getContentCustomDimension16());
            youboraOptions.setContentCustomDimension17(customDimensions.getContentCustomDimension17());
            youboraOptions.setContentCustomDimension18(customDimensions.getContentCustomDimension18());
            youboraOptions.setContentCustomDimension19(customDimensions.getContentCustomDimension19());
            youboraOptions.setContentCustomDimension20(customDimensions.getContentCustomDimension20());
        }
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
     * Returns a bundle from a HashMap
     * @param map incoming HashMap
     * @return Bundle
     */
    @NonNull
    private Bundle getBundleFromMap(HashMap<String, String> map) {
        Bundle bundle = new Bundle();
        if (map == null || map.isEmpty()) {
            return bundle;
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }

        return bundle;
    }

    /**
     * Containing mixed extra information about the content like: director,
     * parental rating, device info or the audio channels.
     * @return bundle having properties
     */
    @NonNull
    private Bundle getContentMetaDataBundle(Properties prop) {
        Bundle propertiesBundle = new Bundle();
        if (prop == null) {
            return propertiesBundle;
        }

        if (prop.getDirector() != null) {
            propertiesBundle.putString("director", prop.getDirector());
        }
        if (prop.getParental() != null) {
            propertiesBundle.putString("parental", prop.getParental());
        }
        if (prop.getParental() != null) {
            propertiesBundle.putString("audioType", prop.getAudioType());
        }
        if (prop.getAudioChannels() != null) {
            propertiesBundle.putString("audioChannels", prop.getAudioChannels());
        }
        if (prop.getDevice() != null) {
            propertiesBundle.putString("device", prop.getDevice());
        }
        if (prop.getRating() != null) {
            propertiesBundle.putString("rating", prop.getRating());
        }
        if (prop.getYear() != null) {
            propertiesBundle.putString("year", prop.getYear());
        }
        if (prop.getCast() != null) {
            propertiesBundle.putString("cast", prop.getCast());
        }
        if (prop.getOwner() != null) {
            propertiesBundle.putString("owner", prop.getOwner());
        }

        return propertiesBundle;
    }

    /**
     * Containing mixed extra information about the Ads like: director,
     * parental rating, device info or the audio channels.
     * @return bundle having properties
     */
    @NonNull
    private Bundle getAdMetaDataBundle(Properties prop) {
        Bundle propertiesBundle = new Bundle();
        if (prop == null) {
            return propertiesBundle;
        }

        if (prop.getDirector() != null) {
            propertiesBundle.putString("director", prop.getDirector());
        }
        if (prop.getParental() != null) {
            propertiesBundle.putString("parental", prop.getParental());
        }
        if (prop.getParental() != null) {
            propertiesBundle.putString("audioType", prop.getAudioType());
        }
        if (prop.getAudioChannels() != null) {
            propertiesBundle.putString("audioChannels", prop.getAudioChannels());
        }
        if (prop.getDevice() != null) {
            propertiesBundle.putString("device", prop.getDevice());
        }
        if (prop.getRating() != null) {
            propertiesBundle.putString("rating", prop.getRating());
        }
        if (prop.getYear() != null) {
            propertiesBundle.putString("year", prop.getYear());
        }
        if (prop.getCast() != null) {
            propertiesBundle.putString("cast", prop.getCast());
        }
        if (prop.getOwner() != null) {
            propertiesBundle.putString("owner", prop.getOwner());
        }

        return propertiesBundle;
    }

    /**
     * Set to positive integer array indicating how many ads will be shown for each break,
     * value expected by the customer (the number of ads requested to the server for each break).
     *
     * @return Bundle of expected Ad pattern
     */
    @NonNull
    private Bundle getAdExpectedPatternBundle(AdExpectedPattern adExpectedPattern) {
        Bundle expectedPatternBundle = new Bundle();
        if (adExpectedPattern == null) {
            return expectedPatternBundle;
        }
        if (adExpectedPattern.getPre() != null) {
            expectedPatternBundle.putIntegerArrayList("pre", adExpectedPattern.getPre());
        }
        if (adExpectedPattern.getMid() != null) {
            expectedPatternBundle.putIntegerArrayList("mid", adExpectedPattern.getMid());
        }
        if (adExpectedPattern.getPost() != null) {
            expectedPatternBundle.putIntegerArrayList("post", adExpectedPattern.getPost());
        }

        return expectedPatternBundle;
    }

    public JsonObject toJson() {

        Map<String, JsonPrimitive> rootLevelParams = new HashMap<>();
        rootLevelParams.put("accountCode", new JsonPrimitive(getAccountCode() != null ? getAccountCode() : ""));
        rootLevelParams.put("host", (getHost() != null) ? new JsonPrimitive(getHost()) : null);
        rootLevelParams.put("authToken", (getAuthToken() != null) ? new JsonPrimitive(getAuthToken()) : null);
        rootLevelParams.put("authType", (getAuthType() != null) ? new JsonPrimitive(getAuthType()) : null);
        rootLevelParams.put("username", (getUsername() != null) ? new JsonPrimitive(getUsername()) : null);
        rootLevelParams.put("houseHoldId", (getHouseHoldId() != null) ? new JsonPrimitive(getHouseHoldId()) : null);

        rootLevelParams.put("userEmail", (getUserEmail() != null) ? new JsonPrimitive(getUserEmail()) : null);
        rootLevelParams.put("userAnonymousId", (getUserAnonymousId() != null) ? new JsonPrimitive(getUserAnonymousId()) : null);
        rootLevelParams.put("userType", (getUserType() != null) ? new JsonPrimitive(getUserType()) : null);
        rootLevelParams.put("isUserObfuscateIp", new JsonPrimitive(getUserObfuscateIp()));

        rootLevelParams.put("appName", (getAppName() != null) ? new JsonPrimitive(getAppName()) : null);
        rootLevelParams.put("appReleaseVersion", (getAppReleaseVersion() != null) ? new JsonPrimitive(getAppReleaseVersion()) : null);

        rootLevelParams.put("urlToParse", (getUrlToParse() != null) ? new JsonPrimitive(getUrlToParse()) : null);
        rootLevelParams.put("linkedViewId", (getLinkedViewId() != null) ? new JsonPrimitive(getLinkedViewId()) : null);
        rootLevelParams.put("httpSecure", new JsonPrimitive(getHttpSecure()));
        rootLevelParams.put("isAutoStart", new JsonPrimitive(getIsAutoStart()));
        rootLevelParams.put("isAutoDetectBackground", new JsonPrimitive(getIsAutoDetectBackground()));
        rootLevelParams.put("isEnabled", new JsonPrimitive(getIsEnabled()));
        rootLevelParams.put("isForceInit", new JsonPrimitive(getIsForceInit()));
        rootLevelParams.put("isOffline", new JsonPrimitive(getIsOffline()));
        rootLevelParams.put("waitForMetadata", new JsonPrimitive(isWaitForMetadata()));

        JsonObject user = YouboraConfigJsonBuilder.getUserJsonObject(getUser());
        JsonObject pendingMetadata = YouboraConfigJsonBuilder.getPendingMetaDataJsonObject(getPendingMetadata());
        JsonObject sessionMetrics = YouboraConfigJsonBuilder.getSessionMetricsJsonObject(getSessionMetrics());
        JsonObject app = YouboraConfigJsonBuilder.getAppJsonObject(getApp());
        JsonObject parse = YouboraConfigJsonBuilder.getParseJsonObject(getParse());
        JsonObject device = YouboraConfigJsonBuilder.getDeviceJsonObject(getDevice());
        JsonObject content = YouboraConfigJsonBuilder.getContentJsonObject(getContent());
        JsonObject network = YouboraConfigJsonBuilder.getNetworkJsonObject(getNetwork());
        JsonObject errors = YouboraConfigJsonBuilder.getErrorsJsonObject(getErrors());
        JsonObject adsEntry = YouboraConfigJsonBuilder.getAdsJsonObject(getAds());
        JsonObject properties = YouboraConfigJsonBuilder.getPropertiesJsonObject(getProperties());
        JsonObject contentCustomDimensions = YouboraConfigJsonBuilder.getContentCustomDimensionsJsonObject(getContentCustomDimensions());
        return YouboraConfigJsonBuilder.getYouboraConfigJsonObject(rootLevelParams,
                user,
                pendingMetadata,
                sessionMetrics,
                app,
                parse,
                device,
                content,
                network,
                errors,
                adsEntry,
                properties,
                contentCustomDimensions);
    }
    
    public void merge(YouboraConfig youboraConfigUiConf) {
        if (youboraConfigUiConf == null) {
            return;
        }

        if (TextUtils.isEmpty(accountCode)) {
            accountCode = youboraConfigUiConf.getAccountCode();
        }
        if (TextUtils.isEmpty(host)) {
            host = youboraConfigUiConf.getHost();
        }
        if (TextUtils.isEmpty(authToken)) {
            authToken = youboraConfigUiConf.getAuthToken();
        }
        if (TextUtils.isEmpty(authType)) {
            authType = youboraConfigUiConf.getAuthType();
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
                } else if (content.isDVR() == null && youboraConfigUiConf.getContent().isDVR() != null) {
                    content.setContentIsLiveNoSeek(!youboraConfigUiConf.getContent().isDVR());
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
                if (content.getContentTransportFormat() == null) {
                    content.setContentTransportFormat(youboraConfigUiConf.getContent().getContentTransportFormat());
                }
                if (content.getContentTotalBytes() == null) {
                    content.setContentTotalBytes(youboraConfigUiConf.getContent().getContentTotalBytes());
                }
                content.setContentSendTotalBytes(youboraConfigUiConf.getContent().getContentSendTotalBytes());
                if (content.getContentTvShow() == null) {
                    content.setContentTvShow(youboraConfigUiConf.getContent().getContentTvShow());
                }
                if (content.getContentType() == null) {
                    content.setContentType(youboraConfigUiConf.getContent().getContentType());
                }
                if (content.getContentMetaData() == null) {
                    content.setContentMetaData(youboraConfigUiConf.getContent().getContentMetaData());
                }
                if (content.getContentMetrics() == null) {
                    content.setContentMetrics(youboraConfigUiConf.getContent().getContentMetrics());
                }
                if (content.getContentEncodingCodecSettings() == null) {
                    content.setContentEncodingCodecSettings(youboraConfigUiConf.getContent().getContentEncodingCodecSettings());
                }
                if (content.getCustomDimensions() == null) {
                    content.setCustomDimensions(youboraConfigUiConf.getContent().getCustomDimensions());
                }
            }
        } else {
            content = youboraConfigUiConf.getContent();
        }

        if (app != null) {
            if (youboraConfigUiConf.getApp() != null) {
                if (app.getAppName() == null) {
                    app.setAppName(youboraConfigUiConf.getApp().getAppName());
                }
                if (app.getAppReleaseVersion() == null) {
                    app.setAppReleaseVersion(youboraConfigUiConf.getAppReleaseVersion());
                }
            }
        } else {
            app = youboraConfigUiConf.getApp();
        }

        if (parse != null) {
            if (youboraConfigUiConf.getParse() != null) {
                if (parse.getParseManifest() == null) {
                    parse.setParseManifest(youboraConfigUiConf.getParse().getParseManifest());
                }
                if (parse.getParseCdnNode() == null) {
                    parse.setParseCdnNode(youboraConfigUiConf.getParse().getParseCdnNode());
                }
                if (parse.getParseCdnNodeList() == null) {
                    parse.setParseCdnNodeList(youboraConfigUiConf.getParse().getParseCdnNodeList());
                }
                if (parse.getParseCdnTTL() == null) {
                    parse.setParseCdnTTL(youboraConfigUiConf.getParse().getParseCdnTTL());
                }
                if (parse.getParseCdnNameHeader() == null) {
                    parse.setParseCdnNameHeader(youboraConfigUiConf.getParse().getParseCdnNameHeader());
                }
                if (parse.getParseNodeHeader() == null) {
                    parse.setParseNodeHeader(youboraConfigUiConf.getParse().getParseNodeHeader());
                }
                if (parse.getParseCdnSwitchHeader() == null) {
                    parse.setParseCdnSwitchHeader(youboraConfigUiConf.getParse().getParseCdnSwitchHeader());
                }
            }
        } else {
            parse = youboraConfigUiConf.getParse();
        }

        if (network != null) {
            if (youboraConfigUiConf.getNetwork() != null) {
                if (network.getNetworkConnectionType() == null) {
                    network.setNetworkConnectionType(youboraConfigUiConf.getNetwork().getNetworkConnectionType());
                }
                if (network.getNetworkIP() == null) {
                    network.setNetworkIP(youboraConfigUiConf.getNetwork().getNetworkIP());
                }
                if (network.getNetworkIsp() == null) {
                    network.setNetworkIsp(youboraConfigUiConf.getNetwork().getNetworkIsp());
                }
            }
        } else {
            network = youboraConfigUiConf.getNetwork();
        }

        if (errors != null) {
            if (youboraConfigUiConf.getErrors() != null) {
                if (errors.getErrorsIgnore() == null) {
                    errors.setErrorsIgnore(youboraConfigUiConf.getErrors().getErrorsIgnore());
                }
                if (errors.getErrorsFatal() == null) {
                    errors.setErrorsFatal(youboraConfigUiConf.getErrors().getErrorsFatal());
                }
                if (errors.getErrorsNonFatal() == null) {
                    errors.setErrorsNonFatal(youboraConfigUiConf.getErrors().getErrorsNonFatal());
                }
            }
        } else {
            errors = youboraConfigUiConf.getErrors();
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
                if (ads.getAdGivenAds() == null) {
                    ads.setAdGivenAds(youboraConfigUiConf.getAds().getAdGivenAds());
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
                if (ads.getBlockerDetected() != null) {
                    ads.setBlockerDetected(youboraConfigUiConf.getAds().getBlockerDetected());
                }
                if (ads.getMetadata() != null) {
                    ads.setMetadata(youboraConfigUiConf.getAds().getMetadata());
                }
                if (ads.getExpectedPattern() != null) {
                    ads.setExpectedPattern(youboraConfigUiConf.getAds().getExpectedPattern());
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

        if (contentCustomDimensions != null) {
            if (youboraConfigUiConf.getContentCustomDimensions() != null) {
                ContentCustomDimensions contentCustomDimensionsUiConf = youboraConfigUiConf.getContentCustomDimensions();
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension1()))) {
                    contentCustomDimensions.setContentCustomDimension1(contentCustomDimensionsUiConf.getContentCustomDimension1());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension2()))) {
                    contentCustomDimensions.setContentCustomDimension2(contentCustomDimensionsUiConf.getContentCustomDimension2());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension3()))) {
                    contentCustomDimensions.setContentCustomDimension3(contentCustomDimensionsUiConf.getContentCustomDimension3());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension4()))) {
                    contentCustomDimensions.setContentCustomDimension4(contentCustomDimensionsUiConf.getContentCustomDimension4());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension5()))) {
                    contentCustomDimensions.setContentCustomDimension5(contentCustomDimensionsUiConf.getContentCustomDimension5());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension6()))) {
                    contentCustomDimensions.setContentCustomDimension6(contentCustomDimensionsUiConf.getContentCustomDimension6());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension7()))) {
                    contentCustomDimensions.setContentCustomDimension7(contentCustomDimensionsUiConf.getContentCustomDimension7());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension8()))) {
                    contentCustomDimensions.setContentCustomDimension8(contentCustomDimensionsUiConf.getContentCustomDimension8());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension9()))) {
                    contentCustomDimensions.setContentCustomDimension9(contentCustomDimensionsUiConf.getContentCustomDimension9());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension10()))) {
                    contentCustomDimensions.setContentCustomDimension10(contentCustomDimensionsUiConf.getContentCustomDimension10());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension11()))) {
                    contentCustomDimensions.setContentCustomDimension11(contentCustomDimensionsUiConf.getContentCustomDimension11());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension12()))) {
                    contentCustomDimensions.setContentCustomDimension12(contentCustomDimensionsUiConf.getContentCustomDimension12());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension13()))) {
                    contentCustomDimensions.setContentCustomDimension13(contentCustomDimensionsUiConf.getContentCustomDimension13());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension14()))) {
                    contentCustomDimensions.setContentCustomDimension14(contentCustomDimensionsUiConf.getContentCustomDimension14());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension15()))) {
                    contentCustomDimensions.setContentCustomDimension15(contentCustomDimensionsUiConf.getContentCustomDimension15());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension16()))) {
                    contentCustomDimensions.setContentCustomDimension16(contentCustomDimensionsUiConf.getContentCustomDimension16());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension17()))) {
                    contentCustomDimensions.setContentCustomDimension17(contentCustomDimensionsUiConf.getContentCustomDimension17());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension18()))) {
                    contentCustomDimensions.setContentCustomDimension18(contentCustomDimensionsUiConf.getContentCustomDimension18());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension19()))) {
                    contentCustomDimensions.setContentCustomDimension19(contentCustomDimensionsUiConf.getContentCustomDimension19());
                }
                if (TextUtils.isEmpty((contentCustomDimensions.getContentCustomDimension20()))) {
                    contentCustomDimensions.setContentCustomDimension20(contentCustomDimensionsUiConf.getContentCustomDimension20());
                }
            }
        } else {
            contentCustomDimensions = youboraConfigUiConf.getContentCustomDimensions();
        }
    }
}
