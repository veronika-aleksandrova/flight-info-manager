package com.flight.info.manager.service;

import com.flight.info.manager.dto.FlightDto;

import java.util.List;

public interface FlightService {
    FlightDto addFlight(FlightDto dto);

    void deleteFlight(Integer flightId);

    FlightDto updateFlight(FlightDto dto);

    FlightDto findFlight(Integer flightId);

    List<FlightDto> findAllFlights();
}
