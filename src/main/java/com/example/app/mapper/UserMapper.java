package com.example.app.mapper;

import com.example.app.dto.UserDto;
import com.example.app.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserDto toDto(User user);

    @InheritInverseConfiguration
    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> list);

    @InheritInverseConfiguration
    List<User> toEntityList(List<UserDto> list);

}
