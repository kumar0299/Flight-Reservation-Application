package com.FlightReservation.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FlightReservation.Entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query("from Flight where departureCity=:from and arrivalCity=:to and dateOfDeparture=:Departuredate")
	List<Flight> findFlight(@Param("from") String from, @Param("to") String to,
			@Param("Departuredate") Date departureDate);

}
