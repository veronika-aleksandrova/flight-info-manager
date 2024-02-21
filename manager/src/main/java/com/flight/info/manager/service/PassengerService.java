package com.flight.info.manager.service;

import com.flight.info.manager.dto.PassengerDto;

import java.util.List;

public interface PassengerService {
    PassengerDto updatePassenger(Integer id, PassengerDto dto);

    void deletePassenger(Integer passengerId);

    PassengerDto addPassenger(PassengerDto dto);

    PassengerDto findPassenger(Integer passengerId);

    List<PassengerDto> findAllPassengers();
}
