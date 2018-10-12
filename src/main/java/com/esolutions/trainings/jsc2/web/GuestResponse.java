package com.esolutions.trainings.jsc2.web;

public class GuestResponse {
    private String[] lastNames;

    public GuestResponse(String[] lastNames) {
        this.lastNames = lastNames;
    }

    public String[] getLastNames() {
        return lastNames;
    }

    public void setLastNames(String[] lastNames) {
        this.lastNames = lastNames;
    }
}
