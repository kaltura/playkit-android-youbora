package com.kaltura.playkit.plugins.youbora.pluginconfig

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName

data class Parse(

    @SerializedName(value = "parseManifest", alternate = ["manifest"])
    @JsonAdapter(ParseManifestDeserializer::class)
    var parseManifest: Manifest? = null,

    @SerializedName(value = "parseCdnSwitchHeader", alternate = ["cdnSwitchHeader"])
    var parseCdnSwitchHeader: Boolean? = null,

    @SerializedName(value = "parseCdnNode", alternate = ["cdnNode"])
    @JsonAdapter(CdnNodeDeserializer::class)
    var parseCdnNode: CdnNode? = null, // This is different in iOS

    @kotlin.Deprecated("Use {@link CdnNode} instead")
    @SerializedName(value = "parseCdnNodeList", alternate = ["list"])
    var parseCdnNodeList: ArrayList<String>? = null,

    @SerializedName(value = "parseCdnNameHeader", alternate = ["cdnNameHeader"])
    var parseCdnNameHeader: String? = null,

    @SerializedName(value = "parseNodeHeader", alternate = ["cdnNodeHeader"])
    var parseNodeHeader: String? = null,

    @SerializedName(value = "parseCdnTTL", alternate = ["cdnTTL"])
    var parseCdnTTL: Int? = null)

