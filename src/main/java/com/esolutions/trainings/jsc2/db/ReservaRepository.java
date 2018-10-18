package com.esolutions.trainings.jsc2.db;

import com.esolutions.trainings.jsc2.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query(value = "SELECT * FROM RESERVAS", nativeQuery = true)
    List<Reserva> findAll();

    @Query(value = "SELECT * FROM RESERVAS WHERE FECHAINICIO BETWEEN :FECHAINICIO AND :FECHASALIDA AND ROOMID = :ROOMID", nativeQuery = true)
    List<Reserva> findReservas(@Param("FECHAINICIO") LocalDate fechainicio,
                               @Param("FECHASALIDA") LocalDate fechasalida,
                               @Param("ROOMID") int roomid);

    @Query(value = "SELECT ID FROM ROOMS WHERE FLOOR = :IDFLOOR AND NRO = :NRO", nativeQuery = true)
    String buscarRoom(@Param("IDFLOOR") int idfloor,
                      @Param("NRO") int nro);

    @Query(value = "SELECT type FROM ROOMS WHERE FLOOR = :IDFLOOR AND NRO = :NRO", nativeQuery = true)
    String buscarTipoRoom(@Param("IDFLOOR") int idfloor,
                          @Param("NRO") int nro);
    @Modifying
    @Query(value="INSERT INTO RESERVAS VALUES(:ID, :FECHAINICIO, :FECHASALIDA, :ROOMID)", nativeQuery = true)
    @Transactional
    void insertarRoom(@Param("ID") int id,
                     @Param("FECHAINICIO") LocalDate fechainicion,
                     @Param("FECHASALIDA") LocalDate fechasalida,
                     @Param("ROOMID") int roomid);
}


