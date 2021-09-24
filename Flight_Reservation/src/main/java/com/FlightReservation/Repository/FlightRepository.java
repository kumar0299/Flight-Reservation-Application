package com.FlightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightReservation.Entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
