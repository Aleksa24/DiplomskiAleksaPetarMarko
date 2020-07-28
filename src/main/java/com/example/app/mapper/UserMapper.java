package com.example.app.mapper;

import com.example.app.dto.UserDto;
import com.example.app.dto.UserPermissionDto;
import com.example.app.dto.UserRoleDto;
import com.example.app.entity.User;
import com.example.app.entity.UserPermission;
import com.example.app.entity.UserRole;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract UserDto toDto(User user);

    @InheritInverseConfiguration
    public abstract User toEntity(UserDto userDto);

    public abstract List<UserDto> toDtoList(List<User> list);

    @InheritInverseConfiguration
    public abstract List<User> toEntityList(List<UserDto> list);

    public abstract UserRoleDto toUserRoleDto(UserRole userRole);

    @InheritInverseConfiguration
    public abstract UserRole toUserRoleEntity(UserRoleDto userRoleDto);

    public abstract UserPermissionDto toUserPermissionDto(UserPermission userPermission);

    @InheritInverseConfiguration
    public abstract UserPermission toUserPermissionEntity(UserPermissionDto userPermissionDto);


    public abstract List<UserPermissionDto> toUserPermissionDtoList(List<UserPermission> list);

    @InheritInverseConfiguration
    public abstract List<UserPermission> toUserPermissionEntityList(List<UserPermissionDto> list);

}
