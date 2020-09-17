package com.example.app.service;

import com.example.app.dto.channel.ChannelDto;
import com.example.app.dto.channel.ChannelShortDto;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ChannelService {

    List<ChannelShortDto> findAll();

    ChannelDto findById(Long id);

    ChannelDto save(ChannelDto channelDto);

    List<ChannelShortDto> findAllByUserId(Long id);

    ByteArrayResource findProfilePictureById(Long id) throws IOException;

    String uploadProfileImage(Long id, MultipartFile profileImage) throws IOException;

    ChannelDto findByName(String name);

    Long findIdByPostId(Long postId);

    boolean isUserInChannel(Long userId,Long channelId);

    List<ChannelShortDto> findAllByChannelAndUser(Long channelId, Long userId);
}
