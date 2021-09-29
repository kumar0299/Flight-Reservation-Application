package com.FlightReservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FlightReservation.Entity.Passenger;
import com.FlightReservation.Entity.Reservation;
import com.FlightReservation.Repository.PassengerRepository;
import com.FlightReservation.dto.ReservationRequest;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired PassengerRepository passengerRepo;
	
	@Override
	public Reservation bookFlight(ReservationRequest reservation) {
		Passenger passenger = new Passenger();
		passenger.setFirstName(reservation.getFirstName());
		passenger.setLastName(reservation.getLastName());
		passenger.setMiddleName(reservation.getMiddleName());
		passenger.setEmail(reservation.getEmail());
		passenger.setPhone(reservation.getPhone());
		passengerRepo.save(passenger);
		return null;
	}

}
