package com.example.app.dto;

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
