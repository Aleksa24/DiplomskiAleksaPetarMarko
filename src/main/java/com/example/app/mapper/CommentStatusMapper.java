package com.example.app.mapper;

import com.example.app.dto.CommentStatusDto;
import com.example.app.entity.CommentStatus;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentStatusMapper {

    CommentStatusDto toDto(CommentStatus status);

    @InheritInverseConfiguration
    CommentStatus toEntity(CommentStatusDto status);

    List<CommentStatusDto> toDtoList(List<CommentStatus> list);

    @InheritInverseConfiguration
    List<CommentStatus> toEntityList(List<CommentStatusDto> list);
}
