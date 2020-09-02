package com.example.app.service.impl;

import com.example.app.dto.channel.ChannelDto;
import com.example.app.dto.channel.ChannelShortDto;
import com.example.app.entity.UserChannel;
import com.example.app.mapper.ChannelMapper;
import com.example.app.repository.ChannelRepository;
import com.example.app.repository.UserChannelRepository;
import com.example.app.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;
    private final ChannelMapper channelMapper;
    private final UserChannelRepository userChannelRepository;

    @Autowired
    public ChannelServiceImpl(ChannelRepository channelRepository,
                              ChannelMapper channelMapper,
                              UserChannelRepository userChannelRepository) {
        this.channelRepository = channelRepository;
        this.channelMapper = channelMapper;
        this.userChannelRepository = userChannelRepository;
    }

    @Override
    public List<ChannelShortDto> findAll() {
        return channelMapper.toShortDtoList(channelRepository.findAll());
    }

    @Override
    public ChannelDto findById(Long id) {
        return channelMapper.toDto(channelRepository.findById(id).get());//todo:obradi kada se baca greska
    }

    @Override
    public ChannelDto save(ChannelDto channelDto) {
        System.out.println(channelMapper.toEntity(channelDto));
        return channelMapper.toDto(channelRepository.save(channelMapper.toEntity(channelDto)));
    }

    @Override
    public List<ChannelShortDto> findAllByUserId(Long userId) {
        List<UserChannel> userChannels = userChannelRepository.findAllByUserId(userId);
        return channelMapper.toShortDtoList(userChannels.stream()
                .flatMap(userChannel -> Stream.of(userChannel.getChannel()))
                .collect(Collectors.toList()));
    }
}
