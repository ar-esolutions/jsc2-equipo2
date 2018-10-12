package com.esolutions.trainings.jsc2.http;

public class WifiResponse {
    public WifiResponse(String ssid) {
        this.ssid = ssid;
    }

    private String ssid;

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String cadena) {
        this.ssid = cadena;
    }
}
