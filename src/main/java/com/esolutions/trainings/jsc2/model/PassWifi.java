package com.esolutions.trainings.jsc2.model;

import java.util.ArrayList;

public class PassWifi {

    private ArrayList<String>arreglo;

    private void getCadena(int tamaño)
    {
        arreglo = new ArrayList<>();
        arreglo.add("J");
        boolean primero = true;
        ArrayList<String> auxiliar = new ArrayList<>();

        String letra;
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < arreglo.size(); j++) {
                letra=arreglo.get(j);
                switch(letra)
                {
                    case "J":
                        auxiliar.add("J");
                        auxiliar.add("A");
                        break;
                    case "A":
                        auxiliar.add("V");
                        auxiliar.add("A");
                        break;
                    case "V":
                        auxiliar.add("V");
                        auxiliar.add("J");
                        break;

                }

            }

            arreglo = new ArrayList<>(auxiliar);
            auxiliar.clear();
        }
    }
    /*
    ********************************************************************************************************************
     */
    public  int encontrarPalabra(String s){

        int numerodeveces = 0;

        for (int i = 0; i < arreglo.size(); i++) {
            if (arreglo.get(i).contains("J") && arreglo.get(i+1).contains("A")
                && arreglo.get(i+2).contains("V")&& arreglo.get(i+3).contains("A")){
                numerodeveces++;
            }
        }
        return numerodeveces;
    }
    /*
     ********************************************************************************************************************
     */
    public void imprimir(int t)
    {
        getCadena(t);
        for (int i = 0; i < arreglo.size(); i++) {
            System.out.print(arreglo.get(i));
        }
    }
    /*
     ********************************************************************************************************************
     */
    public  String getPass(int floor, int room){
        getCadena(floor + room);
        int pass = encontrarPalabra(arreglo.toString());
        String result = "PASS- "+floor+"-"+room+"-"+pass;
        return result;
    }
}
