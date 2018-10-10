package com.esolutions.trainings.jsc2.model;

import java.util.ArrayList;

public class Hotel {

    //-------------------------Atributos-----------------------//
    private ArrayList<Piso> pisos = new ArrayList<>();
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    private ArrayList<Guest> guests = new ArrayList<>();

    private final int fin = 50000;
    //----------------------Constructor-----------------------//

    //-------------------------Metodos------------------------//

    public ArrayList<Piso> getPisos() {
        return pisos;
    }

    //Metodo carga de huespedes/habitaciones por piso
    public void cagarHotel() {

        int contador = 0;
        for (int i = 0; i< fin +1; i++){
            guests.add(new Guest());
            guests.get(i).setId(i);
        }

        for (int i = 0; i<fin +1; i++){

        }
    }

    //-------------------------------------------------------------------------------------------------------
}



