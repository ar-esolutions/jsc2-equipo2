package com.esolutions.trainings.jsc2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

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

    public void imprimir()
    {
        getCadena(6);
        for (int i = 0; i < arreglo.size(); i++) {
            System.out.print(arreglo.get(i));
        }
    }
}
