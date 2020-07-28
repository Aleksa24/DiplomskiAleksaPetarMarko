package com.example.app.mapper;


import com.example.app.dto.PostDto;
import com.example.app.dto.PostShortDto;
import com.example.app.dto.UserDto;
import com.example.app.entity.Post;
import com.example.app.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class,ChannelMapper.class})
public interface PostMapper {

    PostDto toDto(Post post);

    @InheritInverseConfiguration
    Post toEntity(PostDto  postDto);

    List<PostDto> toDtoList(List<Post> list);

    @InheritInverseConfiguration
    List<Post> toEntityList(List<PostDto> list);


    PostShortDto toShortDto(Post post);

    @InheritInverseConfiguration
    Post toShortEntity(PostShortDto  postDto);

    List<PostShortDto> toShortDtoList(List<Post> list);

    @InheritInverseConfiguration
    List<Post> toShortEntityList(List<PostShortDto> list);

}