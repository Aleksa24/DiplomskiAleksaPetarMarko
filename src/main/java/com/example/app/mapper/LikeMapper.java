package com.example.app.mapper;

import com.example.app.dto.like.LikeDto;
import com.example.app.dto.like.LikeStatusDto;
import com.example.app.entity.Like;
import com.example.app.entity.LikeStatus;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class, PostMapper.class,CommentMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface LikeMapper {

    LikeDto toDto(Like like);

    @InheritInverseConfiguration
    Like toEntity(LikeDto likeDto);

    List<LikeDto> toDtoList(List<Like> list);

    @InheritInverseConfiguration
    List<Like> toEntityList(List<LikeDto> list);


    LikeStatusDto toStatusDto(LikeStatus likeStatus);

    @InheritInverseConfiguration
    LikeStatus toStatusEntity(LikeStatusDto likeStatusDto);

    List<LikeStatusDto> toStatusDtoList(List<LikeStatus> list);

    @InheritInverseConfiguration
    List<LikeStatus> toStatusEntityList(List<LikeStatusDto> list);

}
