package com.esolutions.trainings.jsc2.web;

import com.esolutions.trainings.jsc2.db.GuestRepository;
import com.esolutions.trainings.jsc2.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @Autowired
    private GuestRepository guestRepository;

    @GetMapping(value = "/floors/{floor}/rooms/{room}")
    public GuestResponse getGuestNumber(@PathVariable int floor, @PathVariable int room){

        try
        {
            Hotel hotel = new Hotel();
            int guestNumber = hotel.getHotel().get(floor).getRooms().get(room);

            return new GuestResponse(guestNumber);
        }
        catch(IndexOutOfBoundsException e)
        {
            return new GuestResponse(0);
        }

    }

}
