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
        ArrayList<String> auxiliar = new ArrayList<>();

        Pattern pattern = Pattern.compile("JAVA");
        String letra;
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < arreglo.size(); j++) {
                letra=arreglo.get(j);
                switch(letra)
                {
                    case "J":
                        auxiliar.add("J");
                        auxiliar.add("A");
                        break;
                    case "A":
                        auxiliar.add("V");
                        auxiliar.add("A");
                        break;
                    case "V":
                        auxiliar.add("V");
                        auxiliar.add("J");
                        break;

                }

           }
           arreglo = auxiliar;
            auxiliar.clear();
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
