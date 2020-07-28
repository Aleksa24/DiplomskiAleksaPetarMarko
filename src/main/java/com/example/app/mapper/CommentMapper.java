package com.example.app.mapper;

import com.example.app.dto.CommentDto;
import com.example.app.entity.Comment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CommentStatusMapper.class,LikeMapper.class,
                AttachmentMapper.class,UserMapper.class})
public abstract class CommentMapper {

    private final CommentStatusMapper commentStatusMapper;
    private final LikeMapper likeMapper;
    private final AttachmentMapper attachmentMapper;
    private final UserMapper userMapper;

    @Autowired
    protected CommentMapper(CommentStatusMapper commentStatusMapper,
                            LikeMapper likeMapper,
                            AttachmentMapper attachmentMapper,
                            UserMapper userMapper) {
        this.commentStatusMapper = commentStatusMapper;
        this.likeMapper = likeMapper;
        this.attachmentMapper = attachmentMapper;
        this.userMapper = userMapper;
    }

    abstract CommentDto toDto(Comment comment);

    @InheritInverseConfiguration
    abstract Comment toEntity(CommentDto comment);

    abstract List<CommentDto> toDtoList(List<Comment> list);

    @InheritInverseConfiguration
    abstract List<Comment> toEntityList(List<CommentDto> list);

}
