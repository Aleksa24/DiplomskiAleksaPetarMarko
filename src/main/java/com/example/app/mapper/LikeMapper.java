package com.example.app.mapper;

import com.example.app.dto.LikeDto;
import com.example.app.entity.Like;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring",uses = {LikeStatusMapper.class})
public abstract class LikeMapper {

    private final LikeStatusMapper likeStatusMapper;

    @Autowired
    protected LikeMapper(LikeStatusMapper likeStatusMapper) {
        this.likeStatusMapper = likeStatusMapper;
    }

    abstract LikeDto toDto(Like like);

    @InheritInverseConfiguration
    abstract Like toEntity(LikeDto likeDto);

    abstract List<LikeDto> toDtoList(List<Like> list);

    @InheritInverseConfiguration
    abstract List<Like> toEntityList(List<LikeDto> list);
}
