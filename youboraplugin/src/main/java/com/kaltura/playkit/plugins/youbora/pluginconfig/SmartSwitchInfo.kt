package com.kaltura.playkit.plugins.youbora.pluginconfig

import androidx.annotation.Nullable

data class SmartSwitchInfo(var originCode: String?, @Nullable var optionalParams: HashMap<String, String>?)

class SmartSwitchParser {
    var smartSwitch: SmartSwitch? = null
}

class SmartSwitch {
    var switchingMethod: String? = null
    var CDNList: ArrayList<Map<String?, CDNList?>>? = null
    var UUID: String? = null
}

class CDNList {
    var CDN_NAME: String? = null
    var CDN_CODE: String? = null
    var URL: String? = null
    var CDN_SCORE: Float? = null
}

class SmartSwitchErrorResponse {
    var messages: ArrayList<ErrorResponseBody>? = null
    // var data: Array? = null //TODO
}

class ErrorResponseBody {
    var type: String? = null
    var code: String? = null
    var message: String? = null
    // var parameters: Array? = null //TODO
}
