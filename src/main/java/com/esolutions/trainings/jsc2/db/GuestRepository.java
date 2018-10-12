package com.esolutions.trainings.jsc2.db;

import com.esolutions.trainings.jsc2.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    @Query(value="SELECT SUBSTR(NAME,0,INSTR(NAME,',') -1) FROM GUESTS GROUP BY SUBSTR(NAME,0,INSTR(NAME,',') -1) HAVING COUNT(*) > 1 ORDER BY 1" , nativeQuery = true)
    String[] obtenerRepetidos();

    @Query(value="select name from guests", nativeQuery = true)
    String[] obtenerDatosGuests();
}

