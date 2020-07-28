package com.example.app.dto.comment;

import com.example.app.dto.attachment.AttachmentDto;
import com.example.app.dto.like.LikeDto;
import com.example.app.dto.user.UserShortDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentShortDto {
    private Long id;
    private String text;
    private Date dateCreated;
    private Date dateLastModified;
    private UserShortDto user;
    private CommentStatusDto commentStatus;
    private List<LikeDto> likes;
    private List<AttachmentDto> attachments;

}
