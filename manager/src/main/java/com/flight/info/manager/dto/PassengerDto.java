package com.flight.info.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.flight.info.manager.model.Passenger}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class PassengerDto implements Serializable {
    Integer id;
    @NotNull @Size(min = 3) @NotBlank String firstName;
    @NotNull @Size(min = 3) @NotBlank String lastName;
    @Email String emailAddress;
    @Size(min = 3) String phoneNumber;
}
