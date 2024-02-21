package com.flight.info.manager.rest;

import com.flight.info.manager.dto.FlightDto;
import com.flight.info.manager.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Validated
@RequestMapping("api/v1/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public ResponseEntity<List<FlightDto>> findAllFlights() {
        return ResponseEntity.ok(flightService.findAllFlights());
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightDto> findFlight(@PathVariable Integer flightId) {
        return ResponseEntity.ok(flightService.findFlight(flightId));
    }

    @PostMapping
    public ResponseEntity<FlightDto> addFlight(@Validated @RequestBody FlightDto dto) {
        return new ResponseEntity<>(flightService.addFlight(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Integer flightId) {
        flightService.deleteFlight(flightId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<FlightDto> updateFlight(@Validated @RequestBody FlightDto dto) {
        return ResponseEntity.ok(flightService.updateFlight(dto));
    }
}
