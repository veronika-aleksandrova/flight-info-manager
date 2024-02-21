package com.flight.info.manager.rest;

import com.flight.info.manager.dto.PassengerDto;
import com.flight.info.manager.service.PassengerService;
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
@RequestMapping("api/v1/passengers")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;

    @GetMapping
    public ResponseEntity<List<PassengerDto>> findAllPassengers() {
        return ResponseEntity.ok(passengerService.findAllPassengers());
    }

    @GetMapping("/{passengerId}")
    public ResponseEntity<PassengerDto> findPassenger(@PathVariable Integer passengerId) {
        return ResponseEntity.ok(passengerService.findPassenger(passengerId));
    }

    @PostMapping
    public ResponseEntity<PassengerDto> addPassenger(@Validated @RequestBody PassengerDto dto) {
        return new ResponseEntity<>(passengerService.addPassenger(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{passengerId}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Integer passengerId) {
        passengerService.deletePassenger(passengerId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerDto> updatePassenger(@PathVariable Integer id, @Validated @RequestBody PassengerDto dto) {
        return ResponseEntity.ok(passengerService.updatePassenger(id, dto));
    }
}
