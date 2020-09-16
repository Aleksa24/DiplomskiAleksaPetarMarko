package com.example.app.service.impl;

import com.example.app.constant.FileConstant;
import com.example.app.dto.channel.ChannelDto;
import com.example.app.dto.channel.ChannelShortDto;
import com.example.app.entity.Channel;
import com.example.app.entity.UserChannel;
import com.example.app.exception.ChannelNotFoundException;
import com.example.app.exception.user.UserNotFoundException;
import com.example.app.mapper.ChannelMapper;
import com.example.app.repository.ChannelRepository;
import com.example.app.repository.UserChannelRepository;
import com.example.app.service.ChannelService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.app.constant.ExceptionConstant.CHANNEL_NOT_FOUND_BY_NAME;

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

    @Override
    public ByteArrayResource findProfilePictureById(Long id) throws IOException {
        String pictureUrl = channelRepository.findById(id).orElseThrow(
                () -> new ChannelNotFoundException("Channel with id " + id + " not found.")
        ).getProfilePictureUrl();

        File file = new File(FileConstant.ASSETS_FOLDER + pictureUrl);

        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("The requested file not found");
        }
        Path path = Paths.get(file.getAbsolutePath());

        return new ByteArrayResource(Files.readAllBytes(path));
    }

    @Override
    public String uploadProfileImage(Long id, MultipartFile profileImage) throws IOException {

        Channel channel = channelRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("Channel with id " + id + " not found")
        );

        System.out.println(FileConstant.ASSETS_FOLDER + FileConstant.CHANNEL_FOLDER + File.separator + id + File.separator + FileConstant.PROFILE_FOLDER_NAME);

        Path folder = Paths.get(FileConstant.ASSETS_FOLDER + FileConstant.CHANNEL_FOLDER + File.separator + id + File.separator + FileConstant.PROFILE_FOLDER_NAME);

        if (!Files.exists(folder)) {
            Files.createDirectories(folder);
        } else {
            File file = folder.toFile();
            FileUtils.cleanDirectory(file);
        }

        channel.setProfilePictureUrl(FileConstant.CHANNEL_FOLDER + id + File.separator + FileConstant.PROFILE_FOLDER_NAME + File.separator + profileImage.getOriginalFilename());

        Files.copy(profileImage.getInputStream(),
                folder.resolve(profileImage.getOriginalFilename()));

        channelRepository.save(channel);

        return "Profile picture is saved";
    }

    @Override
    public ChannelDto findByName(String name) {
        return channelMapper.toDto(channelRepository.findByName(name)
                .orElseThrow(() -> new ChannelNotFoundException(String.format(CHANNEL_NOT_FOUND_BY_NAME, name))));
    }

    @Override
    public Long findIdByPostId(Long postId) {
        return channelRepository.findIdByPostId(postId);
    }

    @Override
    public boolean isUserInChannel(Long userId,Long channelId) {
        UserChannel userChannel = userChannelRepository.findByUserIdAndChannelId(userId, channelId);
        return userChannel != null;
    }
}
