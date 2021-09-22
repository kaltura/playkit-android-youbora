package com.kaltura.playkit.plugins.youbora.pluginconfig;

public class Errors {

    private String[] errorsIgnore;
    private String[] errorsFatal;
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
