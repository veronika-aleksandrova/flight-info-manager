package com.flight.info.manager.mappers;

import com.flight.info.manager.dto.FlightDto;
import com.flight.info.manager.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FlightMapper {

    FlightDto toDto(Flight flight);

    Flight toEntity(FlightDto dto);

    @Mapping(target = "id", ignore = true)
    Flight partialUpdate(FlightDto dto, @MappingTarget Flight flight);
}
