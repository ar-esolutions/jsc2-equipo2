package com.esolutions.trainings.jsc2.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class PassWIfi {

    @RequestMapping(method = RequestMethod.GET, path = "/floors/{floor}/rooms/{room}/wifi/password")
    public int getPass(@PathVariable int floor, @PathVariable int room){

        int tamaño = floor + room;
        ArrayList<String>arreglo = new ArrayList<>();
        arreglo.add("J");
        boolean primero = true;

        Pattern pattern = Pattern.compile("JAVA");

        for (int i = 0; i < tamaño; i++) {
            for (int j = i +1; j < tamaño +1; j++) {

                if(primero && arreglo.get(arreglo.size()-1) == "J") {
                    arreglo.set(0,"JA");
                    primero = false;
                    break;
                } else if (arreglo.get(arreglo.size()-1) == ("JA")){
                    arreglo.set(0,"JAVA");
                    break;
                } else if (arreglo.get(arreglo.size()-1) == ("JAVA")){
                    arreglo.set(0,"JAVAVJVA");
                    break;
                } else if (arreglo.get(arreglo.size()-1) == ("JAVAVJVA")){
                    arreglo.set(0,"JAVAVJVAVJJAVJVA");
                    break;
                } else if(arreglo.get(arreglo.size()-1) == ("JAVAVJVAVJJAVJVA")){
                    arreglo.set(0,"JAVAVJVAVJJAVJVAVJJAJAVAVJJAVJVA");
                    break;
                } else if(arreglo.get(arreglo.size()-1) == "JAVAVJVAVJJAVJVAVJJAJAVAVJJAVJVA"){
                    arreglo.set(0,"JAVAVJVAVJJAVJVAVJJAJAVAVJJAVJVAVJJAJAVAJAVAVJVAVJJAJAVAVJJAVJVA");
                    break;
                }
           }
        }

        Matcher match = pattern.matcher(arreglo.toString());
        boolean encontrar;
        int numerodeveces = 0;

        while (encontrar = match.find()){
            numerodeveces++;
        }
        return numerodeveces;
    }

}
