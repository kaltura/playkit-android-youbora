package com.kaltura.playkit.plugins.youbora.pluginconfig

import com.google.gson.annotations.SerializedName

data class Content (
    @SerializedName(value = "contentBitrate", alternate = ["bitrate"])
    var contentBitrate: Long?,

    /**
     * See a list of codes in [
     * http://mapi.youbora.com:8081/cdns](http://mapi.youbora.com:8081/cdns).
     */
    @SerializedName(value = "contentCdn", alternate = ["cdn"])
    var contentCdn: String?,

    @SerializedName(value = "contentCdnNode", alternate = ["cdnNode"])
    var contentCdnNode: String?,

    @SerializedName(value = "contentCdnType", alternate = ["cdnType"])
    var contentCdnType: String?,

    @SerializedName(value = "contentChannel", alternate = ["channel"])
    var contentChannel: String?,

    @SerializedName(value = "contentContractedResolution", alternate = ["contractedResolution"])
    var contentContractedResolution: String?,

    @SerializedName(value = "contentCost", alternate = ["cost"])
    var contentCost: String?,

    @SerializedName(value = "contentDrm", alternate = ["drm"])
    var contentDrm: String?,

    @SerializedName(value = "contentDuration", alternate = ["duration"])
    var contentDuration: Double?,
    var contentEncodingAudioCodec: String?,
    var contentEncodingCodecProfile: String?,

    @SerializedName(value = "contentEncodingCodecSettings", alternate = ["encoding"])
    var contentEncodingCodecSettings: HashMap<String, String>?,

    var contentEncodingContainerFormat: String?,
    var contentEncodingVideoCodec: String?,

    @SerializedName(value = "contentEpisodeTitle", alternate = ["title2", "episodeTitle"])
    var contentEpisodeTitle: String?,

    @SerializedName(value = "contentFps", alternate = ["fps"])
    var contentFps: Double?,

    @SerializedName(value = "contentGenre", alternate = ["genre"])
    var contentGenre: String?,

    @SerializedName(value = "contentGracenoteId", alternate = ["gracenoteId"])
    var contentGracenoteId: String?,

    @SerializedName(value = "contentId", alternate = ["id"])
    var contentId: String?,

    @SerializedName(value = "contentImdbId", alternate = ["imdbId"])
    var contentImdbId: String?,

    @SerializedName(value = "contentIsLive", alternate = ["isLive"])
    var contentIsLive: Boolean?,
    var contentIsLiveNoSeek: Boolean?,
    var isDVR: Boolean? = false, //LEGACY  - the opposite value from contentIsLiveNoSeek

    @SerializedName(value = "contentLanguage", alternate = ["language"])
    var contentLanguage: String?,

    @SerializedName(value = "contentMetaData", alternate = ["metadata"])
    var contentMetaData: Properties?,

    @SerializedName(value = "contentMetrics", alternate = ["metrics"])
    var contentMetrics: HashMap<String, String>?,

    @SerializedName(value = "contentPackage", alternate = ["package"])
    var contentPackage: String?,

    @SerializedName(value = "contentPlaybackType", alternate = ["playbackType"])
    var contentPlaybackType: String?,

    @SerializedName(value = "contentPrice", alternate = ["price"])
    var contentPrice: String?,

    @SerializedName(value = "contentProgram", alternate = ["program"])
    var contentProgram: String?,

    @SerializedName(value = "contentRendition", alternate = ["rendition"])
    var contentRendition: String?,

    @SerializedName(value = "contentResource", alternate = ["resource"])
    var contentResource: String?,

    @SerializedName(value = "contentSaga", alternate = ["saga"])
    var contentSaga: String?,

    @SerializedName(value = "contentSeason", alternate = ["season"])
    var contentSeason: String?,

    @SerializedName(value = "contentStreamingProtocol", alternate = ["streamingProtocol"])
    var contentStreamingProtocol: String?,

    @SerializedName(value = "contentSubtitles", alternate = ["subtitles"])
    var contentSubtitles: String?,

    @SerializedName(value = "contentThroughput", alternate = ["throughput"])
    var contentThroughput: Long?,

    @SerializedName(value = "contentTitle", alternate = ["title"])
    var contentTitle: String?,

    @SerializedName(value = "contentTransactionCode", alternate = ["transactionType", "transactionCode"])
    var contentTransactionCode: String?,

    @SerializedName(value = "contentTotalBytes", alternate = ["totalBytes"])
    var contentTotalBytes: Long?,

    @SerializedName(value = "contentTransportFormat", alternate = ["transportFormat"])
    var contentTransportFormat: String?,

    @SerializedName(value = "contentSendTotalBytes", alternate = ["sendTotalBytes"])
    var contentSendTotalBytes: Boolean = false,

    @SerializedName(value = "contentTvShow", alternate = ["tvShow"])
    var contentTvShow: String?,

    @SerializedName(value = "contentType", alternate = ["type"])
    var contentType: String?,

    @SerializedName(value = "customDimensions", alternate = ["customDimension"])
    var customDimensions: ContentCustomDimensions?

)
