package com.FlightReservation.service;

import com.FlightReservation.Entity.Reservation;
import com.FlightReservation.dto.ReservationRequest;

public interface ReservationService {

	Reservation bookFlight (ReservationRequest reservation);
}
