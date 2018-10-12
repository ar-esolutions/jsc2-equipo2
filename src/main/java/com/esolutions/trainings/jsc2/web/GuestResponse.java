package com.esolutions.trainings.jsc2.web;

public class GuestResponse {
    private int lastNames;

    public GuestResponse(int lastNames) {
        this.lastNames = lastNames;
    }

    public int getLastNames() {
        return lastNames;
    }

    public void setLastNames(int lastNames) {
        this.lastNames = lastNames;
    }
}
