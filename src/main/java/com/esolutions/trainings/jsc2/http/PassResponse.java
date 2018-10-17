package com.esolutions.trainings.jsc2.http;

public class PassResponse {
    private String password;

    public PassResponse() {
        password=null;
    }

    public PassResponse(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
