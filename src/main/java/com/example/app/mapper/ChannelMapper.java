package com.example.app.mapper;

import com.example.app.dto.channel.*;
import com.example.app.entity.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PostMapper.class})
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


    UserChannelDto toUserChanelDto(UserChannel userChannel);

    @InheritInverseConfiguration
    UserChannel toUserChanelEntity(UserChannelDto userChannelDto);

    List<UserChannelDto> toUserChanelDtoList(List<UserChannel> list);

    @InheritInverseConfiguration
    List<UserChannel> toUserChanelEntityList(List<UserChannelDto> list);


    ChannelRoleDto toChanelRoleDto(ChannelRole channelRole);

    @InheritInverseConfiguration
    ChannelRole toChanelRoleEntity(ChannelRoleDto channelRoleDto);

    List<ChannelRoleDto> toChanelRoleDtoList(List<ChannelRole> list);

    @InheritInverseConfiguration
    List<ChannelRole> toChanelRoleEntityList(List<ChannelRoleDto> list);

    List<CategoryDto> toCategoryDtoList(List<Category> list);

    @InheritInverseConfiguration
    List<Category> toCategoryEntityList(List<CategoryDto> list);

    List<CommunicationDirectionDto> toCommunicationDirectionDtoList(List<CommunicationDirection> list);

    @InheritInverseConfiguration
    List<CommunicationDirection> toCommunicationDirectionEntityList(List<CommunicationDirectionDto> list);

}
