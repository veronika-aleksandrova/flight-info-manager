package com.flight.info.manager.mappers;

import com.flight.info.manager.dto.AirportDto;
import com.flight.info.manager.model.Airport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AirportMapper {
    AirportDto toDto(Airport airport);

    Airport toEntity(AirportDto dto);

    @Mapping(target = "id", ignore = true)
    Airport partialUpdate(AirportDto dto, @MappingTarget Airport airport);
}
