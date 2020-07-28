package com.example.app.mapper;

import com.example.app.dto.ChannelDto;
import com.example.app.dto.ChannelShortDto;
import com.example.app.entity.Channel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {PostMapper.class})
public interface ChannelMapper {

    ChannelDto toDto(Channel channel);

    @InheritInverseConfiguration
    Channel toEntity(ChannelDto channel);

    List<ChannelDto> toDtoList(List<Channel> list);

    @InheritInverseConfiguration
    List<Channel> toEntityList(List<ChannelDto> list);


    ChannelShortDto toShortDto(Channel channel);

    @InheritInverseConfiguration
    Channel toShortEntity(ChannelShortDto channel);

    List<ChannelShortDto> toShortDtoList(List<Channel> list);

    @InheritInverseConfiguration
    List<Channel> toShortEntityList(List<ChannelShortDto> list);

}
