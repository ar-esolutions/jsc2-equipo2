package com.esolutions.trainings.jsc2.web;

public class GuestResponse {
    private int guest;

    public GuestResponse(int lastNames) {
        this.guest = lastNames;
    }


    public int getGuest() {
        return guest;
    }

    public void setGuest(int guest) {
        this.guest = guest;
    }
}
