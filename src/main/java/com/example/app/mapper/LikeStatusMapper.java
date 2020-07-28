package com.example.app.mapper;

import com.example.app.dto.LikeStatusDto;
import com.example.app.entity.LikeStatus;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LikeStatusMapper {

    LikeStatusDto toDto(LikeStatus likeStatus);

    @InheritInverseConfiguration
    LikeStatus toEntity(LikeStatusDto likeStatusDto);

    List<LikeStatusDto> toDtoList(List<LikeStatus> list);

    @InheritInverseConfiguration
    List<LikeStatus> toEntityList(List<LikeStatusDto> list);

}
