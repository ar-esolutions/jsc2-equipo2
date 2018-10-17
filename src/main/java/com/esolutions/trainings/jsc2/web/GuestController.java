package com.esolutions.trainings.jsc2.web;

import com.esolutions.trainings.jsc2.logic.GuestRepeatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RestController
public class GuestController {
    private final GuestRepeatedService service;

    @Autowired
    public GuestController(GuestRepeatedService service) {
        this.service = service;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/guests/last-name/repeated")

    public Set<String> repeatedLastName() {


        String[] lista = this.service.obtenerDatosGuests();
        Set<String> ListaFinal = new HashSet<String>();

        //String[] listafinal = new String[10];
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
                ListaFinal.add(lista[i]);
            }
        }
        //GuestResponse retorno = new GuestResponse(0);


        return ListaFinal;
    }
}