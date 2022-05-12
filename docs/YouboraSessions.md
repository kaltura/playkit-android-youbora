# Youbora sessions integration

## To integrate youbora sessions follow this documentation:
https://documentation.npaw.com/npaw-integration/docs/application-analytics-custom-events-data-collection
This means: create a plugin instance that can be accessed globally, and call fireEvent() and fireNav() to report what you want.
with the Plugin Options you want

#### Init Example:
Init has to be created some timwe before creating the player youbora plugin config,
since it is async call and player should use the fastDataConfig that is creatred internally.
```
Bundle optBundle = new Bundle();
optBundle.putString(KEY_ACCOUNT_CODE, ACCOUNT_CODE);
optBundle.putString(KEY_USERNAME, UNIQUE_USER_NAME);
optBundle.putString(KEY_USER_EMAIL, UNIQUE_USER_EMAIL);
optBundle.putString(KEY_APP_NAME, "APP TestApp");
optBundle.putString(KEY_APP_RELEASE_VERSION, "v1.0");

Options options = new Options(optBundle);

appNpawPlugin = new com.npaw.youbora.lib6.plugin.Plugin(options, getApplicationContext());

Map<String, String> dimentions = new HashMap<>();
dimentions.put(KEY_CUSTOM_DIMENSION_1, "my value 1");
dimentions.put(KEY_CUSTOM_DIMENSION_2, "my value 2");
appNpawPlugin.getInfinity().begin("Screen1", dimentions);
```

## Mix session analytics and video analytics
After init, to communicate youbora plugin for sessions and kaltura player youbora plugin:

### Before instantiating the player:
```
ViewTransform.FastDataConfig fastDataConfig = appNpawPlugin.getFastDataConfig();
```
### Instantiating the playre youbora plugin
#### YouboraConfig initiliazation with fastDataConfig params crfeated in appNpawPlugin's fastDataConfig

```
if (fastDataConfig != null) {
   if (appNpawPlugin.getFastDataConfig().host != null) {
       optBundle.putString(FastDataConfigFields.FASTDATA_CONFIG_HOST, fastDataConfig.host);
   }
   if (appNpawPlugin.getFastDataConfig().code != null) {
       optBundle.putString(FastDataConfigFields.FASTDATA_CONFIG_CODE, fastDataConfig.code);
   }
   if (appNpawPlugin.getFastDataConfig().pingTime != null) {
       optBundle.putInt(FastDataConfigFields.FASTDATA_CONFIG_PINGTIME, fastDataConfig.pingTime);
   }
   if (appNpawPlugin.getFastDataConfig().beatTime != null) {
       optBundle.putInt(FastDataConfigFields.FASTDATA_CONFIG_BEATTIME, fastDataConfig.beatTime);
   }
   if (appNpawPlugin.getFastDataConfig().expirationTime != null) {
       optBundle.putInt(FastDataConfigFields.FASTDATA_CONFIG_EXPIRATIONTIME, fastDataConfig.expirationTime);
   }
}
```

### Sending app events to youbora:

#### Example:

```
appNpawPlugin.getInfinity().fireNav("Activity1");

Map<String, String> map = new HashMap<>();
map.put("a", "b");
appNpawPlugin.getInfinity().fireEvent("event1", map);

appNpawPlugin.getInfinity().fireEvent("event2");

Map<String, String> errorMap = new HashMap<>();
errorMap.put("code", "5");
appNpawPlugin.getInfinity().fireEvent("error", errorMap);

appNpawPlugin.getInfinity().end(); // on ended or error
```
