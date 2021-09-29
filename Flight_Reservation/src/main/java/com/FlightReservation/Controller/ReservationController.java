package com.FlightReservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FlightReservation.Entity.Reservation;
import com.FlightReservation.dto.ReservationRequest;
import com.FlightReservation.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/completeReservation")
	public String completeReservation(ReservationRequest reservation, ModelMap ModelMap) {
		Reservation reservationId = reservationService.bookFlight(reservation);
		ModelMap.addAttribute("reservationId", reservationId.getId());
	
		return "login/confirmReservation";
	}
}
