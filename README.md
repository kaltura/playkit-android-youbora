[![CI Status](https://api.travis-ci.org/kaltura/playkit-android-youbora.svg?branch=develop)](https://travis-ci.org/github/kaltura/playkit-android-youbora)
[![Download](https://img.shields.io/maven-central/v/com.kaltura.playkit/youboraplugin?label=Download)](https://search.maven.org/artifact/com.kaltura.playkit/youboraplugin)
[![License](https://img.shields.io/badge/license-AGPLv3-black.svg)](https://github.com/kaltura/playkit-android-kava/blob/master/LICENSE)
![Android](https://img.shields.io/badge/platform-android-green.svg)


# playkit-android-youbora

Youbora provides a business intelligence solution for broadcasters, OTTs, telcos and media to support your business decisions and drive performance. The ability to harness data across various integrated capabilities and services has become increasingly important to support multiple organizations across a video business, including marketing, and to drive consumer engagement and loyalty.

The Youbora player plugin is integrated with the Kaltura player. The plugin listens and reports all the different player states in the current video session to Youbora Analytics. By taking all the data from inside the player, Youbora Analytics is capable of measuring the quality of the video experience from its source, the end user, and in turn analyzing the delivery process end to end. 


* Once you have a player instance you may want to be able to track playback behaviour and playback trends.
* Using Youbora plugin you can acheive this easily.



#### Setup
Add Youbra maven to your project build.gradle in repositories section

`maven { url  "https://npaw.jfrog.io/artifactory/youbora/" }`


Add the youbora plugin depenancy to your build.gradle file:
In android we keep all plugins aligned with same verison.
	
`implementation 'com.kaltura.playkit:youboraplugin:4.x.x'`

##### You can find latest version here: 

[Releases](https://github.com/kaltura/playkit-android-youbora/releases)

##### You can fins the youbora lib version we currently use here

[Youbora lib version](https://github.com/kaltura/playkit-android-youbora/blob/f1dbb0e9f8c9359c164bd32aea909927d099d087/youboraplugin/build.gradle#L33)


#### Create plugin config:

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

#### Build your youbora config Bundle 
###### Example for some of the properites you can send youbora plugin the only must property is your account code in case value is not sent, if plugin have it internally plugin will set it automatically i.e media title, media resource and more.

[Youbora Bundle Keys referance](https://bitbucket.org/npaw/lib-plugin-android/src/047a982e74b452ce2e5aeda426830f3a83da5e29/youboralib/src/main/java/com/npaw/youbora/lib6/plugin/Options.kt#lines-628)

```
    /**
     * Bundle Youbora Configuration
     * @return YouboraConfigBundle
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

From this point the plugin will be funciional (make sure your account code was set properly) 


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

### Ads

Once the player is configured with IMA Plugin the Youbora Plugin will also report Ads playback analytics


### Plugin Life Cycle

The youbora plugin is tied to the player life cycle and listens to player onPause/onResume calls and player destruction event.

[Example](https://github.com/kaltura/playkit-android-youbora/blob/4b66ffd4855dcfc887a13678bc20f00c1e1e711e/youboraplugin/src/main/java/com/kaltura/playkit/plugins/youbora/YouboraPlugin.java#L258)

#### Samples:

[Kaltura Player Youbora Sample](https://github.com/kaltura/kaltura-player-android-samples/blob/4da67739589a46f49f41c5a94297b363ce00cc37/AdvancedSamples/Youbora/app/src/main/java/com/kaltura/playkit/samples/youbora/MainActivity.kt#L231)
