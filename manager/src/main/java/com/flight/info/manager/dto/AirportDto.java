package com.flight.info.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.flight.info.manager.model.Airport}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirportDto implements Serializable {
    Integer id;
    String airportName;
    String city;
    String country;
    String iataCode;
}
