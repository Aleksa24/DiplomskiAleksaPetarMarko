package com.example.app.mapper;


import com.example.app.dto.UserDto;
import com.example.app.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface PostMapper {

    UserDto toDto(User user);

    @InheritInverseConfiguration
    User toEntity(UserDto userDto);

}
