package com.kaltura.playkit.plugins.youbora.pluginconfig

import com.google.gson.annotations.SerializedName

data class Encoding(
    var audioCodec: String? = null,
    var codecProfile: String? = null,

    @SerializedName(value = "contentEncodingCodecSettings", alternate = ["codecSettings"])
    var codecSettings: HashMap<String, String>? = null,

    var containerFormat: String? = null,
    var videoCodec: String? = null,
)
