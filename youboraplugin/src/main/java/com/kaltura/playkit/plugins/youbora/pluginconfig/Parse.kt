package com.kaltura.playkit.plugins.youbora.pluginconfig

import com.google.gson.annotations.SerializedName

data class Parse(
    @SerializedName(value = "parseManifest", alternate = ["manifest"])
    var parseManifest: Boolean? = false,
    var parseCdnNode: Boolean? = false, // This is different in iOS

    @SerializedName(value = "parseCdnSwitchHeader", alternate = ["cdnSwitchHeader"])
    var parseCdnSwitchHeader: Boolean? = false,
    var parseCdnNodeList: ArrayList<String>? = null,

    @SerializedName(value = "parseCdnNameHeader", alternate = ["cdnNameHeader"])
    var parseCdnNameHeader: String? = null,
    var parseNodeHeader: String? = null,

    @SerializedName(value = "parseCdnTTL", alternate = ["cdnTTL"])
    var parseCdnTTL: Int? = null)
