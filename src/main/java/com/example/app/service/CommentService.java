package com.example.app.service;

import com.example.app.dto.comment.CommentDto;

public interface CommentService {
    CommentDto getById(Long id);
}
