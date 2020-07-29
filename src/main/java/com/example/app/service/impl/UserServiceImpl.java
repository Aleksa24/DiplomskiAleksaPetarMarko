package com.example.app.service.impl;

import com.example.app.constants.Constants;
import com.example.app.dto.user.UserDto;
import com.example.app.entity.User;
import com.example.app.exception.user.UserNotFoundException;
import com.example.app.mapper.UserMapper;
import com.example.app.repository.UserRepository;
import com.example.app.security.user.UserPrincipal;
import com.example.app.security.utility.JWTTokenProvider;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.app.security.constant.UserImplConstants.NO_USER_FOUND_BY_USERNAME;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
//    private final AuthenticationManager authenticationManager;
    private final JWTTokenProvider jwtTokenProvider;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper,
//                           AuthenticationManager authenticationManager,
                           JWTTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
//        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(NO_USER_FOUND_BY_USERNAME + username);
        } else {
//            validateLoginAttempt(user);//todo
            userRepository.save(user);
            UserPrincipal userPrincipal = new UserPrincipal(user);
            return userPrincipal;
        }
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format(Constants.USER_NOT_FOUND_BY_ID, id))));
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

//    @Override
//    public UserDto login(LoginRequestDto loginRequestDto) {
//
//        authenticate(loginRequestDto.getUsername(), loginRequestDto.getPassword());
//        UserDto userDto = findByUsername(loginRequestDto.getUsername()).get();
//
//        return userDto;
//
//    }



//    private void authenticate(String username, String password) {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//    }
//
//    private HttpHeaders getJwtHeader(UserPrincipal user) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(SecurityConstant.JWT_TOKEN_HEADER, jwtTokenProvider.generateJwtToken(user));
//        return headers;
//    }
}
