package com.esolutions.trainings.jsc2.web;

import com.esolutions.trainings.jsc2.model.PassWifi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class PassWIfiController {

    @RequestMapping(method = RequestMethod.GET, path = "/floors/{floor}/rooms/{room}/wifi/password")
    public String getPass(@PathVariable int floor, @PathVariable int room){

        PassWifi pw = new PassWifi();
         return pw.getPass(floor,room);
    }

}
