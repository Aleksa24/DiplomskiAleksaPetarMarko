package com.example.app.dto.like;

import com.example.app.dto.comment.CommentShortDto;
import com.example.app.dto.post.PostShortDto;
import com.example.app.dto.user.UserShortDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto {

    private Long id;
    private Date dateCreated;
    private LikeStatusDto likeStatus;
    private UserShortDto user;
    private PostShortDto post;
    private CommentShortDto comment;
}
