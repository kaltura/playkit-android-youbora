package com.kaltura.playkit.plugins.youbora.pluginconfig

import com.google.gson.annotations.SerializedName

data class Ads(var adBreaksTime: ArrayList<Int>?,
               @SerializedName(value = "adCampaign", alternate = ["campaign"])
               var adCampaign: String?,
               var adCreativeId: String?,
               var adExpectedBreaks: Int?,
//               var adExpectedPattern: Bundle,
               var adGivenAds: Int?,
               var adGivenBreaks: Int?,
//               var adMetadata: Bundle,
               var adProvider: String?,
               var adResource: String?,
               var adTitle: String?,
               @SerializedName(value = "adCustomDimensions", alternate = ["extraParams"])
               var adCustomDimensions: AdCustomDimensions?)

data class Ad(var blockerDetected: Boolean?,
              var metadata: Properties?,
              var campaign: String?,
              var title: String?,
              var resource: String?,
              var givenBreaks: Int?,
              var expectedBreaks: Int?,
              var expectedPattern: AdExpectedPattern?,
              var breaksTime: ArrayList<Int>?,
              var givenAds: Int?,
              var creativeId: String?,
              var provider: String?,
              var customDimension: AdCustomDimensions?)