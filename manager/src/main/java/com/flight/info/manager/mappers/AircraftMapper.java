package com.flight.info.manager.mappers;

import com.flight.info.manager.dto.AircraftDto;
import com.flight.info.manager.model.Aircraft;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AircraftMapper {

    AircraftDto toDto(Aircraft aircraft);

    Aircraft toEntity(AircraftDto dto);

    @Mapping(target = "id", ignore = true)
    Aircraft partialUpdate(AircraftDto dto, @MappingTarget Aircraft aircraft);
}
