package com.example.app.mapper;

import com.example.app.dto.UserDto;
import com.example.app.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserRoleMapper.class,PostMapper.class})
public abstract class UserMapper {

    private final UserRoleMapper userRoleMapper;
    private final PostMapper postMapper;

    @Autowired
    protected UserMapper(UserRoleMapper userRoleMapper, PostMapper postMapper) {
        this.userRoleMapper = userRoleMapper;
        this.postMapper = postMapper;
    }

    abstract UserDto toDto(User user);

    @InheritInverseConfiguration
    abstract User toEntity(UserDto userDto);

    abstract List<UserDto> toDtoList(List<User> list);

    @InheritInverseConfiguration
    abstract List<User> toEntityList(List<UserDto> list);

}
