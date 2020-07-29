package com.example.app.service;

import com.example.app.dto.post.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();
}
