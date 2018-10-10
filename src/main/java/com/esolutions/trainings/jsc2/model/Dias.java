package com.esolutions.trainings.jsc2.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dias {
    public static Date parseDate(String fecha)
    {

        String delimiter = "-";
        String[] temp;
        temp = fecha.split(delimiter);
        String fechaFinal=temp[1]+"/"+temp[2]+"/"+temp[0];
        Date fechaInicial=new Date();
        try
        {
            fechaInicial = new SimpleDateFormat("MM/dd/yyyy").parse(fechaFinal);
        }catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return fechaInicial;

    }
    public static int[] getDiasDeLaSemana(String fechaInicio,String fechaFin)
    {
        //Devuelve los dias de la semana entre dos fechas, siendo lunes=1, martes=2, ... con sabado=7
        int[] retorno=null;
        try
        {
            Date fechaInicial = parseDate(fechaInicio);
            Date fechaFinal = parseDate(fechaFin);
            int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
            retorno = new int[dias];
            for (int i = 0; i < dias; i++) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaInicial);
                calendar.add(Calendar.DAY_OF_YEAR,i);
                Date fecha = calendar.getTime();
                retorno[i]=calendar.get(Calendar.DAY_OF_WEEK);

                System.out.println("La fecha es: " +fecha + " Y el dia de la semana es: "+ calendar.get(Calendar.DAY_OF_WEEK));
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return retorno;

    }
}