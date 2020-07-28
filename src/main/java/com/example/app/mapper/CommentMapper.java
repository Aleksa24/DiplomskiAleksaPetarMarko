package com.example.app.mapper;

import com.example.app.dto.*;
import com.example.app.entity.Comment;
import com.example.app.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class,LikeMapper.class})
public interface CommentMapper {
    CommentDto toDto(Comment comment);

    @InheritInverseConfiguration
    Comment toEntity(CommentDto commentDto);

    List<CommentDto> toDtoList(List<Comment> list);

    @InheritInverseConfiguration
    List<Comment> toEntityList(List<CommentDto> list);


}
