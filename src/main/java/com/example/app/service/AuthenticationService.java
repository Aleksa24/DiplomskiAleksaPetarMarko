package com.example.app.service;

import com.example.app.dto.LoginRequestDto;
import com.example.app.dto.user.UserDto;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

    ResponseEntity<UserDto> login(LoginRequestDto loginRequestDto);
}
