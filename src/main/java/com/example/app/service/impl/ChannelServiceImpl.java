package com.example.app.service.impl;

import com.example.app.dto.channel.ChannelDto;
import com.example.app.mapper.ChannelMapper;
import com.example.app.repository.ChannelRepository;
import com.example.app.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;
    private final ChannelMapper channelMapper;

    @Autowired
    public ChannelServiceImpl(ChannelRepository channelRepository, ChannelMapper channelMapper) {
        this.channelRepository = channelRepository;
        this.channelMapper = channelMapper;
    }

    @Override
    public List<ChannelDto> getAll() {
        return channelMapper.toDtoList(channelRepository.findAll());
    }
}
