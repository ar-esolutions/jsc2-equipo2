package com.esolutions.trainings.jsc2.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Floor> hotel;
    private final int fin = 50000;

    private List<Floor> cargarHuespedes() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Floor floor = new Floor();
        floor.setRooms(list);
        hotel = new ArrayList<>();
        hotel.add(floor);
        for (int i = 1; i < fin; i++) {
            for (int j = 0; j < hotel.size(); j++) {
                List<Integer> listaAuxiliar = hotel.get(j).getRooms();
                int ultimo = listaAuxiliar.get(listaAuxiliar.size() - 1);
                if (comprobarCuadrado(ultimo, i + 1.0)) {
                    listaAuxiliar.add(i + 1);
                    floor = new Floor();
                    floor.setRooms(listaAuxiliar);
                    hotel.set(j, floor);
                    break;
                }
                if (j + 1 == hotel.size()) {
                    List<Integer> listaAux = new ArrayList<Integer>();
                    listaAux.add(i + 1);
                    floor = new Floor();
                    floor.setRooms(listaAux);
                    hotel.add(floor);
                    break;
                }
            }
        }
        imprimir();
        return hotel;
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

    private void imprimir() {
        for (int i = hotel.size() - 1; i >= 0; i--) {
            List<Integer> listaAux = hotel.get(i).getRooms();
            for (int j = 0; j < listaAux.size(); j++) {
                System.out.print(listaAux.get(j));
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public List<Floor> getHotel() {
        return cargarHuespedes();
    }
}



