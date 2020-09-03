package com.example.app.service;

import com.example.app.dto.channel.ChannelDto;
import com.example.app.dto.channel.ChannelShortDto;
import org.springframework.core.io.ByteArrayResource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ChannelService {

    List<ChannelShortDto> findAll();

    ChannelDto findById(Long id);

    ChannelDto save(ChannelDto channelDto);

    List<ChannelShortDto> findAllByUserId(Long id);

    ByteArrayResource findProfilePictureById(Long id) throws IOException;
}
