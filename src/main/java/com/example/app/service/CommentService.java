package com.example.app.service;

import com.example.app.dto.comment.CommentDto;
import com.example.app.dto.comment.CommentStatusDto;

public interface CommentService {

    CommentDto findById(Long id);

    CommentStatusDto findCommentStatusByName(String name);

    CommentDto save(CommentDto commentDto);
}
