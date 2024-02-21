package com.flight.info.manager.rest;

import com.flight.info.manager.dto.AirportDto;
import com.flight.info.manager.model.Airport;
import com.flight.info.manager.service.AirportService;
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
@RequestMapping("api/v1/airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping
    public ResponseEntity<List<AirportDto>> getAllAirports() {
        return ResponseEntity.ok(airportService.findAllAirports());
    }

    @GetMapping("/{airportId}")
    public ResponseEntity<AirportDto> getAllAirport(@PathVariable Integer airportId) {
        return ResponseEntity.ok(airportService.findAirport(airportId));
    }

    @PostMapping
    public ResponseEntity<AirportDto> addAirport(@Validated @RequestBody AirportDto dto) {
        return new ResponseEntity<>(airportService.addAirport(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{airportId}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Integer airportId) {
        airportService.deleteAirport(airportId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<AirportDto> updateAirport(@Validated @RequestBody AirportDto dto) {
        return ResponseEntity.ok(airportService.updateAirport(dto));
    }
}
