package com.example.app.service.impl;

import com.example.app.dto.like.LikeDto;
import com.example.app.mapper.LikeMapper;
import com.example.app.repository.LikeRepository;
import com.example.app.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final LikeMapper likeMapper;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository,
                           LikeMapper likeMapper) {
        this.likeRepository = likeRepository;
        this.likeMapper = likeMapper;
    }

    @Override
    public void deleteLike(Long id) {
        this.likeRepository.deleteById(id);
    }

    @Override
    public LikeDto save(LikeDto likeDto) {
        return likeMapper.toDto(likeRepository.save(likeMapper.toEntity(likeDto)));
    }
}
