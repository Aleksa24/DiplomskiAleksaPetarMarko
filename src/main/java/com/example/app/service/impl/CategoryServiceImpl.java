package com.example.app.service.impl;

import com.example.app.dto.channel.CategoryDto;
import com.example.app.mapper.ChannelMapper;
import com.example.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final ChannelMapper channelMapper;

    @Autowired
    public CategoryServiceImpl(ChannelMapper channelMapper) {
        this.channelMapper = channelMapper;
    }

    @Override
    public List<CategoryDto> findAll() {
        return null;
    }
}
