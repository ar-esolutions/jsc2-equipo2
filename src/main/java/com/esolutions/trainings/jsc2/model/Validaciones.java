package com.esolutions.trainings.jsc2.model;

public class Validaciones {

    //Metodo para validar si la habitacion esta o no ocupada
    static boolean validarPosicionVacia(int i) {
        boolean resultado = (i == 0) ? true : false;
        return resultado;
    }

    //Metodo para coprobar si se cumple cuadrado perfecto
    static boolean comprobarCudradoPerfecto(Guest huesped) {
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

    //Metodo gral
//    public boolean validar(int i){
//
//        if( validarPosicionVacia(i)){
//            if (comprobarCudradoPerfecto(i)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
