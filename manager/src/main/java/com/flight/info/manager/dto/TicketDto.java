package com.flight.info.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.flight.info.manager.model.Ticket}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketDto implements Serializable {
    Integer id;
    PassengerDto passenger;
    FlightDto flight;
    String seatNumber;
    LocalDate purchaseDate;
    BigDecimal purchasePrice;
}
