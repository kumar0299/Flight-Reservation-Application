package com.FlightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightReservation.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
