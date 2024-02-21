package com.flight.info.manager.repository;

import com.flight.info.manager.model.Flight;
import com.flight.info.manager.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepository extends JpaRepository<Flight, Integer> {
}
