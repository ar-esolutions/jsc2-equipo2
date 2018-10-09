package com.esolutions.trainings.jsc2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "RESERVAS")
public class Reserva {

    @Id
    private Long id;

    @Column(name = "FECHAINICIO", nullable = false)
    private Date FECHAINICIO;

    @Column(name = "FECHASALIDA", nullable = false)
    private Date FECHASALIDA;

    @Column(name = "ROOMID", nullable = false)
    private int ROOMID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return FECHAINICIO;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.FECHAINICIO = fechaInicio;
    }


    public Date getFechaSalida() {
        return FECHASALIDA;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.FECHASALIDA = fechaSalida;
    }

    public int getRoomId() {
        return ROOMID;
    }

    public void setRoomId(int roomId) {
        this.ROOMID = roomId;
    }

    @Override
    public String toString() {
        return String.format("Reserva [id=%s, fechainicio=%s, fechasalida=%s]", id, FECHAINICIO, FECHASALIDA);
    }
}