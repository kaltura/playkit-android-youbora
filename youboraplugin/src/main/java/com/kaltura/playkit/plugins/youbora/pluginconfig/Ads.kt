package com.kaltura.playkit.plugins.youbora.pluginconfig

import com.google.gson.annotations.SerializedName

data class Ads(
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
    @SerializedName(value = "adCustomDimensions", alternate = ["customDimension", "extraParams"])
    var adCustomDimensions: AdCustomDimensions? = null,
    var metadata: Properties? = null,
    var expectedPattern: AdExpectedPattern? = null,
    var blockerDetected: Boolean? = null)
