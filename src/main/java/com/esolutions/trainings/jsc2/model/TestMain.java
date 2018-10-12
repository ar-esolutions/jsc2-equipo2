package com.esolutions.trainings.jsc2.model;

import com.esolutions.trainings.jsc2.web.PassWIfi;
import com.esolutions.trainings.jsc2.web.WifiController;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class TestMain {
    public static void main(String[] args) {

        PassWIfi wf = new PassWIfi();
        int pass = wf.getPass(5,5);
        System.out.println(pass);
    }
}