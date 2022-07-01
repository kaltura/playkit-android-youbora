package com.kaltura.playkit.plugins.youbora.pluginconfig

import com.google.gson.annotations.SerializedName

data class Parse(
    @SerializedName(value = "parseManifest", alternate = ["manifest"])
    var parseManifest: Boolean?,
    var parseCdnNode: Boolean?, // This is different in iOS
    @SerializedName(value = "parseCdnSwitchHeader", alternate = ["cdnSwitchHeader"])
    var parseCdnSwitchHeader: Boolean?,
    var parseCdnNodeList: ArrayList<String>?,
    @SerializedName(value = "parseCdnNameHeader", alternate = ["cdnNameHeader"])
    var parseCdnNameHeader: String?,
    var parseNodeHeader: String?,
    @SerializedName(value = "parseCdnTTL", alternate = ["cdnTTL"])
    var parseCdnTTL: Int?)
