package com.example.app.mapper;

import com.example.app.dto.comment.CommentDto;
import com.example.app.dto.comment.CommentShortDto;
import com.example.app.dto.comment.CommentStatusDto;
import com.example.app.entity.Comment;
import com.example.app.entity.CommentStatus;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class, LikeMapper.class, PostMapper.class,
                AttachmentMapper.class, ChannelMapper.class})
public interface CommentMapper {

    CommentDto toDto(Comment comment);

    @InheritInverseConfiguration
    Comment toEntity(CommentDto commentDto);

    List<CommentDto> toDtoList(List<Comment> list);

    @InheritInverseConfiguration
    List<Comment> toEntityList(List<CommentDto> list);


    CommentShortDto toShortDto(Comment comment);

    @InheritInverseConfiguration
    Comment toShortEntity(CommentShortDto commentDto);

    List<CommentShortDto> toShortDtoList(List<Comment> list);

    @InheritInverseConfiguration
    List<Comment> toShortEntityList(List<CommentShortDto> list);

    //CommentStatus:
    CommentStatusDto toCommentStatusDto(CommentStatus commentStatus);

    @InheritInverseConfiguration
    CommentStatus toCommentStatusEntity(CommentStatusDto commentStatusDto);


}
