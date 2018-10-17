package com.esolutions.trainings.jsc2.web;

import com.esolutions.trainings.jsc2.logic.GuestRepeatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.esolutions.trainings.jsc2.http.RepeatedGuestResponse;

import java.util.*;

@RestController
public class GuestController {
    private final GuestRepeatedService service;

    @Autowired
    public GuestController(GuestRepeatedService service) {
        this.service = service;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/guests/last-name/repeated")

    public RepeatedGuestResponse repeatedLastName() {


        String[] lista = this.service.obtenerDatosGuests();
        SortedSet<String> LastNames = new TreeSet<String>();


        int cont = 0;
        int cLista = 0;
        for (int i = 0; i < lista.length; i++) {
            lista[i] = StringUtils.capitalize(lista[i].substring(0,lista[i].indexOf(",")));
        }
        for (int i = 0; i < lista.length; i++)
        {
            cont = 0;
            for (int j = 0; j < lista.length; j++){
                if (lista[i].equals(lista[j])){
                    cont++;
                }
            }
            if (cont > 1) {
                LastNames.add(lista[i]);
            }
        }

        RepeatedGuestResponse retorno = new RepeatedGuestResponse(LastNames);

        return retorno;
    }
}