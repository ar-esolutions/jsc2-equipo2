package com.esolutions.trainings.jsc2.model;

import com.esolutions.trainings.jsc2.web.PassWIfiController;

public class TestMain {
    public static void main(String[] args) {

        PassWifi pw = new PassWifi();
        System.out.println(pw.getPass(4,3));
        pw.imprimir(7);
    }
}