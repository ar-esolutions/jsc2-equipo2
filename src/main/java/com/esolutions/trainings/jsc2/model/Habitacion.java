package com.esolutions.trainings.jsc2.model;

import java.util.ArrayList;

public class Habitacion {
    //Atributos
    private int numeroHabitacion;
    ArrayList<Guest> huesped;

    //Constructor
    public Habitacion(int numeroHabitacion, ArrayList<Guest> p) {
        this.numeroHabitacion = numeroHabitacion;
        this.huesped = new ArrayList<>();
    }
    //--------------------------------------------------------------------------

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public ArrayList<Guest> getHuesped() {
        return huesped;
    }

    public void setHuesped(ArrayList<Guest> huesped) {
        this.huesped = huesped;
    }

    //metodo para valida Habitacion vacia
    public boolean estaVaciaH(){
        boolean bandera;
        if(huesped==null)
           return  bandera=true;
        else
          return bandera =false;

    }

}
