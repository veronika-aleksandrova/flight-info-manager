package com.flight.info.manager.repository;

import com.flight.info.manager.model.Passenger;
import com.flight.info.manager.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findAllByPassenger(Passenger passenger);
}
