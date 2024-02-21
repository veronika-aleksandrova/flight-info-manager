package com.flight.info.manager.rest;

import com.flight.info.manager.dto.AircraftDto;
import com.flight.info.manager.service.AircraftService;
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
@RequestMapping("api/v1/aircrafts")
@RequiredArgsConstructor
public class AircraftController {

    private final AircraftService aircraftService;

    @GetMapping
    public ResponseEntity<List<AircraftDto>> getAllAircrafts() {
        return ResponseEntity.ok(aircraftService.findAllAircrafts());
    }

    @GetMapping("/{aircraftId}")
    public ResponseEntity<AircraftDto> getAllAircraft(@PathVariable Integer aircraftId) {
        return ResponseEntity.ok(aircraftService.findAircraft(aircraftId));
    }

    @PostMapping
    public ResponseEntity<AircraftDto> addAircraft(@Validated @RequestBody AircraftDto dto) {
        return new ResponseEntity<>(aircraftService.addAircraft(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{aircraftId}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable Integer aircraftId) {
        aircraftService.deleteAircraft(aircraftId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<AircraftDto> updateAircraft(@Validated @RequestBody AircraftDto dto) {
        return ResponseEntity.ok(aircraftService.updateAircraft(dto));
    }
}
