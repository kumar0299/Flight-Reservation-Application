package com.FlightReservation.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FlightReservation.Entity.Flight;
import com.FlightReservation.Repository.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	private FlightRepository flightRepo;
	
	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("Departuredate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,ModelMap ModelMap) {
		List<Flight> findFlight = flightRepo.findFlight(from, to, departureDate);
		ModelMap.addAttribute("findFlight", findFlight);
		return "login/displayFlights";
	}
	
	@RequestMapping("/ShowCompleteReservation")
	public String ShowCompleteReservation(@RequestParam("flightId") Integer id, ModelMap ModelMap) {
		Optional<Flight> findById = flightRepo.findById(id);
		Flight flight = findById.get();
		ModelMap.addAttribute("flight", flight);
		return "login/showReservation";
	}
}
