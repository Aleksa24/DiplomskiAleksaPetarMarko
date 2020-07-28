package com.example.app.mapper;

import com.example.app.dto.ChannelRoleDto;
import com.example.app.entity.ChannelRole;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChannelRoleMapper {

    ChannelRoleDto toDto(ChannelRole channelRole);

    @InheritInverseConfiguration
    ChannelRole toEntity(ChannelRoleDto channelRole);

    List<ChannelRoleDto> toDtoList(List<ChannelRole> list);

    @InheritInverseConfiguration
    List<ChannelRole> toEntityList(List<ChannelRoleDto> list);
}
