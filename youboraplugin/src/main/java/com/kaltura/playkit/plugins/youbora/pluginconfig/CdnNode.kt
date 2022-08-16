package com.kaltura.playkit.plugins.youbora.pluginconfig

import com.google.gson.annotations.SerializedName

class CdnNode(
    @SerializedName(value = "parseCdnNode", alternate = ["requestDebugHeaders"])
    var parseCdnNode: Boolean? = null,

    @SerializedName(value = "parseCdnNodeList", alternate = ["list"])
    var parseCdnNodeList: ArrayList<String>? = null)