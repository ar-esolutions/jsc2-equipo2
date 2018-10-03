package com.esolutions.trainings.jsc2.db;

import com.esolutions.trainings.jsc2.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
