package com.example.app.mapper;

import com.example.app.dto.user.UserDto;
import com.example.app.dto.user.UserPermissionDto;
import com.example.app.dto.user.UserRoleDto;
import com.example.app.dto.user.UserShortDto;
import com.example.app.entity.User;
import com.example.app.entity.UserPermission;
import com.example.app.entity.UserRole;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PostMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserDto toDto(User user);

    @InheritInverseConfiguration
    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> list);

    @InheritInverseConfiguration
    List<User> toEntityList(List<UserDto> list);

    UserRoleDto toUserRoleDto(UserRole userRole);

    @InheritInverseConfiguration
    UserRole toUserRoleEntity(UserRoleDto userRoleDto);

    UserPermissionDto toUserPermissionDto(UserPermission userPermission);

    @InheritInverseConfiguration
    UserPermission toUserPermissionEntity(UserPermissionDto userPermissionDto);


    List<UserPermissionDto> toUserPermissionDtoList(List<UserPermission> list);

    @InheritInverseConfiguration
    List<UserPermission> toUserPermissionEntityList(List<UserPermissionDto> list);

    UserShortDto toShortDto(User user);

    @InheritInverseConfiguration
    User toShortEntity(UserShortDto user);

    List<UserShortDto> toShortDtoList(List<User> list);

    @InheritInverseConfiguration
    List<User> toShortEntityList(List<UserShortDto> list);

}
