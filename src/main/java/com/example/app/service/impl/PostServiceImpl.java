package com.example.app.service.impl;

import com.example.app.dto.post.PostDto;
import com.example.app.entity.Post;
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
        return this.postMapper.toDto(postRepository.findById(id).get());//todo: odraditi validaciju i sve sto treba, bacanje greske ako nema post
    }

    @Override
    public PostDto update(PostDto postDto) {
        Post post = postMapper.toEntity(postDto);
        PostDto postDto1 = postMapper.toDto(postRepository.save(post));//todo: odraditi validaciju i sve sto treba, bacanje greske ako nema post
        return postDto1;
    }

    @Override
    public PostDto save(PostDto postDto) {
        return postMapper.toDto(postRepository.save(postMapper.toEntity(postDto)));//todo: odraditi validaciju i sve sto treba, bacanje greske ako nema post
    }
}


