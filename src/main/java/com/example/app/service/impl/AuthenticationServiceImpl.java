package com.example.app.service.impl;

import com.example.app.constants.Constants;
import com.example.app.dto.LoginRequestDto;
import com.example.app.dto.user.UserDto;
import com.example.app.entity.User;
import com.example.app.exception.user.UserNotFoundException;
import com.example.app.mapper.UserMapper;
import com.example.app.repository.UserRepository;
import com.example.app.security.user.UserPrincipal;
import com.example.app.security.utility.JWTTokenProvider;
import com.example.app.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import static com.example.app.security.constant.SecurityConstant.JWT_TOKEN_HEADER;
import static org.springframework.http.HttpStatus.OK;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JWTTokenProvider jwtTokenProvider;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationManager authenticationManager,
                                     UserRepository userRepository, UserMapper userMapper,
                                     JWTTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public ResponseEntity<UserDto> login(LoginRequestDto loginRequestDto) {
        String username = loginRequestDto.getUsername();
        authenticate(username, loginRequestDto.getPassword());
        User loginUser = userRepository.findByUsername(loginRequestDto.getUsername())
                .orElseThrow(() -> new UserNotFoundException(
                        String.format(Constants.USER_NOT_FOUND_BY_USERNAME, username)));
        UserPrincipal userPrincipal = new UserPrincipal(loginUser);
        HttpHeaders jwtHeader = getJwtHeader(userPrincipal);
        return new ResponseEntity<>(userMapper.toDto(loginUser), jwtHeader, OK);
    }

    private HttpHeaders getJwtHeader(UserPrincipal user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWT_TOKEN_HEADER, jwtTokenProvider.generateJwtToken(user));
        return headers;
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
