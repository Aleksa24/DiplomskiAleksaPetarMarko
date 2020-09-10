package com.example.app.service.impl;

import com.example.app.constant.FileConstant;
import com.example.app.dto.user.UserDto;
import com.example.app.entity.User;
import com.example.app.exception.user.UserNotFoundException;
import com.example.app.mapper.UserMapper;
import com.example.app.repository.UserRepository;
import com.example.app.repository.UserRoleRepository;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import static com.example.app.constant.ExceptionConstant.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper,
                           PasswordEncoder passwordEncoder,
                           UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format(USER_NOT_FOUND_BY_ID, id))));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setProfilePictureUrl(userRepository.findById(userDto.getId()).orElseThrow(
                () -> new UserNotFoundException("User with id " + userDto.getId() + " not found")
        ).getProfilePictureUrl());
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(String.format(USER_NOT_FOUND_BY_ID, id)));
        userRepository.deleteById(id);
        return userMapper.toDto(user);
    }

    @Override
    public UserDto findByUsername(String username) {
        return userMapper.toDto(userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(String.format(USER_NOT_FOUND_BY_USERNAME, username))));
    }

    @Override
    public UserDto findByEmail(String email) {
        return userMapper.toDto(userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(String.format(USER_NOT_FOUND_BY_EMAIL, email))));
    }

    @Override
    public UserDto add(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setRole(userRoleRepository.findByName(user.getRole().getName()).orElseThrow(
                () -> new RuntimeException("Role Not Found!")
        ));
        user.setUsername(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getEmail()));
        user.setDateCreated(new Date());
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public List<UserDto> findAllPagination(Pageable pageable) {
        return userMapper.toDtoList(userRepository.findAll(pageable).getContent());
    }

    @Override
    public Long totalCount() {
        return userRepository.count();
    }

    @Override
    public ByteArrayResource findProfilePictureById(Long id) throws IOException {
        String pictureUrl = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id " + id + " not found.")
        ).getProfilePictureUrl();

        File file = new File(pictureUrl);

        if (!file.exists()){
            throw new FileNotFoundException("The requested file not found");
        }
        Path path = Paths.get(file.getAbsolutePath());

        return new ByteArrayResource(Files.readAllBytes(path));
    }

    @Override
    public String uploadProfileImage(Long id, MultipartFile profileImage) throws IOException {

        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id " + id + " not found")
        );


        System.out.println(System.getProperty("user.dir"));


        Path folder = Paths.get(FileConstant.USER_FOLDER + File.separator + id + File.separator +"attachments");

//        Path folder1 = Paths.get(ClassLoader.getSystemResource(FileConstant.USER_FOLDER + File.separator + id + File.separator + "profile").toURI());

        if (!Files.exists(folder)){
            Files.createDirectories(folder);
        }

        // TODO? FileUtils clearDirectory

        user.setProfilePictureUrl(folder.resolve(profileImage.getOriginalFilename()).toAbsolutePath().toString());

        Files.deleteIfExists(folder.resolve(profileImage.getOriginalFilename()));

        Files.copy(profileImage.getInputStream(),
                folder.resolve(profileImage.getOriginalFilename()));

        userRepository.save(user);

        return "Profile picture is saved";
    }

}
