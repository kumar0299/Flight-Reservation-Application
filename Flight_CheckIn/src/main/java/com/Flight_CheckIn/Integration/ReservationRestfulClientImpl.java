package com.Flight_CheckIn.Integration;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.Flight_CheckIn.Integration.dto.Reservation;
import com.Flight_CheckIn.Integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestfulClientImpl implements ReservationRestfulClient {

	@Override
	public Reservation findReservation(int id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject("http://localhost:8080/flights/Reservation/" + id,
				Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject("http://localhost:8080/flights/Reservation/", request, Reservation.class);
		return reservation;
	}

}
