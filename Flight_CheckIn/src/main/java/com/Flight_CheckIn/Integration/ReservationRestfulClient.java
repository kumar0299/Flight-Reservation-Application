package com.Flight_CheckIn.Integration;

import org.springframework.web.bind.annotation.RequestBody;

import com.Flight_CheckIn.Integration.dto.Reservation;

public interface ReservationRestfulClient {

	public Reservation findReservation(int id);
	//public Reservation updateReservation(@RequestBody ReservationUpdateRequest request);
}
