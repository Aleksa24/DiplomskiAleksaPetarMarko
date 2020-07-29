package com.example.app.service.impl;

import com.example.app.constants.Constants;
import com.example.app.dto.comment.CommentDto;
import com.example.app.exception.comment.CommentNotFountException;
import com.example.app.mapper.CommentMapper;
import com.example.app.repository.CommentRepository;
import com.example.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public CommentDto findById(Long id) {
        return commentMapper.toDto(commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFountException(
                        String.format(Constants.COMMENT_NOT_FOUND_BY_ID, id))));
    }
}
