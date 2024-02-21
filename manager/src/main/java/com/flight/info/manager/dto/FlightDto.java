package com.flight.info.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.flight.info.manager.model.Flight}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightDto implements Serializable {
    Integer id;
    String flightNumber;
    AirportDto departureAirport;
    AirportDto arrivalAirport;
    LocalDate departureTime;
    LocalDate arrivalTime;
    AircraftDto aircraft;
    BigDecimal baseFare;
}
