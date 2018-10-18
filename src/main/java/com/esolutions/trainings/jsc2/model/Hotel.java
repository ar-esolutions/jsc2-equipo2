package com.esolutions.trainings.jsc2.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Floor> pisos;
    private final int fin = 50000;

    private List<Floor> cargarHuespedes() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Floor floor = new Floor();
        floor.setRooms(list);
        pisos = new ArrayList<>();
        pisos.add(floor);
        for (int i = 1; i < fin; i++) {
            for (int j = 0; j < pisos.size(); j++) {
                List<Integer> listaAuxiliar = pisos.get(j).getRooms();
                int ultimo = listaAuxiliar.get(listaAuxiliar.size() - 1);
                if (comprobarCuadrado(ultimo, i + 1.0)) {
                    listaAuxiliar.add(i + 1);
                    floor = new Floor();
                    floor.setRooms(listaAuxiliar);
                    pisos.set(j, floor);
                    break;
                }
                if (j + 1 == pisos.size()) {
                    List<Integer> listaAux = new ArrayList<Integer>();
                    listaAux.add(i + 1);
                    floor = new Floor();
                    floor.setRooms(listaAux);
                    pisos.add(floor);
                    break;
                }
            }
        }

        return pisos;
    }

    private boolean comprobarCuadrado(double ultimo, double nuevo) {
        double primero = Math.sqrt(ultimo + nuevo);
        double segundo = Math.sqrt(ultimo + nuevo);
        if (primero % segundo == 0) {
            return true;
        } else {
            return false;
        }
    }



    public List<Floor> getHotel() {
        return cargarHuespedes();
    }
}



