package com.flight.info.manager.service;

import com.flight.info.manager.dto.TicketDto;

import java.util.List;

public interface TicketService {
    TicketDto addTicket(TicketDto dto);

    List<TicketDto> findTickets(Integer passengerId);

    List<TicketDto> findAllTickets();

    void deleteTicket(Integer ticketId);

    TicketDto updateTicket(TicketDto dto);
}
