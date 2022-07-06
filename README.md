[![CI Status](https://api.travis-ci.org/kaltura/playkit-android-youbora.svg?branch=develop)](https://travis-ci.org/github/kaltura/playkit-android-youbora)
[![Download](https://img.shields.io/maven-central/v/com.kaltura.playkit/youboraplugin?label=Download)](https://search.maven.org/artifact/com.kaltura.playkit/youboraplugin)
[![License](https://img.shields.io/badge/license-AGPLv3-black.svg)](https://github.com/kaltura/playkit-android-kava/blob/master/LICENSE)
![Android](https://img.shields.io/badge/platform-android-green.svg)


# playkit-android-youbora

Youbora provides a business intelligence solution for broadcasters, OTTs, telcos and media to support your business decisions and drive performance. The ability to harness data across various integrated capabilities and services has become increasingly important to support multiple organizations across a video business, including marketing, and to drive consumer engagement and loyalty.

The Youbora player plugin is integrated with the Kaltura player. The plugin listens and reports all the different player states in the current video session to Youbora Analytics. By taking all the data from inside the player, Youbora Analytics is capable of measuring the quality of the video experience from its source, the end user, and in turn analyzing the delivery process end to end. 


* Once you have a player instance you may want to be able to track playback behaviour and playback trends.
* Using Youbora plugin you can achieve this easily.



#### Setup

Add Youbora maven to your project build.gradle in repositories section

`maven { url  "https://npaw.jfrog.io/artifactory/youbora/" }`


Add the Youbora plugin dependency to your `build.gradle` file:
In android, we keep all plugins aligned with same verison.
	
`implementation 'com.kaltura.playkit:youboraplugin:4.x.x'`

##### You can find the latest version here: 

[Releases](https://github.com/kaltura/playkit-android-youbora/releases)

##### You can find the Youbora lib version which we currently use here

[Youbora lib version](https://github.com/kaltura/playkit-android-youbora/blob/f1dbb0e9f8c9359c164bd32aea909927d099d087/youboraplugin/build.gradle#L33)


#### Create Plugin Config:

``` 
val playerInitOptions = PlayerInitOptions(PARTNER_ID)
playerInitOptions.setAutoPlay(true)
...
...

val pkPluginConfigs = PKPluginConfigs()
pkPluginConfigs.setPluginConfig(YouboraPlugin.factory.name, getYouboraBundle())

playerInitOptions.setPluginConfigs(pkPluginConfigs)

player = KalturaOttPlayer.create(this@MainActivity, playerInitOptions)

```

#### Build your Youbora config using Bundle 
##### Example for some of the properties the App can send to Youbora plugin. The only must property to send is _your account code_. 
In case if properties are not sent and if plugin have it internally plugin will set it automatically i.e media title, media resource and more.

[Youbora Bundle Keys referance](https://bitbucket.org/npaw/lib-plugin-android/src/047a982e74b452ce2e5aeda426830f3a83da5e29/youboralib/src/main/java/com/npaw/youbora/lib6/plugin/Options.kt#lines-628)

```
    /**
     * Bundle Youbora Configuration
     * @return Youbora ConfigBundle
     */
    private fun getYouboraBundle(): Bundle {

        val optBundle = Bundle()

        //Youbora config bundle. Main config goes here.
        optBundle.putString(KEY_ACCOUNT_CODE, ACCOUNT_CODE)
        optBundle.putString(KEY_USERNAME, UNIQUE_USER_NAME)
        optBundle.putString(KEY_USER_EMAIL, USER_EMAIL)

        optBundle.putBoolean(KEY_ENABLED, true)
        optBundle.putString(KEY_APP_NAME, "TestApp");
        optBundle.putString(KEY_APP_RELEASE_VERSION, "v1.0");

        //Media entry bundle.
        optBundle.putString(KEY_CONTENT_TITLE, MEDIA_TITLE)

        optBundle.putBoolean(KEY_PARSE_MANIFEST, PARSE_MANIFEST)
        optBundle.putBoolean(KEY_PARSE_CDN_NODE, PARSE_CDN_NODE)
        optBundle.putBoolean(KEY_PARSE_CDN_SWITCH_HEADER, PARSE_CDN_SWITCH_HEADER)
        optBundle.putStringArrayList(KEY_PARSE_CDN_NODE_LIST, PARSE_CDN_NODE_LIST)
        optBundle.putString(KEY_PARSE_CDN_NAME_HEADER, PARSE_CDN_NAME_HEADERS)
        optBundle.putInt(KEY_PARSE_CDN_TTL, PARSE_CDN_TTL)


        //Optional - Device bundle o/w youbora will decide by its own.
        optBundle.putString(KEY_DEVICE_CODE, DEVICE_CODE)
        optBundle.putString(KEY_DEVICE_BRAND, "Xiaomi")
        optBundle.putString(KEY_DEVICE_MODEL, "Mii3")
        optBundle.putString(KEY_DEVICE_TYPE, "TvBox")
        optBundle.putString(KEY_DEVICE_OS_NAME, "Android/Oreo")
        optBundle.putString(KEY_DEVICE_OS_VERSION, "8.1")

        //Youbora ads configuration bundle.
        optBundle.putString(KEY_AD_CAMPAIGN, CAMPAIGN)

        //Configure custom properties here:
        optBundle.putString(KEY_CONTENT_GENRE, GENRE)
        optBundle.putString(KEY_CONTENT_TYPE, TYPE)
        optBundle.putString(KEY_CONTENT_TRANSACTION_CODE, TRANSACTION_TYPE)
        optBundle.putString(KEY_CONTENT_CDN, CONTENT_CDN_CODE)

        optBundle.putString(KEY_CONTENT_PRICE, PRICE)
        optBundle.putString(KEY_CONTENT_ENCODING_AUDIO_CODEC, AUDIO_TYPE)
        optBundle.putString(KEY_CONTENT_CHANNEL, AUDIO_CHANNELS)

        val contentMetadataBundle = Bundle()

        contentMetadataBundle.putString(KEY_CONTENT_METADATA_YEAR, YEAR)
        contentMetadataBundle.putString(KEY_CONTENT_METADATA_CAST, CAST)
        contentMetadataBundle.putString(KEY_CONTENT_METADATA_DIRECTOR, DIRECTOR)
        contentMetadataBundle.putString(KEY_CONTENT_METADATA_OWNER, OWNER)
        contentMetadataBundle.putString(KEY_CONTENT_METADATA_PARENTAL, PARENTAL)
        contentMetadataBundle.putString(KEY_CONTENT_METADATA_RATING, RATING)
        contentMetadataBundle.putString(KEY_CONTENT_METADATA_QUALITY, QUALITY)

        optBundle.putBundle(KEY_CONTENT_METADATA, contentMetadataBundle)

        //You can add some extra params here:
        optBundle.putString(KEY_CUSTOM_DIMENSION_1, EXTRA_PARAM_1)
        optBundle.putString(KEY_CUSTOM_DIMENSION_2, EXTRA_PARAM_2)

        return optBundle
    }
```

From this point, the plugin will be functional (make sure your account code was set properly).

The plugin will send data for a single media playback.

Once you want to change media you first have to update the plugin with new bundle data using `player?.updatePluginConfig`
then load the new media.

```
youboraPluginConfig?.let {
  if (setPlugin) {
     pkPluginConfigs.setPluginConfig(YouboraPlugin.factory.name, youboraPluginBundle)
  } else {
     player?.updatePluginConfig(YouboraPlugin.factory.name, youboraPluginBundle)
  }
}
```

#### Build YouboraConfig using JSON object (Legacy approach)

Application can create a JSON object to the Plugin config. It is not recommended approach but if you App's legacy code has in this way then you can use it,
```kotlin

private fun getYouboraConfig(): JsonObject {

        // Youbora config json. Main config goes here.
        val youboraConfigJson = JsonObject()
        youboraConfigJson.addProperty("accountCode", ACCOUNT_CODE)
        youboraConfigJson.addProperty("username", UNIQUE_USER_NAME)
        youboraConfigJson.addProperty("userObfuscateIp", true)
        youboraConfigJson.addProperty("httpSecure", true)

//        // Backward compatibility, Use user Json instead
//        youboraConfigJson.addProperty("userEmail", USER_EMAIL)
//        youboraConfigJson.addProperty("userAnonymousId", "my anonymousId")
//        youboraConfigJson.addProperty("userType", "my user type")
//        youboraConfigJson.addProperty("userObfuscateIp", false)

        val userJson = JsonObject()
        userJson.addProperty("email", USER_EMAIL)
        userJson.addProperty("anonymousId", "my anonymousId")
        userJson.addProperty("type", "my user type")
        userJson.addProperty("obfuscateIp", "My ObfuscateIp")

        // Youbora ads configuration json.
        val adsJson = JsonObject()
        adsJson.addProperty("blockerDetected", false)
        adsJson.addProperty("campaign", "zzz")
        // Create AdMetaData
        val adMetaData = JsonObject()
        adMetaData.addProperty("year", "2022")
        adMetaData.addProperty("cast", "cast 2022")
        adMetaData.addProperty("director", "director 2022")
        adMetaData.addProperty("owner", "owner 2022")
        adMetaData.addProperty("parental", "parental 2022")
        adMetaData.addProperty("rating", "rating 2022")
        adMetaData.addProperty("device", "device 2022")
        adMetaData.addProperty("audioChannels", "audioChannels 2022")
        adsJson.add("metadata", adMetaData)
        adsJson.addProperty("campaign", CAMPAIGN)
        adsJson.addProperty("title", "ad title 2022")
        adsJson.addProperty("resource", "resource 2022")
        adsJson.addProperty("givenBreaks", 5)
        adsJson.addProperty("expectedBreaks", 4)
        // Create expectedPattern for Ads
        val expectedPatternJson = JsonObject()
        val preRoll = JsonArray()
        preRoll.add(2)
        val midRoll = JsonArray()
        midRoll.add(1)
        midRoll.add(4)
        val postRoll = JsonArray()
        postRoll.add(3)
        expectedPatternJson.add("pre", preRoll)
        expectedPatternJson.add("mid", midRoll)
        expectedPatternJson.add("post", postRoll)
        adsJson.add("expectedPattern", expectedPatternJson)
        // create adBreaksTime
        val adBreaksTimeArray = JsonArray()
        adBreaksTimeArray.add(0)
        adBreaksTimeArray.add(25)
        adBreaksTimeArray.add(60)
        adBreaksTimeArray.add(75)
        adsJson.add("adBreaksTime", adBreaksTimeArray)
        adsJson.addProperty("adGivenAds", 7)
        adsJson.addProperty("adCreativeId", "ad creativeId")
        adsJson.addProperty("adProvider", "ad provider")
        // Create Ad Custom Dimensions
        val adCustomDimensions = JsonObject()
        adCustomDimensions.addProperty("param1", "my adCustomDimension1")
        adCustomDimensions.addProperty("10", "my adCustomDimension10")
        adsJson.add("customDimension", adCustomDimensions)

        // Media entry json. [Content JSON]
        val mediaEntryJson = JsonObject()
        mediaEntryJson.addProperty("title", MEDIA_TITLE)
        mediaEntryJson.addProperty("contentIsLiveNoSeek", true)
        mediaEntryJson.addProperty("contentCdnCode", CONTENT_CDN_CODE)
        mediaEntryJson.addProperty("contentGenre", GENRE)
        mediaEntryJson.addProperty("contentEpisodeTitle", "xxxxxxx")
        mediaEntryJson.addProperty("contentPrice", PRICE)
        mediaEntryJson.addProperty("contentTransactionCode", TRANSACTION_TYPE)
        mediaEntryJson.addProperty("contentProgram", PROGRAM)
        mediaEntryJson.addProperty("isLive", IS_LIVE_MEDIA)
        mediaEntryJson.addProperty("contentBitrate", 480000)
        // Encoding JSON
        val encodingJson = JsonObject()
        encodingJson.addProperty("videoCodec", "video codec name")
        mediaEntryJson.add("contentEncodingCodecSettings", encodingJson)
        // Create Content MetaData
        val contentMetaData = JsonObject()
        contentMetaData.addProperty("year", "2022")
        contentMetaData.addProperty("cast", "cast 2022")
        contentMetaData.addProperty("director", "director 2022")
        contentMetaData.addProperty("owner", "owner 2022")
        contentMetaData.addProperty("parental", "parental 2022")
        contentMetaData.addProperty("rating", "rating 2022")
        contentMetaData.addProperty("device", "device 2022")
        contentMetaData.addProperty("audioChannels", "audioChannels 2022")
        mediaEntryJson.add("metadata", contentMetaData)
        // Create Content Custom Dimensions
        val contentCustomDimensions = JsonObject()
        contentCustomDimensions.addProperty("param1", "param1")
        contentCustomDimensions.addProperty("param2", "param2")
        mediaEntryJson.add("customDimensions", contentCustomDimensions)

        // Optional - Create Parse JSON object
        val parseJson = JsonObject()
        parseJson.addProperty("parseManifest", PARSE_MANIFEST)
        parseJson.addProperty("parseCdnNode", PARSE_CDN_NODE)
        parseJson.addProperty("parseCdnSwitchHeader", PARSE_CDN_SWITCH_HEADER)
        val parseCdnNodeListJsonArray = JsonArray()
        for(cdn in PARSE_CDN_NODE_LIST) {
            parseCdnNodeListJsonArray.add(cdn)
        }
        parseJson.add("cdnNodeList", parseCdnNodeListJsonArray)
        parseJson.addProperty("cdnNameHeaders", PARSE_CDN_NAME_HEADERS)
        parseJson.addProperty("parseNodeHeader", PARSE_CDN_NODE_HEADERS)
        parseJson.addProperty("parseCdnTTL", PARSE_CDN_TTL)

        // Optional - Device json o/w youbora will decide by its own.
        val deviceJson = JsonObject()
        deviceJson.addProperty("deviceCode", DEVICE_CODE)
        deviceJson.addProperty("deviceBrand", "Brand Xiaomi")
        deviceJson.addProperty("deviceCode", "Code Xiaomi")
        deviceJson.addProperty("deviceId", "Device ID Xiaomi")
        deviceJson.addProperty("deviceEdId", "EdId Xiaomi")
        deviceJson.addProperty("deviceModel", "Model MI3")
        deviceJson.addProperty("deviceOsName", "Android/Oreo")
        deviceJson.addProperty("deviceOsVersion", "8.1")
        deviceJson.addProperty("deviceType", "TvBox TYPE")
        deviceJson.addProperty("deviceName", "TvBox")
        deviceJson.addProperty("deviceIsAnonymous", "TvBox")

        // Optional: Create Network JSON object
        val networkJson = JsonObject()
        networkJson.addProperty("networkConnectionType", "Wireless")
        networkJson.addProperty("networkIP", "1.1.1.1")
        networkJson.addProperty("networkIsp", "Country ISP")

        // App JSON
        val appJson = JsonObject()
        appJson.addProperty("appName", "MyTestApp")
        appJson.addProperty("appReleaseVersion", "1.0.1")

        // Errors JSON
        val errorsJson = JsonObject()
        val errorJsonArray = JsonArray()
        errorJsonArray.add("exception1")
        errorJsonArray.add("exception2")
        errorsJson.add("errorsIgnore", errorJsonArray)

        // SessionMetrics JSON
        val sessionJson = JsonObject()
        sessionJson.addProperty("metricsKey", "metricsValue")

//        // Configure custom properties here, Backward Compatible
//        // Properties are actually metadata which are moved to Ad and Content respectively
//        val propertiesJson = JsonObject()
//        propertiesJson.addProperty("year", YEAR)
//        propertiesJson.addProperty("cast", CAST)
//        propertiesJson.addProperty("director", DIRECTOR)
//        propertiesJson.addProperty("owner", OWNER)
//        propertiesJson.addProperty("parental", PARENTAL)
//
//        propertiesJson.addProperty("rating", RATING)
//        propertiesJson.addProperty("audioType", AUDIO_TYPE)
//        propertiesJson.addProperty("audioChannels", AUDIO_CHANNELS)
//        propertiesJson.addProperty("device", DEVICE)
//        propertiesJson.addProperty("quality", QUALITY)
//
//
//        // Backward Compatible.
//        // These are custom dimensions which are moved to Ads and Content respectively
//        val extraParamJson = JsonObject()
//        extraParamJson.addProperty("param1", EXTRA_PARAM_1)
//        extraParamJson.addProperty("param2", EXTRA_PARAM_2)

        // Add all the json objects created before to the pluginEntry json.
        youboraConfigJson.add("media", mediaEntryJson)
        youboraConfigJson.add("app", appJson)
        youboraConfigJson.add("parse", parseJson)
        youboraConfigJson.add("network", networkJson)
        youboraConfigJson.add("device", deviceJson)
        youboraConfigJson.add("errors", errorsJson)
        youboraConfigJson.add("ads", adsJson)
        youboraConfigJson.add("sessionMetrics", sessionJson)
//        youboraConfigJson.add("properties", propertiesJson)
//        youboraConfigJson.add("extraParams", extraParamJson)

        return youboraConfigJson
    }


```

### Ads

Once the player is configured with IMA Plugin, Youbora Plugin will also report Ads playback analytics.


### Plugin LifeCycle

The Youbora plugin is tied to the player's life cycle and listens to player onPause/onResume calls and player destruction event.

[Example](https://github.com/kaltura/playkit-android-youbora/blob/4b66ffd4855dcfc887a13678bc20f00c1e1e711e/youboraplugin/src/main/java/com/kaltura/playkit/plugins/youbora/YouboraPlugin.java#L258)

#### Samples:

[Kaltura Player Youbora Sample](https://github.com/kaltura/kaltura-player-android-samples/blob/4da67739589a46f49f41c5a94297b363ce00cc37/AdvancedSamples/Youbora/app/src/main/java/com/kaltura/playkit/samples/youbora/MainActivity.kt#L231)
