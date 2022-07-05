package com.kaltura.playkit.plugins.youbora.pluginconfig

import com.google.gson.annotations.SerializedName

data class Content (
    @SerializedName(value = "contentBitrate", alternate = ["bitrate"])
    var contentBitrate: Long? = null,

    /**
     * See a list of codes in [
     * http://mapi.youbora.com:8081/cdns](http://mapi.youbora.com:8081/cdns).
     */
    @SerializedName(value = "contentCdn", alternate = ["cdn"])
    var contentCdn: String? = null,

    @SerializedName(value = "contentCdnNode", alternate = ["cdnNode"])
    var contentCdnNode: String? = null,

    @SerializedName(value = "contentCdnType", alternate = ["cdnType"])
    var contentCdnType: String? = null,

    @SerializedName(value = "contentChannel", alternate = ["channel"])
    var contentChannel: String? = null,

    @SerializedName(value = "contentContractedResolution", alternate = ["contractedResolution"])
    var contentContractedResolution: String? = null,

    @SerializedName(value = "contentCost", alternate = ["cost"])
    var contentCost: String? = null,

    @SerializedName(value = "contentDrm", alternate = ["drm"])
    var contentDrm: String? = null,

    @SerializedName(value = "contentDuration", alternate = ["duration"])
    var contentDuration: Double? = null,
    var contentEncodingAudioCodec: String? = null,
    var contentEncodingCodecProfile: String? = null,

    @SerializedName(value = "contentEncodingCodecSettings", alternate = ["encoding"])
    var contentEncodingCodecSettings: HashMap<String, String>? = null,

    var contentEncodingContainerFormat: String? = null,
    var contentEncodingVideoCodec: String? = null,

    @SerializedName(value = "contentEpisodeTitle", alternate = ["title2", "episodeTitle"])
    var contentEpisodeTitle: String? = null,

    @SerializedName(value = "contentFps", alternate = ["fps"])
    var contentFps: Double? = null,

    @SerializedName(value = "contentGenre", alternate = ["genre"])
    var contentGenre: String? = null,

    @SerializedName(value = "contentGracenoteId", alternate = ["gracenoteId"])
    var contentGracenoteId: String? = null,

    @SerializedName(value = "contentId", alternate = ["id"])
    var contentId: String? = null,

    @SerializedName(value = "contentImdbId", alternate = ["imdbId"])
    var contentImdbId: String? = null,

    @SerializedName(value = "contentIsLive", alternate = ["isLive"])
    var contentIsLive: Boolean? = null,
    var contentIsLiveNoSeek: Boolean? = null,
    var isDVR: Boolean? = false, //LEGACY  - the opposite value from contentIsLiveNoSeek

    @SerializedName(value = "contentLanguage", alternate = ["language"])
    var contentLanguage: String? = null,

    @SerializedName(value = "contentMetaData", alternate = ["metadata"])
    var contentMetaData: Properties? = null,

    @SerializedName(value = "contentMetrics", alternate = ["metrics"])
    var contentMetrics: HashMap<String, String>? = null,

    @SerializedName(value = "contentPackage", alternate = ["package"])
    var contentPackage: String? = null,

    @SerializedName(value = "contentPlaybackType", alternate = ["playbackType"])
    var contentPlaybackType: String? = null,

    @SerializedName(value = "contentPrice", alternate = ["price"])
    var contentPrice: String? = null,

    @SerializedName(value = "contentProgram", alternate = ["program"])
    var contentProgram: String? = null,

    @SerializedName(value = "contentRendition", alternate = ["rendition"])
    var contentRendition: String? = null,

    @SerializedName(value = "contentResource", alternate = ["resource"])
    var contentResource: String? = null,

    @SerializedName(value = "contentSaga", alternate = ["saga"])
    var contentSaga: String? = null,

    @SerializedName(value = "contentSeason", alternate = ["season"])
    var contentSeason: String? = null,

    @SerializedName(value = "contentStreamingProtocol", alternate = ["streamingProtocol"])
    var contentStreamingProtocol: String? = null,

    @SerializedName(value = "contentSubtitles", alternate = ["subtitles"])
    var contentSubtitles: String? = null,

    @SerializedName(value = "contentThroughput", alternate = ["throughput"])
    var contentThroughput: Long? = null,

    @SerializedName(value = "contentTitle", alternate = ["title"])
    var contentTitle: String? = null,

    @SerializedName(value = "contentTransactionCode", alternate = ["transactionType", "transactionCode"])
    var contentTransactionCode: String? = null,

    @SerializedName(value = "contentTotalBytes", alternate = ["totalBytes"])
    var contentTotalBytes: Long? = null,

    @SerializedName(value = "contentTransportFormat", alternate = ["transportFormat"])
    var contentTransportFormat: String? = null,

    @SerializedName(value = "contentSendTotalBytes", alternate = ["sendTotalBytes"])
    var contentSendTotalBytes: Boolean = false,

    @SerializedName(value = "contentTvShow", alternate = ["tvShow"])
    var contentTvShow: String? = null,

    @SerializedName(value = "contentType", alternate = ["type"])
    var contentType: String? = null,

    @SerializedName(value = "customDimensions", alternate = ["customDimension"])
    var customDimensions: ContentCustomDimensions? = null

)
