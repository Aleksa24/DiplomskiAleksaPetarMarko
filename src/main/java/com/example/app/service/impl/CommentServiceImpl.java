package com.example.app.service.impl;

import com.example.app.constant.ExceptionConstant;
import com.example.app.dto.comment.CommentDto;
import com.example.app.dto.comment.CommentStatusDto;
import com.example.app.dto.like.LikeStatusDto;
import com.example.app.exception.comment.CommentNotFountException;
import com.example.app.mapper.CommentMapper;
import com.example.app.mapper.LikeMapper;
import com.example.app.repository.CommentRepository;
import com.example.app.repository.CommentStatusRepository;
import com.example.app.repository.LikeStatusRepository;
import com.example.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final LikeMapper likeMapper;
    private final CommentStatusRepository commentStatusRepository;
    private final LikeStatusRepository likeStatusRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository,
                              CommentMapper commentMapper,
                              LikeMapper likeMapper,
                              CommentStatusRepository commentStatusRepository,
                              LikeStatusRepository likeStatusRepository) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.likeMapper = likeMapper;
        this.commentStatusRepository = commentStatusRepository;
        this.likeStatusRepository = likeStatusRepository;
    }

    @Override
    public CommentDto findById(Long id) {
        return commentMapper.toDto(commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFountException(
                        String.format(ExceptionConstant.COMMENT_NOT_FOUND_BY_ID, id))));
    }

    @Override
    public CommentStatusDto findCommentStatusByName(String name) {
        return commentMapper.toCommentStatusDto(commentStatusRepository.findByName(name).get());//todo: odradi greske
    }

    @Override
    public CommentDto save(CommentDto commentDto) {
        return commentMapper.toDto(commentRepository.save(commentMapper.toEntity(commentDto)));//todo: odradi greske
    }

    @Override
    public LikeStatusDto findLikeStatusByName(String likeStatusString) {
        return likeMapper.toStatusDto(likeStatusRepository.findByName(likeStatusString).get());//todo: odradi greske
    }
}
