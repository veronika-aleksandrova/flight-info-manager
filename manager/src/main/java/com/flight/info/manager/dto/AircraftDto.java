package com.flight.info.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.flight.info.manager.model.Aircraft}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class AircraftDto implements Serializable {
    Integer id;
    String aircraftType;
    String manufacturer;
    Integer numberOfSeats;
}
