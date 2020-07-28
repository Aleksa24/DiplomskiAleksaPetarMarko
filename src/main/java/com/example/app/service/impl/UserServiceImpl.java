package com.example.app.service.impl;

import com.example.app.dto.UserDto;
import com.example.app.entity.User;
import com.example.app.mapper.UserMapper;
import com.example.app.repository.UserRepository;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public UserDto findById(Long id) {
        return userMapper.toDto(userRepository.findById(id).get());
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.
                toDtoList(
                        userRepository.findAll());
    }

    @Override
    public UserDto save(UserDto userDto) {
        return userMapper.toDto(userRepository
                .save(userMapper.toEntity(userDto)));
    }

    @Override
    public UserDto deleteById(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return userMapper.toDto(user);
    }
}
