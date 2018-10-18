package com.esolutions.trainings.jsc2.logic;

import com.esolutions.trainings.jsc2.db.ReservaRepository;
import com.esolutions.trainings.jsc2.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository repository;

    @Autowired
    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public List<Reserva> getReservas() {
        return this.repository.findAll();
    }

    public List<Reserva> validarHabitacionXfecha(LocalDate fechainicio, LocalDate fechasalida, int roomid) {
        return this.repository.findReservas(fechainicio, fechasalida, roomid);
    }

    public String obtenerIdRoom(int floor, int nro) {
        String id = this.repository.buscarRoom(floor, nro);
        return id;
    }

    public String buscarTipoRoom(int floor, int nro) {
        String tipo = this.repository.buscarTipoRoom(floor, nro);
        return tipo;
    }

    public double obtenerPrecio(String tipo, int[] dias) {
        double precio = 0;

        if (tipo.equals("ESTANDAR")) {
            for (int i = 0; i < dias.length; i++) {
                if (isWeekDays(dias[i])) {
                    precio = precio + 150.99;
                }
                else {
                    precio = precio + 191.99;
                }
            }
        }
        if (tipo.equals("SUITE")) {
            for (int i = 0; i < dias.length; i++) {
                if (isWeekDays(dias[i])) {
                    precio = precio + 187.99;
                }
                else {
                    precio = precio + 202.99;
                }
            }
        }
        return precio;
    }
    public void insertReservar(int id, LocalDate fechainicio, LocalDate fechasalida, int roomid){
        this.repository.insertarRoom(id, fechainicio, fechasalida, roomid);
    }

    private boolean isWeekDays(int dia) {
        return 2 <= dia && dia <= 4;
    }
}
