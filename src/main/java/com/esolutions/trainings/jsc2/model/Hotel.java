package com.esolutions.trainings.jsc2.model;

public class Hotel {

    //-------------------------Atributos-----------------------//
    private int [][] pisoHabitacion; //Arreglo de piso/Habitaciones del hotel
    private int [] guests;//Vector con todos los huéspedes

    //----------------------Constructor-----------------------//
    public Hotel() {
        this.pisoHabitacion = new int [350][350];
        this.guests =  new  int [50000];
    }
    //-------------------------Metodos------------------------//

    //Metodo de carga de Guests por piso y habitacion
    public void cargarGuestsPorPisoH(){

        int anterior = 0;
        int actual = 0;

        for (int i = 0; i < pisoHabitacion.length -1 ; i++) {

            for (int j = 0; j < pisoHabitacion.length; j++){
                anterior = j;
                actual += (anterior + i);
                if (Validaciones.validarPosicionVacia(pisoHabitacion[i][j])) {

                    if(Validaciones.comprobarCudradoPerfecto(guests[actual])){

                        pisoHabitacion[i][j] = guests[actual];

                    } else {
                        pisoHabitacion[i + 1][j] = guests[actual - anterior];
                    }
                }
            }
        }
    }
    //display del hotel con sus habitaciones y guests
    public void verGuestsPorPisoH(){
//        for (int i = 0; i < pisoHabitacion.length; i++) {
//
//            for (int j = 0; j < pisoHabitacion.length; j++){
//
//                System.out.println(pisoHabitacion [i][j]);
//            }
//        }
        System.out.println(pisoHabitacion [0][0]);
    }
    /*
     ****************************************************************************
     */
    //Metodo  de carga total de Guests
    public void cargarGuests(){//Carga los 50k guests de un tiron
        int aux = 1;
        for (int i = 0; i < guests.length; i++){
            guests[i] = aux;
            aux++;
        }
    }
    //display de todos los guests
    public void MostrarGuests(){//Carga los 50k guests de un tiron
        for (int i = 0; i < guests.length; i++){

            System.out.println(guests[i]);
        }
        System.out.println("FINALIZO LA CARGA DE TODOS LOS HUESPEDES...");
    }

}



