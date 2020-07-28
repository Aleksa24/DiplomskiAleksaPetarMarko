package com.example.app.mapper;

import com.example.app.dto.PostDto;
import com.example.app.entity.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class, ChannelMapper.class,
        LikeMapper.class,CommentMapper.class,AttachmentMapper.class})
public abstract class PostMapper {

    private final UserMapper userMapper;
    private final ChannelMapper channelMapper;
    private final LikeMapper likeMapper;
    private final CommentMapper commentMapper;
    private final AttachmentMapper attachmentMapper;

    @Autowired
    protected PostMapper(UserMapper userMapper,
                         ChannelMapper channelMapper,
                         LikeMapper likeMapper,
                         CommentMapper commentMapper,
                         AttachmentMapper attachmentMapper) {
        this.userMapper = userMapper;
        this.channelMapper = channelMapper;
        this.likeMapper = likeMapper;
        this.commentMapper = commentMapper;
        this.attachmentMapper = attachmentMapper;
    }

    abstract PostDto toDto(Post post);

    @InheritInverseConfiguration
    abstract Post toEntity(PostDto post);

    abstract List<PostDto> toDtoList(List<Post> list);

    @InheritInverseConfiguration
    abstract List<Post> toEntityList(List<PostDto> list);

}
