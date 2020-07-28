package com.example.app.mapper;

import com.example.app.dto.UserChannelDto;
import com.example.app.entity.UserChannel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class,ChannelRoleMapper.class})
public abstract class UserChannelMapper {

    private final UserMapper userMapper;
    private final ChannelRoleMapper channelRoleMapper;

    @Autowired
    protected UserChannelMapper(UserMapper userMapper, ChannelRoleMapper channelRoleMapper) {
        this.userMapper = userMapper;
        this.channelRoleMapper = channelRoleMapper;
    }

    @Mapping(target = "id",source = "id")
    @Mapping(target = "dateJoined",source = "dateJoined")
    @Mapping(target = "channelRole",source = "channelRole")
    @Mapping(target = "user",source = "user")
    abstract UserChannelDto toDto(UserChannel userChannel);

    @InheritInverseConfiguration
    abstract UserChannel toEntity(UserChannelDto userChannel);

    abstract List<UserChannelDto> toDtoList(List<UserChannel> list);

    @InheritInverseConfiguration
    abstract  List<UserChannel> toEntityList(List<UserChannelDto> list);
}
