package com.kaltura.playkit.plugins.youbora.pluginconfig;

public class Device {


//// If you want generic information
//youboraOptions.setDeviceCode("xbox360"); // Device will be detected as Xbox 360
//
//// Or in case you want full customised information of the device:
//
//youboraOptions.setDeviceModel("s8");
//youboraOptions.setDeviceBrand("samsung");
//youboraOptions.setDeviceType("smartphone");
//youboraOptions.setDeviceOsName("android");
//youboraOptions.setDeviceOsVersion("8.1");

    private String deviceCode;
    private String brand;
    private String model;
    private String type;
    private String osName;
    private String osVersion;

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }
}



//"[\n"+
//        "  {\n"+
//        "    \"id\": 40,\n"+
//        "    \"name\": \"Roku 3\",\n"+
//        "    \"code\": \"Roku3\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 22,\n"+
//        "    \"name\": \"BlackBerry PlayBook\",\n"+
//        "    \"code\": \"BlackBerryPlayBook\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 67,\n"+
//        "    \"name\": \"OperaTV\",\n"+
//        "    \"code\": \"OperaTV\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 49,\n"+
//        "    \"name\": \"Android TV\",\n"+
//        "    \"code\": \"AndroidTV\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 31,\n"+
//        "    \"name\": \"Sony Bluray\",\n"+
//        "    \"code\": \"SonyBluray\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 12,\n"+
//        "    \"name\": \"Xbox360\",\n"+
//        "    \"code\": \"Xbox360\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 20,\n"+
//        "    \"name\": \"Nintendo Wii U\",\n"+
//        "    \"code\": \"NintendoWiiU\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 75,\n"+
//        "    \"name\": \"Roku 2\",\n"+
//        "    \"code\": \"Roku2\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 6,\n"+
//        "    \"name\": \"Samsung\",\n"+
//        "    \"code\": \"Samsung\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 27,\n"+
//        "    \"name\": \"Chrome OS\",\n"+
//        "    \"code\": \"ChromeOS\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 55,\n"+
//        "    \"name\": \"STB\",\n"+
//        "    \"code\": \"STB\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 89,\n"+
//        "    \"name\": \"HbbTV\",\n"+
//        "    \"code\": \"HbbTV\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 68,\n"+
//        "    \"name\": \"2400SK\",\n"+
//        "    \"code\": \"2400SK\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 62,\n"+
//        "    \"name\": \"STB Supercanal / ARG\",\n"+
//        "    \"code\": \"STBSupercanal_ARG\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 83,\n"+
//        "    \"name\": \"Sagemcom\",\n"+
//        "    \"code\": \"Sagemcom\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 34,\n"+
//        "    \"name\": \"Roku\",\n"+
//        "    \"code\": \"Roku\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 48,\n"+
//        "    \"name\": \"iOS\",\n"+
//        "    \"code\": \"iOS\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 19,\n"+
//        "    \"name\": \"BlackBerry\",\n"+
//        "    \"code\": \"BlackBerry\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 41,\n"+
//        "    \"name\": \"Roku Stick\",\n"+
//        "    \"code\": \"RokuStick\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 13,\n"+
//        "    \"name\": \"Playstation\",\n"+
//        "    \"code\": \"Playstation\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 5,\n"+
//        "    \"name\": \"Vodafone STB\",\n"+
//        "    \"code\": \"VodafoneSTB\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 28,\n"+
//        "    \"name\": \"FreeBSD\",\n"+
//        "    \"code\": \"FreeBSD\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 69,\n"+
//        "    \"name\": \"4200SK\",\n"+
//        "    \"code\": \"4200SK\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 33,\n"+
//        "    \"name\": \"Chromecast\",\n"+
//        "    \"code\": \"Chromecast\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 18,\n"+
//        "    \"name\": \"WuakiTv\",\n"+
//        "    \"code\": \"WuakiTv\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 88,\n"+
//        "    \"name\": \"CACTUS\",\n"+
//        "    \"code\": \"CACTUS\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 61,\n"+
//        "    \"name\": \"STB Montecable / URU\",\n"+
//        "    \"code\": \"STBMontecarlo_URU\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 74,\n"+
//        "    \"name\": \"Roku 1\",\n"+
//        "    \"code\": \"Roku1\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 42,\n"+
//        "    \"name\": \"Hisense\",\n"+
//        "    \"code\": \"Hisense\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 47,\n"+
//        "    \"name\": \"Arris STB\",\n"+
//        "    \"code\": \"ArrisSTB\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 25,\n"+
//        "    \"name\": \"Xbox One\",\n"+
//        "    \"code\": \"XboxOne\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 56,\n"+
//        "    \"name\": \"STB IZZI / MEX\",\n"+
//        "    \"code\": \"STBIZZI_MEX\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 84,\n"+
//        "    \"name\": \"Vestel\",\n"+
//        "    \"code\": \"Vestel\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 70,\n"+
//        "    \"name\": \"4201SK\",\n"+
//        "    \"code\": \"4201SK\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 91,\n"+
//        "    \"name\": \"Netrange\",\n"+
//        "    \"code\": \"Netrange\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 7,\n"+
//        "    \"name\": \"Philips\",\n"+
//        "    \"code\": \"Philips\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 81,\n"+
//        "    \"name\": \"Telecable STB\",\n"+
//        "    \"code\": \"TelecableSTB\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 46,\n"+
//        "    \"name\": \"Apple TV\",\n"+
//        "    \"code\": \"AppleTV\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 73,\n"+
//        "    \"name\": \"Roku XD\",\n"+
//        "    \"code\": \"RokuXD\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 53,\n"+
//        "    \"name\": \"Android tablet\",\n"+
//        "    \"code\": \"AndroidTablet\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 90,\n"+
//        "    \"name\": \"Foxxum\",\n"+
//        "    \"code\": \"Foxxum\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 36,\n"+
//        "    \"name\": \"Nokia\",\n"+
//        "    \"code\": \"Nokia\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 26,\n"+
//        "    \"name\": \"Playstation 2\",\n"+
//        "    \"code\": \"Playstation2\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 45,\n"+
//        "    \"name\": \"Roku 4\",\n"+
//        "    \"code\": \"Roku4\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 8,\n"+
//        "    \"name\": \"LG\",\n"+
//        "    \"code\": \"LG\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 35,\n"+
//        "    \"name\": \"SunOS\",\n"+
//        "    \"code\": \"SunOS\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 72,\n"+
//        "    \"name\": \"Roku SD\",\n"+
//        "    \"code\": \"RokuSD\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 63,\n"+
//        "    \"name\": \"STB Telefonica / PER\",\n"+
//        "    \"code\": \"STBTelefonica_PER\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 54,\n"+
//        "    \"name\": \"Android phone\",\n"+
//        "    \"code\": \"AndroidPhone\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 82,\n"+
//        "    \"name\": \"Tivo STB\",\n"+
//        "    \"code\": \"Tivo_STB\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 17,\n"+
//        "    \"name\": \"Unknown\",\n"+
//        "    \"code\": \"Unknown\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 2,\n"+
//        "    \"name\": \"PC( Windows )\",\n"+
//        "    \"code\": \"PCWindows\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 51,\n"+
//        "    \"name\": \"FreeSat\",\n"+
//        "    \"code\": \"FreeSat\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 37,\n"+
//        "    \"name\": \"VF_STB\",\n"+
//        "    \"code\": \"VF_STB\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 58,\n"+
//        "    \"name\": \"STB Telecentro / ARG\",\n"+
//        "    \"code\": \"STBTelecentro_ARG\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 9,\n"+
//        "    \"name\": \"iPad\",\n"+
//        "    \"code\": \"iPad\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 86,\n"+
//        "    \"name\": \"Lebara Play Coship STB\",\n"+
//        "    \"code\": \"LebaraPlayCoshipSTB\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 44,\n"+
//        "    \"name\": \"Samsung - Tizen\",\n"+
//        "    \"code\": \"SamsungTizen\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 92,\n"+
//        "    \"name\": \"LYF\",\n"+
//        "    \"code\": \"LYF\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 64,\n"+
//        "    \"name\": \"PC (Windows) UWP\",\n"+
//        "    \"code\": \"PCWindowsUWP\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 16,\n"+
//        "    \"name\": \"Windows Phone\",\n"+
//        "    \"code\": \"WindowsPhone\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 71,\n"+
//        "    \"name\": \"4500SK\",\n"+
//        "    \"code\": \"4500SK\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 10,\n"+
//        "    \"name\": \"iPhone\",\n"+
//        "    \"code\": \"iPhone\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 52,\n"+
//        "    \"name\": \"Lebara STB\",\n"+
//        "    \"code\": \"LebaraSTB\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 78,\n"+
//        "    \"name\": \"Roku Premiere\",\n"+
//        "    \"code\": \"RokuPremiere\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 43,\n"+
//        "    \"name\": \"tvOS\",\n"+
//        "    \"code\": \"tvOS\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 30,\n"+
//        "    \"name\": \"Sony Bravia\",\n"+
//        "    \"code\": \"SonyBravia\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 23,\n"+
//        "    \"name\": \"Playstation 3\",\n"+
//        "    \"code\": \"Playstation3\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 15,\n"+
//        "    \"name\": \"Sony\",\n"+
//        "    \"code\": \"Sony\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 1,\n"+
//        "    \"name\": \"PC( Linux )\",\n"+
//        "    \"code\": \"PCLinux\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 57,\n"+
//        "    \"name\": \"STB TotalPlay / MEX\",\n"+
//        "    \"code\": \"STBTotalPlay_MEX\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 85,\n"+
//        "    \"name\": \"Telecable STB Sagemcom\",\n"+
//        "    \"code\": \"Telecable STB Sagemcom\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 38,\n"+
//        "    \"name\": \"Roku HD\",\n"+
//        "    \"code\": \"RokuHD\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 29,\n"+
//        "    \"name\": \"Netgem\",\n"+
//        "    \"code\": \"Netgem\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 80,\n"+
//        "    \"name\": \"TCL\",\n"+
//        "    \"code\": \"TCL\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 24,\n"+
//        "    \"name\": \"Playstation 4\",\n"+
//        "    \"code\": \"Playstation4\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 65,\n"+
//        "    \"name\": \"Mobile UWP\",\n"+
//        "    \"code\": \"MobileUWP\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 93,\n"+
//        "    \"name\": \"Alhambra STB\",\n"+
//        "    \"code\": \"AlhambraSTB\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 79,\n"+
//        "    \"name\": \"Roku Ultra\",\n"+
//        "    \"code\": \"RokuUltra\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 77,\n"+
//        "    \"name\": \"Roku Express\",\n"+
//        "    \"code\": \"RokuExpress\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 21,\n"+
//        "    \"name\": \"Playstation Vita\",\n"+
//        "    \"code\": \"PlaystationVita\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 14,\n"+
//        "    \"name\": \"Curl\",\n"+
//        "    \"code\": \"Curl\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 60,\n"+
//        "    \"name\": \"STB TCC / URU\",\n"+
//        "    \"code\": \"STBTCC_URU\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 3,\n"+
//        "    \"name\": \"PC( MAC )\",\n"+
//        "    \"code\": \"PCMac\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 66,\n"+
//        "    \"name\": \"XBOX ONE UWP\",\n"+
//        "    \"code\": \"XboxOneUWP\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 39,\n"+
//        "    \"name\": \"Roku LT\",\n"+
//        "    \"code\": \"RokuLT\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 32,\n"+
//        "    \"name\": \"iPod\",\n"+
//        "    \"code\": \"iPod\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 11,\n"+
//        "    \"name\": \"Android\",\n"+
//        "    \"code\": \"Android\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 4,\n"+
//        "    \"name\": \"Panasonic\",\n"+
//        "    \"code\": \"Panasonic\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 50,\n"+
//        "    \"name\": \"FireTV\",\n"+
//        "    \"code\": \"FireTV\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 76,\n"+
//        "    \"name\": \"Roku TV\",\n"+
//        "    \"code\": \"RokuTV\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 59,\n"+
//        "    \"name\": \"STB NuevoSiglo / URU\",\n"+
//        "    \"code\": \"STBNuevoSiglo_URU\"\n"+
//        "  },\n"+
//        "  {\n"+
//        "    \"id\": 87,\n"+
//        "    \"name\": \"Horizon STB\",\n"+
//        "    \"code\": \"HorizonSTB\"\n"+
//        "  }\n"+
//        "] "