package com.example.app.mapper;

import com.example.app.dto.LikeDto;
import com.example.app.dto.LikeStatusDto;
import com.example.app.dto.UserDto;
import com.example.app.entity.Like;
import com.example.app.entity.LikeStatus;
import com.example.app.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class})
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
