package com.FlightReservation.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FlightReservation.Entity.Flight;
import com.FlightReservation.Repository.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	private FlightRepository flightRepo;
	
	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("Departuredate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate) {
		List<Flight> findFlight = flightRepo.findFlight(from, to, departureDate);
		System.out.println(findFlight);
		return "login/displayFlights";
	}
}
