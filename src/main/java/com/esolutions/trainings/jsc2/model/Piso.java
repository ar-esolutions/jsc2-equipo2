package com.esolutions.trainings.jsc2.model;

import java.util.ArrayList;

public class Piso {
    //Atributos
    private int numeroPiso;
    ArrayList<Habitacion> habitaciones;

    //Constructor
    public Piso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
        //this.habitaciones = habitaciones;
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

    //--------------------------------------------------------------------------
    //Metodo para comprobar si se cumple cuadrado perfecto
     public boolean comprobarCudradoPerfecto(Guest huesped) {
        long numero = huesped.getId();
        double aux = Math.sqrt(numero); //sqrt nos calcula la raiz cuadrada indicada por parametro
        long resultado = (long) aux;
        if (resultado % 2 == 0) {
            if (resultado * resultado == numero) {
                return true;
            }
        }
        return false;
    }

}

