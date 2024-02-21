package com.flight.info.manager.service.impl;

import com.flight.info.manager.dto.AircraftDto;
import com.flight.info.manager.exceptions.NotFoundException;
import com.flight.info.manager.mappers.AircraftMapper;
import com.flight.info.manager.model.Aircraft;
import com.flight.info.manager.repository.AircraftRepository;
import com.flight.info.manager.service.AircraftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {

    public static final String AIRCRAFT_NOT_FOUND_EXCEPTION = "Aircraft with id=%s not found";

    private final AircraftRepository aircraftRepository;
    private final AircraftMapper aircraftMapper;

    @Override
    @Transactional(readOnly = true)
    public List<AircraftDto> findAllAircrafts() {
        return aircraftRepository.findAll().stream().map(aircraftMapper::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public AircraftDto findAircraft(Integer aircraftId) {
        return aircraftRepository.findById(aircraftId)
            .map(aircraftMapper::toDto)
            .orElseThrow(() -> new NotFoundException(aircraftId.toString(), AIRCRAFT_NOT_FOUND_EXCEPTION));
    }

    @Override
    @Transactional
    public AircraftDto addAircraft(AircraftDto dto) {
        Aircraft entity = aircraftMapper.toEntity(dto);
        aircraftRepository.save(entity);
        return aircraftMapper.toDto(entity);
    }

    @Override
    @Transactional
    public void deleteAircraft(Integer aircraftId) {
        aircraftRepository.deleteById(aircraftId);
    }

    @Override
    @Transactional
    public AircraftDto updateAircraft(AircraftDto dto) {
        return aircraftRepository.findById(dto.getId()).map(aircraft -> {
            Aircraft updatedAircraft = aircraftRepository.save(aircraftMapper.partialUpdate(dto, aircraft));
            return aircraftMapper.toDto(updatedAircraft);
        }).orElseThrow(() -> new NotFoundException(dto.getId().toString(), AIRCRAFT_NOT_FOUND_EXCEPTION));
    }
}
