package com.example.app.service;


import com.example.app.dto.user.UserDto;
import com.example.app.dto.user.UserShortDto;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    UserDto findById(Long id);

    List<UserDto> findAll();

    UserDto save(UserDto userDto);

    UserDto deleteById(Long id);

    UserDto findByUsername(String username);

    UserDto findByEmail(String email);

    UserDto add(UserDto userDto);

    Page<UserShortDto> findAllPagination(Pageable pageable);

    ByteArrayResource findProfilePictureById(Long id) throws IOException;

    String uploadProfileImage(Long id, MultipartFile profileImage) throws IOException;
}
