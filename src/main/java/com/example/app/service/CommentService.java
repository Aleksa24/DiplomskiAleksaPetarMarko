package com.example.app.service;

import com.example.app.dto.comment.CommentDto;
import com.example.app.dto.comment.CommentStatusDto;
import com.example.app.dto.like.LikeStatusDto;

public interface CommentService {

    CommentDto findById(Long id);

    CommentStatusDto findCommentStatusByName(String name);

    CommentDto save(CommentDto commentDto);

    LikeStatusDto findLikeStatusByName(String likeStatusString);
}
