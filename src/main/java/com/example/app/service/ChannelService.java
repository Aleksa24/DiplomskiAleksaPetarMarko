package com.example.app.service;

import com.example.app.dto.channel.ChannelDto;
import com.example.app.dto.channel.ChannelShortDto;

import java.util.List;

public interface ChannelService {

    List<ChannelShortDto> findAll();

    ChannelDto findById(Long id);

    ChannelDto save(ChannelDto channelDto);
}
