package com.FlightReservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FlightReservation.Entity.User;
import com.FlightReservation.Repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/login")
	public String showLoginPage() {
		return "login/login";
	}
	
	@RequestMapping("/showRegistration")
	public String showReg() {
		return "login/showRegistration";
	}

	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "login/login";
	}
	
	@RequestMapping("/verifylogin")
	public String verifyLogin() {
		
		return "login/findFlights";
	}
}
