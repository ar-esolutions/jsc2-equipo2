package com.esolutions.trainings.jsc2.logic;

import com.esolutions.trainings.jsc2.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public class ReservaService {
    private final JpaRepository<Reserva, Long> repository;

    @Autowired
    public ReservaService(JpaRepository<Reserva, Long> repository) {
        this.repository = repository;
    }

    public void alphabeticallySortedRepeatedGuestsByLastName() {
        final List<Reserva> allReservations = this.repository.findAll();
    }

    public Reserva getReserva(long id, Date fechaInicio, Date fechaFinal)
    {
        return new Reserva();
        //return List <Reserva> reservasRango = this.repository.findByStartDateAndEndDate();
    }
}
