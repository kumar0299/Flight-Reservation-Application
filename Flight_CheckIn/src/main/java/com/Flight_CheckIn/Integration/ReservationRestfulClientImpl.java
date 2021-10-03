package com.Flight_CheckIn.Integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.Flight_CheckIn.Integration.dto.Reservation;

@Component
public class ReservationRestfulClientImpl implements ReservationRestfulClient {

	@Override
	public Reservation findReservation(int id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject("http://localhost:8080/flights/Reservation/" + id,
				Reservation.class);
		return reservation;
	}

}
