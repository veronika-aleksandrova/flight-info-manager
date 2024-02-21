package com.flight.info.manager.rest;

import com.flight.info.manager.dto.TicketDto;
import com.flight.info.manager.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Validated
@RequestMapping("api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<TicketDto>> findAllTickets() {
        return ResponseEntity.ok(ticketService.findAllTickets());
    }

    @GetMapping("/{passengerId}")
    public ResponseEntity<List<TicketDto>> findTicket(@PathVariable Integer passengerId) {
        return ResponseEntity.ok(ticketService.findTickets(passengerId));
    }

    @PostMapping
    public ResponseEntity<TicketDto> addTicket(@Validated @RequestBody TicketDto dto) {
        return new ResponseEntity<>(ticketService.addTicket(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Integer ticketId) {
        ticketService.deleteTicket(ticketId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<TicketDto> updateTicket(@Validated @RequestBody TicketDto dto) {
        return ResponseEntity.ok(ticketService.updateTicket(dto));
    }
}
