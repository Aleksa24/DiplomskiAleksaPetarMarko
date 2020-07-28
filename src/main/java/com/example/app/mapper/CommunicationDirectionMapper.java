package com.example.app.mapper;

import com.example.app.dto.CommunicationDirectionDto;
import com.example.app.entity.CommunicationDirection;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommunicationDirectionMapper {
    CommunicationDirectionDto toDto(CommunicationDirection status);

    @InheritInverseConfiguration
    CommunicationDirection toEntity(CommunicationDirectionDto statusDto);

    List<CommunicationDirectionDto> toDtoList(List<CommunicationDirection> list);

    @InheritInverseConfiguration
    List<CommunicationDirection> toEntityList(List<CommunicationDirectionDto> list);
}
