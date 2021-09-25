package com.FlightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightReservation.Entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
