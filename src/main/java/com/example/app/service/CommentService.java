package com.example.app.service;

import com.example.app.dto.CommentDto;

public interface CommentService {
    CommentDto getById(Long id);
}
