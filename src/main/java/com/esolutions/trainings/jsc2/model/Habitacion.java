package com.esolutions.trainings.jsc2.model;

import java.util.ArrayList;

public class Habitacion {
    //Atributos
    private int numeroHabitacion;
    private Guest huesped;

    //Constructor
    public Habitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
        this.huesped = new Guest();
    }
    //--------------------------------------------------------------------------

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Guest getHuesped() {
        return huesped;
    }

    public void setHuesped(Guest huesped) {
        this.huesped = huesped;
    }

    //Metodo ingresar huesped
    //public void ingresarHuesped(Guest g){
    //    huesped.add(g);
    //}
}
