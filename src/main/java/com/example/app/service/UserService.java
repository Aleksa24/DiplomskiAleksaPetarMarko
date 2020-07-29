package com.example.app.service;


import com.example.app.dto.user.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto findById(Long id);

    List<UserDto> findAll();

    UserDto save(UserDto userDto);

    UserDto deleteById(Long id);

    Optional<UserDto> findByUsername(String username);

    Optional<UserDto> findByEmail(String email);

//    UserDto login(LoginRequestDto loginRequestDto);
}
