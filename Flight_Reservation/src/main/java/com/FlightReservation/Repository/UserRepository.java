package com.FlightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightReservation.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
