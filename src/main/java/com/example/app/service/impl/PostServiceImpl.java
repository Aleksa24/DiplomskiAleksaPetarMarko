package com.example.app.service.impl;

import com.example.app.dto.post.PostDto;
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
    public List<PostDto> findAll() {
        return postMapper.toDtoList(postRepository.findAll());
    }

    @Override
    public PostDto findById(Long id) {
        return this.postMapper.toDto(this.postRepository.findById(id).get());//todo: odraditi validaciju i sve sto treba, bacanje greske ako nema post
    }
}
