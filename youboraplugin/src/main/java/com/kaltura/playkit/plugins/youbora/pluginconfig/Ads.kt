package com.kaltura.playkit.plugins.youbora.pluginconfig

import com.google.gson.annotations.SerializedName

data class Ads(
    /**
     * Set to positive integer array indicating the position (playhead in seconds) of the ad breaks,
     * provided by the ad server.
     */
    @SerializedName(value = "adBreaksTime", alternate = ["breaksTime"])
    var adBreaksTime: ArrayList<Int>? = null,

    @SerializedName(value = "adCampaign", alternate = ["campaign"])
    var adCampaign: String? = null,

    @SerializedName(value = "adCreativeId", alternate = ["creativeId"])
    var adCreativeId: String? = null,

    @SerializedName(value = "adExpectedBreaks", alternate = ["expectedBreaks"])
    var adExpectedBreaks: Int? = null,

    @SerializedName(value = "adGivenAds", alternate = ["givenAds"])
    var adGivenAds: Int? = null,

    @SerializedName(value = "adGivenBreaks", alternate = ["givenBreaks"])
    var adGivenBreaks: Int? = null,

    @SerializedName(value = "adProvider", alternate = ["provider"])
    var adProvider: String? = null,

    @SerializedName(value = "adResource", alternate = ["resource"])
    var adResource: String? = null,

    @SerializedName(value = "adTitle", alternate = ["title"])
    var adTitle: String? = null,

    @SerializedName(value = "adCustomDimensions", alternate = ["adCustomDimension", "extraParams"])
    var adCustomDimensions: AdCustomDimensions? = null,

    var metadata: Properties? = null,
    var expectedPattern: AdExpectedPattern? = null,
    var blockerDetected: Boolean? = null,

    /**
     * Set to integer positive value indicating how many ads
     * will be shown as post-rolls if they do it after content player triggers stop event.
     */
    @kotlin.Deprecated("This option will be removed in future releases")
    var afterStop: Int? = null)
