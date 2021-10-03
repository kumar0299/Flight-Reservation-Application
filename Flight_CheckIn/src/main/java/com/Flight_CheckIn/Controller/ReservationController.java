package com.Flight_CheckIn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Flight_CheckIn.Integration.ReservationRestfulClient;
import com.Flight_CheckIn.Integration.dto.Reservation;

@Controller
public class ReservationController {

	@Autowired
	private ReservationRestfulClient restClient; 
	
	@RequestMapping("/startCheckIn")
	public String showCheckIn() {
		return "startCheckIn";
	}
	
	@RequestMapping("/proceedCheckIn")
	public String proceedCheckIn(@RequestParam("id") int id, ModelMap ModelMap) {
		Reservation reservation = restClient.findReservation(id);
		ModelMap.addAttribute("reservation", reservation);
		return "displayReservation";
	}

}
