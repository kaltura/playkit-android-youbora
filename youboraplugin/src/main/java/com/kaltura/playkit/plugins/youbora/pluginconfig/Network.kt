package com.kaltura.playkit.plugins.youbora.pluginconfig

import com.google.gson.annotations.SerializedName

data class Network(/**
                    * See a list of codes in <a href="http://mapi.youbora.com:8081/connectionTypes">
                    * http://mapi.youbora.com:8081/connectionTypes</a>.
                    */
                   @SerializedName(value = "networkConnectionType", alternate = ["connectionType"])
                   var networkConnectionType: String? = null,
                   /**
                    * IP of the viewer/user, e.g. "48.15.16.23".
                    */
                   @SerializedName(value = "networkIP", alternate = ["ip"])
                   var networkIP: String? = null,
                   /**
                    * Name of the internet service provider of the viewer/user.
                    */
                   @SerializedName(value = "networkIsp", alternate = ["isp"])
                   var networkIsp: String? = null
)
