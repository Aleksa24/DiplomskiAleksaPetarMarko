package com.example.app.service;

import com.example.app.dto.like.LikeDto;

public interface LikeService {
    void deleteLike(Long id);

    LikeDto save(LikeDto likeDto);
}
