package com.FlightReservation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FlightReservation.Entity.Flight;
import com.FlightReservation.Entity.Passenger;
import com.FlightReservation.Entity.Reservation;
import com.FlightReservation.Repository.FlightRepository;
import com.FlightReservation.Repository.PassengerRepository;
import com.FlightReservation.Repository.ReservationRepository;
import com.FlightReservation.Utilities.EmailSender;
import com.FlightReservation.Utilities.PdfGenerator;
import com.FlightReservation.dto.ReservationRequest;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private PassengerRepository passengerRepo;

	@Autowired
	private FlightRepository flightRepo;

	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private EmailSender email;

	@Override
	public Reservation bookFlight(ReservationRequest reservation) {

		String filePath = "C:/Users/Manjeet Kumar/git/Flight-Reservation-Application/Flight_Reservation/src/ticket/booking";

		Passenger passenger = new Passenger();
		passenger.setFirstName(reservation.getFirstName());
		passenger.setLastName(reservation.getLastName());
		passenger.setMiddleName(reservation.getMiddleName());
		passenger.setEmail(reservation.getEmail());
		passenger.setPhone(reservation.getPhone());
		passengerRepo.save(passenger);

		int flightId = reservation.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();

		Reservation reserve = new Reservation();
		reserve.setFlight(flight);
		reserve.setPassenger(passenger);
		reserve.setCheckedIn(false);
		reserve.setNumberOfBags(0);
		reservationRepo.save(reserve);

		PdfGenerator pdf = new PdfGenerator();
		pdf.generatePdf(filePath + reserve.getId() + ".pdf", reservation.getFirstName(), reservation.getEmail(),
				reservation.getPhone(), flight.getOperatingAirlines(), flight.getEstimatedDepartureTime(),
				flight.getDepartureCity(), flight.getArrivalCity());
		
		
		String attachment = filePath + reserve.getId()+".pdf";
		email.sendEmail(reservation.getEmail(),attachment);
		
		return reserve;
	}

}
