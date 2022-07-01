package com.kaltura.playkit.plugins.youbora.pluginconfig;

import com.google.gson.annotations.SerializedName;

public class Errors {

    @SerializedName(value="errorsIgnore", alternate={"ignore"})
    private String[] errorsIgnore;

    @SerializedName(value="errorsFatal", alternate={"fatal"})
    private String[] errorsFatal;

    @SerializedName(value="errorsNonFatal", alternate={"nonFatal"})
    private String[] errorsNonFatal;

    public String[] getErrorsIgnore() {
        return errorsIgnore;
    }

    public void setErrorsIgnore(String[] errorsIgnore) {
        this.errorsIgnore = errorsIgnore;
    }

    public String[] getErrorsFatal() {
        return errorsFatal;
    }

    public void setErrorsFatal(String[] errorsFatal) {
        this.errorsFatal = errorsFatal;
    }

    public String[] getErrorsNonFatal() {
        return errorsNonFatal;
    }

    public void setErrorsNonFatal(String[] errorsNonFatal) {
        this.errorsNonFatal = errorsNonFatal;
    }
}
