package com.example.app.service.impl;

import com.example.app.dto.CommentDto;
import com.example.app.mapper.CommentMapper;
import com.example.app.repository.CommentRepository;
import com.example.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public CommentDto getById(Long id) {
        return commentMapper.toDto(commentRepository.findById(id).get());
    }
}
