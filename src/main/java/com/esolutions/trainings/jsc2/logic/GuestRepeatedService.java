package com.esolutions.trainings.jsc2.logic;

import com.esolutions.trainings.jsc2.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.esolutions.trainings.jsc2.db.GuestRepository;
import java.util.List;

@Service
public class GuestRepeatedService {
	private final GuestRepository repository;

	@Autowired
	public GuestRepeatedService(GuestRepository repository) {
		this.repository = repository;
	}

	public String[] obtenerRepetidos() {
		return this.repository.obtenerRepetidos();
	}

	public String[] obtenerDatosGuests() { return this.repository.obtenerDatosGuests();};
}
