package com.flight.info.manager.service;

import com.flight.info.manager.dto.AirportDto;

import java.util.List;

public interface AirportService {
    List<AirportDto> findAllAirports();

    AirportDto addAirport(AirportDto dto);

    AirportDto updateAirport(AirportDto dto);

    void deleteAirport(Integer airportId);

    AirportDto findAirport(Integer airportId);
}
