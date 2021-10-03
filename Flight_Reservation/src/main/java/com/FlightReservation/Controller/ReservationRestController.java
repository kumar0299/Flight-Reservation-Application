package com.FlightReservation.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FlightReservation.Entity.Reservation;
import com.FlightReservation.Repository.ReservationRepository;
import com.FlightReservation.dto.ReservationUpdateRequest;

@RestController

public class ReservationRestController {

	@Autowired
	private ReservationRepository reservationRepo;
	
	@RequestMapping("/Reservation/{id}")
	public Reservation findReservation(@PathVariable("id") int id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}
	
	@RequestMapping("/Reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Optional<Reservation> findById = reservationRepo.findById(request.getId());
		Reservation reservation = findById.get();
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		return reservationRepo.save(reservation);
	}
}
