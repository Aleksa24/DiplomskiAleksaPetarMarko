package com.example.app.mapper;

import com.example.app.dto.UserRoleDto;
import com.example.app.entity.UserRole;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserPermissionMapper.class})
public abstract class UserRoleMapper {

    private final UserPermissionMapper userPermissionMapper;

    @Autowired
    protected UserRoleMapper(UserPermissionMapper userPermissionMapper) {
        this.userPermissionMapper = userPermissionMapper;
    }

    abstract UserRoleDto toDto(UserRole userRole);

    @InheritInverseConfiguration
    abstract UserRole toEntity(UserRoleDto UserRole);

    abstract List<UserRoleDto> toDtoList(List<UserRole> list);

    @InheritInverseConfiguration
    abstract List<UserRole> toEntityList(List<UserRoleDto> list);

}
