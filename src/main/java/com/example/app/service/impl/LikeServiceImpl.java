package com.example.app.service.impl;

import com.example.app.repository.LikeRepository;
import com.example.app.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public void deleteLike(Long id) {
        this.likeRepository.deleteById(id);
    }
}
