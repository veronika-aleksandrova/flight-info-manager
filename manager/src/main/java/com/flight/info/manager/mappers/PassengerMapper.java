package com.flight.info.manager.mappers;

import com.flight.info.manager.dto.PassengerDto;
import com.flight.info.manager.model.Passenger;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PassengerMapper {
    PassengerDto toDto(Passenger passenger);

    Passenger toEntity(PassengerDto dto);

    @Mapping(target = "id", ignore = true)
    Passenger partialUpdate(PassengerDto dto, @MappingTarget Passenger passenger);
}
