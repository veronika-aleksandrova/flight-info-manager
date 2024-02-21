package com.flight.info.manager.service.impl;

import com.flight.info.manager.dto.PassengerDto;
import com.flight.info.manager.exceptions.NotFoundException;
import com.flight.info.manager.mappers.PassengerMapper;
import com.flight.info.manager.model.Passenger;
import com.flight.info.manager.repository.PassengerRepository;
import com.flight.info.manager.service.PassengerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    public static final String PASSENGER_NOT_FOUND_EXCEPTION = "Passenger with id=%s not found";

    private final PassengerMapper passengerMapper;
    private final PassengerRepository passengerRepository;

    @Override
    @Transactional
    public PassengerDto updatePassenger(Integer id, PassengerDto dto) {
        return passengerRepository.findById(id).map(passenger -> {
            Passenger updatedPassenger = passengerRepository.save(passengerMapper.partialUpdate(dto, passenger));
            return passengerMapper.toDto(updatedPassenger);
        }).orElseThrow(() -> new NotFoundException(id.toString(), PASSENGER_NOT_FOUND_EXCEPTION));
    }

    @Override
    @Transactional
    public void deletePassenger(Integer passengerId) {
        passengerRepository.deleteById(passengerId);
    }

    @Override
    @Transactional
    public PassengerDto addPassenger(PassengerDto dto) {
        Passenger entity = passengerMapper.toEntity(dto);
        passengerRepository.save(entity);
        return passengerMapper.toDto(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public PassengerDto findPassenger(Integer passengerId) {
        return passengerRepository.findById(passengerId)
            .map(passengerMapper::toDto)
            .orElseThrow(() -> new NotFoundException(passengerId.toString(), PASSENGER_NOT_FOUND_EXCEPTION));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PassengerDto> findAllPassengers() {
        return passengerRepository.findAll().stream().map(passengerMapper::toDto).toList();
    }
}
