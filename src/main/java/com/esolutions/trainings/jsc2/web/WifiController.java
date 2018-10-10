package com.esolutions.trainings.jsc2.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.regex.Pattern;

@RestController
public class WifiController {
    @RequestMapping(method = RequestMethod.GET, path = "/floors/{floor}/rooms/{room}/wifi/ssid)")
    public String tobinario(@PathVariable int floor,@PathVariable int room){

        String binarioFloor = Integer.toBinaryString(floor);
        String binarioRoom = Integer.toBinaryString(room);
        String cadenaFinal = binarioFloor+binarioRoom;

        String [] spliter = cadenaFinal.split("1");
        //int find = 0;
        ArrayList <String> find = new ArrayList<>();

        int aux = 0;

        for (String s : spliter){
            if (aux < s.length() ){
                if (s.charAt(0) == '1' && s.charAt(s.length()-1) == '1')
                aux = s.length();

            }
        }

        return Integer.toString(aux);
    }
}
