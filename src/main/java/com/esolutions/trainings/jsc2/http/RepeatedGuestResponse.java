package com.esolutions.trainings.jsc2.http;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class RepeatedGuestResponse {
    SortedSet<String> LastNames = new TreeSet<>();

    public SortedSet<String> getLastNames() {
        return LastNames;
    }

    public void setLastNames(SortedSet<String> LastNames) {
        this.LastNames = LastNames;
    }

    public RepeatedGuestResponse(SortedSet<String> LastNames) {
        this.LastNames = LastNames;
    }
}
