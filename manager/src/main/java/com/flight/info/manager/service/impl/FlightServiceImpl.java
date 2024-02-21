package com.flight.info.manager.service.impl;

import com.flight.info.manager.dto.FlightDto;
import com.flight.info.manager.exceptions.NotFoundException;
import com.flight.info.manager.mappers.FlightMapper;
import com.flight.info.manager.model.Flight;
import com.flight.info.manager.repository.FlightsRepository;
import com.flight.info.manager.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    public static final String FLIGHT_NOT_FOUND_EXCEPTION = "Flight with id=%s not found";

    private final FlightMapper flightMapper;
    private final FlightsRepository flightsRepository;

    @Override
    @Transactional
    public FlightDto addFlight(FlightDto dto) {
        Flight entity = flightMapper.toEntity(dto);
        flightsRepository.save(entity);
        return flightMapper.toDto(entity);
    }

    @Override
    @Transactional
    public void deleteFlight(Integer flightId) {
        flightsRepository.deleteById(flightId);
    }

    @Override
    @Transactional
    public FlightDto updateFlight(FlightDto dto) {
        return flightsRepository.findById(dto.getId()).map(flight -> {
            Flight updatedFlight = flightsRepository.save(flightMapper.partialUpdate(dto, flight));
            return flightMapper.toDto(updatedFlight);
        }).orElseThrow(() -> new NotFoundException(dto.getId().toString(), FLIGHT_NOT_FOUND_EXCEPTION));
    }

    @Override
    @Transactional(readOnly = true)
    public FlightDto findFlight(Integer flightId) {
        return flightsRepository.findById(flightId)
            .map(flightMapper::toDto)
            .orElseThrow(() -> new NotFoundException(flightId.toString(), FLIGHT_NOT_FOUND_EXCEPTION));
    }

    @Override
    @Transactional(readOnly = true)
    public List<FlightDto> findAllFlights() {
        return flightsRepository.findAll().stream().map(flightMapper::toDto).toList();
    }
}
