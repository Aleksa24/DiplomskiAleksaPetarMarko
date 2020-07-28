package com.example.app.dto.post;

import com.example.app.dto.attachment.AttachmentDto;
import com.example.app.dto.channel.ChannelShortDto;
import com.example.app.dto.like.LikeDto;
import com.example.app.dto.user.UserShortDto;
import com.example.app.dto.comment.CommentShortDto;
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
    private UserShortDto user;
    private ChannelShortDto channel;
    private List<LikeDto> likes;
    private List<CommentShortDto> comments;
    private List<AttachmentDto> attachments;

}
