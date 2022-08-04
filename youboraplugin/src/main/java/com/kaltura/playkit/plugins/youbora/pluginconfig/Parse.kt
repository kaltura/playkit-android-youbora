package com.kaltura.playkit.plugins.youbora.pluginconfig

import android.os.Bundle
import com.google.gson.annotations.SerializedName

data class Parse(
    /**
     * If true all "content" parsers will be used, HLS or DASH and location.
     * the plugin will parse the resource trying to find out the real given resource
     * instead of the API url.
     * If parsing HLS the plugin will parse files to use the first .ts file found as resource.
     * If parsing DASH parseManifestAuth the plugin will parse files as a resource.
     * Default: false.
     */
    @SerializedName(value = "parseManifest", alternate = ["manifest"])
    var parseManifest: Boolean? = false,

    /**
     * If [parseManifest] enabled, it adds extra headers [Bundle] to the request of the content.
     * Use this if for example, the player needs to include authentication headers to request the content,
     * so the plugin needs it to access to the manifest files too.
     */
    @SerializedName(value = "parseManifestAuth", alternate = ["auth"])
    var parseManifestAuth: HashMap<String, String>? = null,
    var parseCdnNode: Boolean? = false, // This is different in iOS

    @SerializedName(value = "parseCdnSwitchHeader", alternate = ["cdnSwitchHeader"])
    var parseCdnSwitchHeader: Boolean? = false,
    var parseCdnNodeList: ArrayList<String>? = null,

    @SerializedName(value = "parseCdnNameHeader", alternate = ["cdnNameHeader"])
    var parseCdnNameHeader: String? = null,
    var parseNodeHeader: String? = null,

    @SerializedName(value = "parseCdnTTL", alternate = ["cdnTTL"])
    var parseCdnTTL: Int? = null)

