# Youbora sessions integration

## To integrate youbora sessions follow this documentation:
https://documentation.npaw.com/npaw-integration/docs/application-analytics-custom-events-data-collection
This means: create a plugin instance that can be accessed globally, and call fireEvent() and fireNav() to report what you want.

## Mix session analytics and video analytics
After, to communicate youbora plugin for sessions and kaltura player:

### Before instantiating the player:

ViewTransform.FastDataConfig fastDataConfig = plugin.getFastDataConfig();

### When instantiating the player, and before starting any video view set the object obtained previously in youboraconfig object used in player's constructor:

youboraConfig.setFastDataConfig(fastDataConfig)
