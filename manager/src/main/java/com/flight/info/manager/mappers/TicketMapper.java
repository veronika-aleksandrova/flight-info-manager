package com.flight.info.manager.mappers;

import com.flight.info.manager.dto.TicketDto;
import com.flight.info.manager.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketMapper {
    TicketDto toDto(Ticket ticket);

    Ticket toEntity(TicketDto dto);

    @Mapping(target = "id", ignore = true)
    Ticket partialUpdate(TicketDto dto, @MappingTarget Ticket ticket);
}
