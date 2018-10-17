package com.esolutions.trainings.jsc2.web;

public class GuestResponse {
    private Integer guest;

    public GuestResponse(Integer lastNames) {
        this.guest = lastNames;
    }
    public GuestResponse(){
        guest=null;
    }


    public Integer getGuest() {
        return guest;
    }

    public void setGuest(Integer guest) {
        this.guest = guest;
    }
}
