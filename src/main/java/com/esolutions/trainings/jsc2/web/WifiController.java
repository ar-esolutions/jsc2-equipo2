package com.esolutions.trainings.jsc2.web;

import com.esolutions.trainings.jsc2.http.WifiResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WifiController {
    @RequestMapping(method = RequestMethod.GET, path = "/floors/{floor}/rooms/{room}/wifi/ssid")
    public WifiResponse tobinario(@PathVariable int floor, @PathVariable int room) {

        String binarioFloor = Integer.toBinaryString(floor);
        String binarioRoom = Integer.toBinaryString(room);
        String cadenaFinal = binarioFloor + binarioRoom;

        String[] spliter = cadenaFinal.split("1");

        //ArrayList <String> find = new ArrayList<>();

        int aux = 0;
        int contador = 0;
        for (int i = 0; i < cadenaFinal.length(); i++) {
            contador = 0;
            if (cadenaFinal.charAt(i) == '1') {
                for (int j = i + 1; j < cadenaFinal.length(); j++) {
                    if (cadenaFinal.charAt(j) == '0') {
                        contador++;
                    } else {
                        i = j - 1;
                        if (contador > aux) {
                            aux = contador;
                        }
                        break;
                    }

                }
            }
        }
        if  (aux == 0){
            return new WifiResponse("HAND" + floor +"-"+ room);
        } else {
            return new WifiResponse("HAND" + floor +"-"+ room +"-"+ aux);
        }
        //return new WifiResponse("HAND-" + floor +"-"+ room +"-"+ aux);
    }
}
