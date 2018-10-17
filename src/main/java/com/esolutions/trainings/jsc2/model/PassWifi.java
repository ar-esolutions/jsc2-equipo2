package com.esolutions.trainings.jsc2.model;

import java.util.ArrayList;

public class PassWifi {

    private StringBuilder arreglo;

    private void getCadena(int tamaño)
    {
        arreglo = new StringBuilder("J");
        boolean primero = true;
        StringBuilder auxiliar = new StringBuilder();

        char letra;
        for (int i = 0; i < tamaño; i++) {
            auxiliar = new StringBuilder();
            for (int j = 0; j < arreglo.length(); j++) {
                letra=arreglo.charAt(j);
                switch(letra)
                {
                    case 'J':
                        auxiliar.append("J");
                        auxiliar.append("A");
                        break;
                    case 'A':
                        auxiliar.append("V");
                        auxiliar.append("A");
                        break;
                    case 'V':
                        auxiliar.append("V");
                        auxiliar.append("J");
                        break;
                    default :
                        break;
                }

            }

            arreglo = auxiliar;
        }
    }

    public String pruebaPass(int floor, int room)
    {
        int contador=0;
        this.getCadena(floor+room);
        for (int i = 0; i < arreglo.length(); i++) {
            if(arreglo.charAt(i)=='J')
            {
                if(arreglo.charAt(i+1)=='A')
                {
                    if(arreglo.charAt(i+2)=='V')
                    {
                        if(arreglo.charAt(i+3)=='A')
                        {
                            contador++;
                            i+=3;
                        }
                        else
                        {
                            i+=2;
                        }
                    }
                    else
                    {
                        i++;
                    }
                }
            }
        }
        return "PASS "+floor+"-"+room+"-"+contador;
    }
}
