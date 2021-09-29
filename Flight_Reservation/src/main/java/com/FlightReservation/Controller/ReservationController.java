package com.FlightReservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FlightReservation.dto.ReservationRequest;
import com.FlightReservation.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/completeReservation")
	public String completeReservation(ReservationRequest reservation) {
		reservationService.bookFlight(reservation);
		return "";
	}
}
