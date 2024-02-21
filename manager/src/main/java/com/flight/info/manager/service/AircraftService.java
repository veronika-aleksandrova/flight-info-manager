package com.flight.info.manager.service;

import com.flight.info.manager.dto.AircraftDto;

import java.util.List;

public interface AircraftService {
    List<AircraftDto> findAllAircrafts();

    AircraftDto findAircraft(Integer aircraftId);

    AircraftDto addAircraft(AircraftDto dto);

    void deleteAircraft(Integer aircraftId);

    AircraftDto updateAircraft(AircraftDto dto);
}
