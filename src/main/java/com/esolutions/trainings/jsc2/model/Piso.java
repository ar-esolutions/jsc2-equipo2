package com.esolutions.trainings.jsc2.model;

import java.util.ArrayList;

public class Piso {
    //Atributos
    private int numeroPiso;

    ArrayList<Habitacion> habitaciones;

    //Constructor
    public Piso(int numeroPiso, ArrayList<Habitacion> habitaciones) {
        this.numeroPiso = numeroPiso;
        this.habitaciones = habitaciones;
    }
    //--------------------------------------------------------------------------

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

}

