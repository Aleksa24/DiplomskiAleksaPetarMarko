package com.example.app.service.impl;

import com.example.app.constants.Constants;
import com.example.app.dto.UserDto;
import com.example.app.entity.User;
import com.example.app.exception.user.UserNotFoundException;
import com.example.app.mapper.UserMapper;
import com.example.app.repository.UserRepository;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return Optional.ofNullable(userMapper.toDto(userRepository.findById(id).orElse(null)));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public UserDto save(UserDto userDto) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
    }

    @Override
    public UserDto deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(String.format(Constants.USER_NOT_FOUND_BY_ID, id)));
        userRepository.deleteById(id);
        return userMapper.toDto(user);
    }

    @Override
    public Optional<UserDto> findByUsername(String username) {
        return Optional.ofNullable(userMapper.toDto(userRepository.findByUsername(username).orElse(null)));
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        return Optional.ofNullable(userMapper.toDto(userRepository.findByEmail(email).orElse(null)));
    }
}
