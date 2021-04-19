package com.kaltura.playkit.plugins.youbora.pluginconfig;

import com.google.gson.annotations.SerializedName;

public class Device {

//If device info config is not given Youbora will add this info according to their internal logic so actually this is optional configuration


// Youbora's device code. If specified it will rewrite info gotten from user agent.
// See a list of codes in http://mapi.youbora.com:8081/devices
// youboraOptions.setDeviceCode("xbox360"); // Device will be detected as Xbox 360

//// Or in case you want full customised information of the device:
//
//youboraOptions.setDeviceModel("s8");
//youboraOptions.setDeviceBrand("samsung");
//youboraOptions.setDeviceType("smartphone");
//youboraOptions.setDeviceOsName("android");
//youboraOptions.setDeviceOsVersion("8.1");

    @SerializedName(value="deviceBrand", alternate={"brand"})
    private String deviceBrand;
    private String deviceCode;
    @SerializedName(value="deviceId", alternate={"id"})
    private String deviceId;
    @SerializedName(value="deviceModel", alternate={"model"})
    private String deviceModel;
    @SerializedName(value="deviceOsName", alternate={"osName"})
    private String deviceOsName;
    @SerializedName(value="deviceOsVersion", alternate={"osVersion"})
    private String deviceOsVersion;
    @SerializedName(value="deviceType", alternate={"type"})
    private String deviceType;
    private boolean deviceIsAnonymous;

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceOsName() {
        return deviceOsName;
    }

    public void setDeviceOsName(String deviceOsName) {
        this.deviceOsName = deviceOsName;
    }

    public String getDeviceOsVersion() {
        return deviceOsVersion;
    }

    public void setDeviceOsVersion(String deviceOsVersion) {
        this.deviceOsVersion = deviceOsVersion;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public boolean getDeviceIsAnonymous() {
        return deviceIsAnonymous;
    }

    public void setDeviceIsAnonymous(boolean deviceIsAnonymous) {
        this.deviceIsAnonymous = deviceIsAnonymous;
    }
}



//[
//        {
//          id: 40,
//          name: Roku 3,
//          code: Roku3
//        },
//        {
//          id: 22,
//          name: BlackBerry PlayBook,
//          code: BlackBerryPlayBook
//        },
//        {
//          id: 67,
//          name: OperaTV,
//          code: OperaTV
//        },
//        {
//          id: 49,
//          name: Android TV,
//          code: AndroidTV
//        },
//        {
//          id: 31,
//          name: Sony Bluray,
//          code: SonyBluray
//        },
//        {
//          id: 12,
//          name: Xbox360,
//          code: Xbox360
//        },
//        {
//          id: 20,
//          name: Nintendo Wii U,
//          code: NintendoWiiU
//        },
//        {
//          id: 75,
//          name: Roku 2,
//          code: Roku2
//        },
//        {
//          id: 6,
//          name: Samsung,
//          code: Samsung
//        },
//        {
//          id: 27,
//          name: Chrome OS,
//          code: ChromeOS
//        },
//        {
//          id: 55,
//          name: STB,
//          code: STB
//        },
//        {
//          id: 89,
//          name: HbbTV,
//          code: HbbTV
//        },
//        {
//          id: 68,
//          name: 2400SK,
//          code: 2400SK
//        },
//        {
//          id: 62,
//          name: STB Supercanal / ARG,
//          code: STBSupercanal_ARG
//        },
//        {
//          id: 83,
//          name: Sagemcom,
//          code: Sagemcom
//        },
//        {
//          id: 34,
//          name: Roku,
//          code: Roku
//        },
//        {
//          id: 48,
//          name: iOS,
//          code: iOS
//        },
//        {
//          id: 19,
//          name: BlackBerry,
//          code: BlackBerry
//        },
//        {
//          id: 41,
//          name: Roku Stick,
//          code: RokuStick
//        },
//        {
//          id: 13,
//          name: Playstation,
//          code: Playstation
//        },
//        {
//          id: 5,
//          name: Vodafone STB,
//          code: VodafoneSTB
//        },
//        {
//          id: 28,
//          name: FreeBSD,
//          code: FreeBSD
//        },
//        {
//          id: 69,
//          name: 4200SK,
//          code: 4200SK
//        },
//        {
//          id: 33,
//          name: Chromecast,
//          code: Chromecast
//        },
//        {
//          id: 18,
//          name: WuakiTv,
//          code: WuakiTv
//        },
//        {
//          id: 88,
//          name: CACTUS,
//          code: CACTUS
//        },
//        {
//          id: 61,
//          name: STB Montecable / URU,
//          code: STBMontecarlo_URU
//        },
//        {
//          id: 74,
//          name: Roku 1,
//          code: Roku1
//        },
//        {
//          id: 42,
//          name: Hisense,
//          code: Hisense
//        },
//        {
//          id: 47,
//          name: Arris STB,
//          code: ArrisSTB
//        },
//        {
//          id: 25,
//          name: Xbox One,
//          code: XboxOne
//        },
//        {
//          id: 56,
//          name: STB IZZI / MEX,
//          code: STBIZZI_MEX
//        },
//        {
//          id: 84,
//          name: Vestel,
//          code: Vestel
//        },
//        {
//          id: 70,
//          name: 4201SK,
//          code: 4201SK
//        },
//        {
//          id: 91,
//          name: Netrange,
//          code: Netrange
//        },
//        {
//          id: 7,
//          name: Philips,
//          code: Philips
//        },
//        {
//          id: 81,
//          name: Telecable STB,
//          code: TelecableSTB
//        },
//        {
//          id: 46,
//          name: Apple TV,
//          code: AppleTV
//        },
//        {
//          id: 73,
//          name: Roku XD,
//          code: RokuXD
//        },
//        {
//          id: 53,
//          name: Android tablet,
//          code: AndroidTablet
//        },
//        {
//          id: 90,
//          name: Foxxum,
//          code: Foxxum
//        },
//        {
//          id: 36,
//          name: Nokia,
//          code: Nokia
//        },
//        {
//          id: 26,
//          name: Playstation 2,
//          code: Playstation2
//        },
//        {
//          id: 45,
//          name: Roku 4,
//          code: Roku4
//        },
//        {
//          id: 8,
//          name: LG,
//          code: LG
//        },
//        {
//          id: 35,
//          name: SunOS,
//          code: SunOS
//        },
//        {
//          id: 72,
//          name: Roku SD,
//          code: RokuSD
//        },
//        {
//          id: 63,
//          name: STB Telefonica / PER,
//          code: STBTelefonica_PER
//        },
//        {
//          id: 54,
//          name: Android phone,
//          code: AndroidPhone
//        },
//        {
//          id: 82,
//          name: Tivo STB,
//          code: Tivo_STB
//        },
//        {
//          id: 17,
//          name: Unknown,
//          code: Unknown
//        },
//        {
//          id: 2,
//          name: PC( Windows ),
//          code: PCWindows
//        },
//        {
//          id: 51,
//          name: FreeSat,
//          code: FreeSat
//        },
//        {
//          id: 37,
//          name: VF_STB,
//          code: VF_STB
//        },
//        {
//          id: 58,
//          name: STB Telecentro / ARG,
//          code: STBTelecentro_ARG
//        },
//        {
//          id: 9,
//          name: iPad,
//          code: iPad
//        },
//        {
//          id: 86,
//          name: Lebara Play Coship STB,
//          code: LebaraPlayCoshipSTB
//        },
//        {
//          id: 44,
//          name: Samsung - Tizen,
//          code: SamsungTizen
//        },
//        {
//          id: 92,
//          name: LYF,
//          code: LYF
//        },
//        {
//          id: 64,
//          name: PC (Windows) UWP,
//          code: PCWindowsUWP
//        },
//        {
//          id: 16,
//          name: Windows Phone,
//          code: WindowsPhone
//        },
//        {
//          id: 71,
//          name: 4500SK,
//          code: 4500SK
//        },
//        {
//          id: 10,
//          name: iPhone,
//          code: iPhone
//        },
//        {
//          id: 52,
//          name: Lebara STB,
//          code: LebaraSTB
//        },
//        {
//          id: 78,
//          name: Roku Premiere,
//          code: RokuPremiere
//        },
//        {
//          id: 43,
//          name: tvOS,
//          code: tvOS
//        },
//        {
//          id: 30,
//          name: Sony Bravia,
//          code: SonyBravia
//        },
//        {
//          id: 23,
//          name: Playstation 3,
//          code: Playstation3
//        },
//        {
//          id: 15,
//          name: Sony,
//          code: Sony
//        },
//        {
//          id: 1,
//          name: PC( Linux ),
//          code: PCLinux
//        },
//        {
//          id: 57,
//          name: STB TotalPlay / MEX,
//          code: STBTotalPlay_MEX
//        },
//        {
//          id: 85,
//          name: Telecable STB Sagemcom,
//          code: Telecable STB Sagemcom
//        },
//        {
//          id: 38,
//          name: Roku HD,
//          code: RokuHD
//        },
//        {
//          id: 29,
//          name: Netgem,
//          code: Netgem
//        },
//        {
//          id: 80,
//          name: TCL,
//          code: TCL
//        },
//        {
//          id: 24,
//          name: Playstation 4,
//          code: Playstation4
//        },
//        {
//          id: 65,
//          name: Mobile UWP,
//          code: MobileUWP
//        },
//        {
//          id: 93,
//          name: Alhambra STB,
//          code: AlhambraSTB
//        },
//        {
//          id: 79,
//          name: Roku Ultra,
//          code: RokuUltra
//        },
//        {
//          id: 77,
//          name: Roku Express,
//          code: RokuExpress
//        },
//        {
//          id: 21,
//          name: Playstation Vita,
//          code: PlaystationVita
//        },
//        {
//          id: 14,
//          name: Curl,
//          code: Curl
//        },
//        {
//          id: 60,
//          name: STB TCC / URU,
//          code: STBTCC_URU
//        },
//        {
//          id: 3,
//          name: PC( MAC ),
//          code: PCMac
//        },
//        {
//          id: 66,
//          name: XBOX ONE UWP,
//          code: XboxOneUWP
//        },
//        {
//          id: 39,
//          name: Roku LT,
//          code: RokuLT
//        },
//        {
//          id: 32,
//          name: iPod,
//          code: iPod
//        },
//        {
//          id: 11,
//          name: Android,
//          code: Android
//        },
//        {
//          id: 4,
//          name: Panasonic,
//          code: Panasonic
//        },
//        {
//          id: 50,
//          name: FireTV,
//          code: FireTV
//        },
//        {
//          id: 76,
//          name: Roku TV,
//          code: RokuTV
//        },
//        {
//          id: 59,
//          name: STB NuevoSiglo / URU,
//          code: STBNuevoSiglo_URU
//        },
//        {
//          id: 87,
//          name: Horizon STB,
//          code: HorizonSTB
//        }
//]
