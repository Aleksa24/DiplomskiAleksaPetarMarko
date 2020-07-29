package com.example.app.service;

import com.example.app.dto.comment.CommentDto;

public interface CommentService {

    CommentDto findById(Long id);
}
