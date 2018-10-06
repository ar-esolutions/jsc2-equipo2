package com.esolutions.trainings.jsc2.db;

import com.esolutions.trainings.jsc2.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByStartDateBetween(Date startDate, Date endDate);
}

