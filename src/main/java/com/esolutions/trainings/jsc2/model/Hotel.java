package com.esolutions.trainings.jsc2.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    //-------------------------Atributos-----------------------//
    private ArrayList<Piso> pisos = new ArrayList<>();
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    private ArrayList<Guest> guests = new ArrayList<>();
    private List<Floor> hotel;

    private final int fin = 50000;
    //----------------------Constructor-----------------------//

    //-------------------------Metodos------------------------//

    public ArrayList<Piso> getPisos() {
        return pisos;
    }

    //Metodo carga de huespedes/habitaciones por piso
//    public void cagarHotel() {
//
//        int contador = 0;
//        for (int i = 0; i< fin +1; i++){
//            guests.add(new Guest());
//            guests.get(i).setId(i);
//        }
//
//        for (int i = 0; i<fin +1; i++){
//
//        }
//    }

    //-------------------------------------------------------------------------------------------------------

    public void cargarHuespedes(int cantidadDeHuespedes)
    {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Floor floor = new Floor();
        floor.setRooms(list);
        hotel = new ArrayList<>();
        hotel.add(floor);
        for (int i = 1; i < cantidadDeHuespedes; i++) {
            for(int j=0; j<hotel.size(); j++)
            {
                List<Integer> listaAuxiliar  = hotel.get(j).getRooms();
                int ultimo = listaAuxiliar.get(listaAuxiliar.size()-1);
                if(comprobarCuadrado(ultimo,i+1))
                {
                    listaAuxiliar.add(i+1);
                    floor=new Floor();
                    floor.setRooms(listaAuxiliar);
                    hotel.set(j,floor);
                    break;
                }
                if(j+1 == hotel.size())
                {
                    List<Integer> listaAux  =new ArrayList<Integer>();
                    listaAux.add(i+1);
                    floor=new Floor();
                    floor.setRooms(listaAux);
                    hotel.add(floor);
                    break;
                }
            }
        }
        imprimir();
    }

    public boolean comprobarCuadrado(int ultimo, int nuevo)
    {
        double primero = Math.sqrt(ultimo+nuevo);
        int segundo = (int)Math.sqrt(ultimo+nuevo);
        if(primero%segundo==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void imprimir()
    {
        for (int i = hotel.size()-1; i >=0 ; i--) {
            List<Integer> listaAux = hotel.get(i).getRooms();
            for(int j=0; j<listaAux.size();j++)
            {
                System.out.print(listaAux.get(j));
                System.out.print("-");
            }
            System.out.println();
        }
    }
}



