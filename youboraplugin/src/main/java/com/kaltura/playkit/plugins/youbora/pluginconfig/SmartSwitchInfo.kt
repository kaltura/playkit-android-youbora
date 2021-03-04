package com.kaltura.playkit.plugins.youbora.pluginconfig

import androidx.annotation.Nullable

data class SmartSwitchInfo(var originCode: String?, @Nullable var optionalParams: HashMap<String, String>?)

internal class SmartSwitchParser {
    var smartSwitch: String? = null
    var switchingMethod: String? = null
    var CDNList: List<CDNList>? = null
    var UUID: String? = null
}

internal class CDNList {
    var CDN_NAME: String? = null
    var CDN_CODE: String? = null
    var URL: String? = null
    var CDN_SCORE: String? = null
}
