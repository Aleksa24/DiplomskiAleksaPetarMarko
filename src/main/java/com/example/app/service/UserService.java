package com.example.app.service;


import com.example.app.dto.user.UserDto;

import java.util.List;

public interface UserService {

    UserDto findById(Long id);

    List<UserDto> findAll();

    UserDto save(UserDto userDto);

    UserDto deleteById(Long id);

    UserDto findByUsername(String username);

    UserDto findByEmail(String email);

}
