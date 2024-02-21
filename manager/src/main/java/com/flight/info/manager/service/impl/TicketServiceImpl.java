package com.flight.info.manager.service.impl;

import com.flight.info.manager.dto.TicketDto;
import com.flight.info.manager.exceptions.NotFoundException;
import com.flight.info.manager.mappers.TicketMapper;
import com.flight.info.manager.model.Passenger;
import com.flight.info.manager.model.Ticket;
import com.flight.info.manager.repository.PassengerRepository;
import com.flight.info.manager.repository.TicketRepository;
import com.flight.info.manager.service.PassengerService;
import com.flight.info.manager.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final PassengerRepository passengerRepository;

    public static final String TICKET_NOT_FOUND_EXCEPTION_MESSAGE = "Ticket with id=%s not found";
    public static final String TICKETS_FOR_PASSENGER_NOT_FOUND_EXCEPTION_MESSAGE = "Tickets for passenger with id=%s not found";

    private final TicketMapper ticketMapper;
    private final TicketRepository ticketRepository;

    @Override
    @Transactional
    public TicketDto addTicket(TicketDto dto) {
        Ticket entity = ticketMapper.toEntity(dto);
        ticketRepository.save(entity);
        return ticketMapper.toDto(entity);

    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDto> findTickets(Integer passengerId) {
        Passenger passenger = passengerRepository.findById(passengerId)
            .orElseThrow(() -> new NotFoundException(passengerId.toString(), PassengerServiceImpl.PASSENGER_NOT_FOUND_EXCEPTION));

        return ticketRepository.findAllByPassenger(passenger)
            .stream()
            .map(ticketMapper::toDto)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDto> findAllTickets() {
        return ticketRepository.findAll().stream().map(ticketMapper::toDto).toList();
    }

    @Override
    @Transactional
    public void deleteTicket(Integer ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    @Override
    @Transactional
    public TicketDto updateTicket(TicketDto dto) {
        return ticketRepository.findById(dto.getId()).map(ticket -> {
            Ticket updatedTicket = ticketRepository.save(ticketMapper.partialUpdate(dto, ticket));
            return ticketMapper.toDto(updatedTicket);
        }).orElseThrow(() -> new NotFoundException(dto.getId().toString(), TICKET_NOT_FOUND_EXCEPTION_MESSAGE));
    }
}
