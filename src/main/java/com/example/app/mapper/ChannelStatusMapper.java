package com.example.app.mapper;

import com.example.app.dto.ChannelStatusDto;
import com.example.app.entity.ChannelStatus;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChannelStatusMapper {

    ChannelStatusDto toDto(ChannelStatus status);

    @InheritInverseConfiguration
    ChannelStatus toEntity(ChannelStatusDto status);

    List<ChannelStatusDto> toDtoList(List<ChannelStatus> list);

    @InheritInverseConfiguration
    List<ChannelStatus> toEntityList(List<ChannelStatusDto> list);
}
