package com.example.app.service.impl;

import com.example.app.dto.channel.CommunicationDirectionDto;
import com.example.app.mapper.ChannelMapper;
import com.example.app.repository.CommunicationDirectionRepository;
import com.example.app.service.CommunicationDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunicationDirectionServiceImpl implements CommunicationDirectionService {

    private final ChannelMapper channelMapper;
    private final CommunicationDirectionRepository communicationDirectionRepository;

    @Autowired
    public CommunicationDirectionServiceImpl(ChannelMapper channelMapper, CommunicationDirectionRepository communicationDirectionRepository) {
        this.channelMapper = channelMapper;
        this.communicationDirectionRepository = communicationDirectionRepository;
    }

    @Override
    public List<CommunicationDirectionDto> findAll() {
        return channelMapper.toCommunicationDirectionDtoList(communicationDirectionRepository.findAll());
    }
}
