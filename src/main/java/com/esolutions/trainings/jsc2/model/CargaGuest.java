package com.esolutions.trainings.jsc2.model;

public class CargaGuest {

    //-----------------------Atributos--------------------//
    int [][] pisoHabitacion = new int [350][350];
    int [] guests = new  int [50000];

    //-----------------------Constructores---------------//

    //-----------------------Metodos---------------------//
    //Metodo1 - Incompleto
    public void cargarGuestsPorPisoH(){

        for(int a = 0; a < guests.length; a++){

            for (int i = 0; i < pisoHabitacion.length; i++) {

                for (int j = 0; j < pisoHabitacion.length; j++){

                    if (validarPosicion(pisoHabitacion[i][j])) {

                        if ((comprobarCudradoPerfecto(a))){
                            pisoHabitacion[i][j] = i;
                        } else{

                        }
                    }
                    else{

                    }
                }
            }
        }
    }
    //Metodo2
    public boolean validarPosicion(int i){
        if (i == 0){
            return true;

        } else{
            return false;
        }
    }
    //Metodo3
    public boolean comprobarCudradoPerfecto(int i) {

        long numero = i  + i -1;
        double aux = Math.sqrt(numero);//sqrt nos calcula la raiz cuadrada indicada por parametro
        long resultado = (long) aux;

        if (resultado % 2 == 0) {
            if (resultado * resultado == numero) {
                return true;
            }
        }
        return false;
    }
    //Metodo4
    public void cargarGuests(){//Carga los 50k guests de un tiron
        for (int i = 0; i <= guests.length; i++){
            int aux = 1;
            guests[i] = aux;
            aux++;
        }
    }

}



