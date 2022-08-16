package com.kaltura.playkit.plugins.youbora.pluginconfig

import com.google.gson.annotations.SerializedName

data class Session(
    @SerializedName(value = "sessionMetrics", alternate = ["metrics"])
    var sessionMetrics: HashMap<String?, String?>? = null)
