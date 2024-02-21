package com.flight.info.manager.service.impl;

import com.flight.info.manager.dto.AirportDto;
import com.flight.info.manager.exceptions.NotFoundException;
import com.flight.info.manager.mappers.AirportMapper;
import com.flight.info.manager.model.Airport;
import com.flight.info.manager.repository.AirportRepository;
import com.flight.info.manager.service.AirportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    public static final String AIRPORT_NOT_FOUND_EXCEPTION = "Airport with id=%s not found";

    private final AirportMapper airportMapper;
    private final AirportRepository airportRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AirportDto> findAllAirports() {
        return airportRepository.findAll().stream().map(airportMapper::toDto).toList();
    }

    @Override
    @Transactional
    public AirportDto addAirport(AirportDto dto) {
        Airport entity = airportMapper.toEntity(dto);
        airportRepository.save(entity);
        return airportMapper.toDto(entity);
    }

    @Override
    @Transactional
    public AirportDto updateAirport(AirportDto dto) {
        return airportRepository.findById(dto.getId()).map(airport -> {
            Airport updatedAirport = airportRepository.save(airportMapper.partialUpdate(dto, airport));
            return airportMapper.toDto(updatedAirport);
        }).orElseThrow(() -> new NotFoundException(dto.getId().toString(), AIRPORT_NOT_FOUND_EXCEPTION));
    }

    @Override
    @Transactional
    public void deleteAirport(Integer airportId) {
        airportRepository.deleteById(airportId);
    }

    @Override
    @Transactional(readOnly = true)
    public AirportDto findAirport(Integer airportId) {
        return airportRepository.findById(airportId)
            .map(airportMapper::toDto)
            .orElseThrow(() -> new NotFoundException(airportId.toString(), AIRPORT_NOT_FOUND_EXCEPTION));
    }
}
