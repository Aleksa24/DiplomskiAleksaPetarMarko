package com.example.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Long id;
    private String title;
    private String body;
    private Date dateCreated;
    private UserDto user;
    private ChannelDto channel;
    private List<LikeDto> likes;
    private List<CommentDto> comments;
    private List<AttachmentDto> attachments;

}
