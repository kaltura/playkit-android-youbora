package com.kaltura.playkit.plugins.youbora.pluginconfig

import com.google.gson.annotations.SerializedName

data class Ads(
    @SerializedName(value = "adBreaksTime", alternate = ["breaksTime"])
    var adBreaksTime: ArrayList<Int>?,
    @SerializedName(value = "adCampaign", alternate = ["campaign"])
    var adCampaign: String?,
    @SerializedName(value = "adCreativeId", alternate = ["creativeId"])
    var adCreativeId: String?,
    @SerializedName(value = "adExpectedBreaks", alternate = ["expectedBreaks"])
    var adExpectedBreaks: Int?,
    @SerializedName(value = "adGivenAds", alternate = ["givenAds"])
    var adGivenAds: Int?,
    @SerializedName(value = "adGivenBreaks", alternate = ["givenBreaks"])
    var adGivenBreaks: Int?,
    @SerializedName(value = "adProvider", alternate = ["provider"])
    var adProvider: String?,
    @SerializedName(value = "adResource", alternate = ["resource"])
    var adResource: String?,
    @SerializedName(value = "adTitle", alternate = ["title"])
    var adTitle: String?,
    @SerializedName(value = "adCustomDimensions", alternate = ["customDimension", "extraParams"])
    var adCustomDimensions: AdCustomDimensions?,
    var metadata: Properties?,
    var expectedPattern: AdExpectedPattern?,
    var blockerDetected: Boolean?)
