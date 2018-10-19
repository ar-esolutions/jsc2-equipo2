package com.esolutions.trainings.jsc2.web;

import com.esolutions.trainings.jsc2.http.ReservationResponse;
import com.esolutions.trainings.jsc2.logic.ReservaService;
import com.esolutions.trainings.jsc2.model.Dias;
import com.esolutions.trainings.jsc2.model.Reserva;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ReservaController {
    private final ReservaService service;
    public int cont = 1;
    @Autowired
    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reservas", produces = {"application/JSON"})
    public List allReservas() {
        return this.service.getReservas();
    }


    @RequestMapping(method = {RequestMethod.POST}, path = "/floors/{floor}/rooms/{room}/book", produces = {"application/JSON"})
    @ResponseBody
    public ReservationResponse validar(@PathVariable int room, @PathVariable int floor, @RequestBody Map checkin) throws JsonProcessingException {

        //obtener id room
        String SidRoom = this.service.obtenerIdRoom(floor, room);
        int idRoom = Integer.parseInt(SidRoom);
        ////////////////////////////

        //obtener tipo room
        String tipoRoom = this.service.buscarTipoRoom(floor, room);
        ////////////////////////////
        //procesoCrearJson

        Object[] fechas = checkin.values().toArray();
        ////////////////////////////

        //CREARFECHAS
        String fis = fechas[0].toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fi = LocalDate.parse(fis, formatter);
        String fss = fechas[1].toString();
        LocalDate fs = LocalDate.parse(fss, formatter);
        ////////////////////////////

        //OBTENER PRECIO
        int[] totalDias = Dias.getDiasDeLaSemana(fis, fss);

        double precio = this.service.obtenerPrecio(tipoRoom, totalDias) ;
        /*int precioInt = (int) precio;
        precio = precio/100;*/
        ////////////////////////////

        //MAPEAR FECHAS Y JSON RESPONSE
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        boolean result;
        Map<String, Object> map = new HashMap<String, Object>();
        json = mapper.writeValueAsString(map);
        json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        long numOfDaysBetween = ChronoUnit.DAYS.between(fi, fs);
        List<Reserva> res = new ArrayList<Reserva>();
        res = this.service.validarHabitacionXfecha(fi, fs, idRoom);

        if (res.isEmpty()) {
            result = true;
            this.service.insertReservar(cont, fi ,fs , idRoom  );
            cont++;
        } else {
            result = false;
        }

        ReservationResponse response = new ReservationResponse(result, precio);
//        map.put("booked", result);
//        map.put("price", precio);


        ////////////////////////////

        //retorno del JSon map con el respuesta.
        return response;
    }

    @RequestMapping(method = {RequestMethod.POST}, path = "/fechas", produces = {"application/JSON"})
    @ResponseBody
    public int[] obtenerDiasFechas(@RequestBody Map checkin) throws JsonProcessingException {


        Object[] fechas = checkin.values().toArray();
        ////////////////////////////

        //CREARFECHAS
        String fis = fechas[0].toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fi = LocalDate.parse(fis, formatter);
        String fss = fechas[1].toString();
        LocalDate fs = LocalDate.parse(fss, formatter);
        ////////////////////////////

        //OBTENER PRECIO
        int[] totalDias = Dias.getDiasDeLaSemana(fis, fss);


        return totalDias;
    }


}




