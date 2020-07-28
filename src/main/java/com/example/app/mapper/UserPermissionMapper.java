package com.example.app.mapper;

import com.example.app.dto.UserPermissionDto;
import com.example.app.entity.UserPermission;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserPermissionMapper {

    UserPermissionDto toDto(UserPermission userPermission);

    @InheritInverseConfiguration
    UserPermission toEntity(UserPermissionDto userPermission);

    List<UserPermissionDto> toDtoList(List<UserPermission> list);

    @InheritInverseConfiguration
    List<UserPermission> toEntityList(List<UserPermissionDto> list);
}
