package com.example.app.service.impl;

import com.example.app.dto.Searchable;
import com.example.app.dto.channel.ChannelShortDto;
import com.example.app.dto.post.PostShortDto;
import com.example.app.mapper.ChannelMapper;
import com.example.app.mapper.PostMapper;
import com.example.app.mapper.UserMapper;
import com.example.app.repository.ChannelRepository;
import com.example.app.repository.PostRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.SearchableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchableServiceImpl implements SearchableService {

    private final PostRepository postRepository;
    private final ChannelRepository channelRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;
    private final ChannelMapper channelMapper;
    private final UserMapper userMapper;

    @Autowired
    public SearchableServiceImpl(PostRepository postRepository,
                                 ChannelRepository channelRepository,
                                 UserRepository userRepository,
                                 PostMapper postMapper,
                                 ChannelMapper channelMapper,
                                 UserMapper userMapper) {
        this.postRepository = postRepository;
        this.channelRepository = channelRepository;
        this.userRepository = userRepository;
        this.postMapper = postMapper;
        this.channelMapper = channelMapper;
        this.userMapper = userMapper;
    }

    @Override
    public List<Searchable> getChannelsAndPosts(String filterValue) {
        List<Searchable> searchableList = new ArrayList<>();
        List<ChannelShortDto> channelShortDtoList = channelRepository.findByFilterValue(filterValue)
                .stream()
                .map(channelMapper::toShortDto)
                .collect(Collectors.toList());
        List<PostShortDto> postShortDtoList = postRepository.findByFilterValue(filterValue)
                .stream()
                .map(postMapper::toShortDto)
                .collect(Collectors.toList());
        searchableList.addAll(postShortDtoList);
        searchableList.addAll(channelShortDtoList);
        return searchableList;
    }
}
