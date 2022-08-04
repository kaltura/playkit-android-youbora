package com.kaltura.playkit.plugins.youbora.pluginconfig

data class User (
    var anonymousId: String? = null,
    var type: String? = null,
    var email: String? = null,
    var privacyProtocol: String? = null,
    var obfuscateIp: Boolean? = false
)
