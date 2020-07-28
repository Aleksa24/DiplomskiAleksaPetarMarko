package com.example.app.service.impl;

import com.example.app.dto.PostDto;
import com.example.app.mapper.PostMapper;
import com.example.app.repository.PostRepository;
import com.example.app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public List<PostDto> getAll() {
        return postMapper.toDtoList(postRepository.findAll());
    }
}