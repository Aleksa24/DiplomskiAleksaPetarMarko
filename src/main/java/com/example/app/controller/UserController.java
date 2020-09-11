package com.example.app.controller;

import com.example.app.dto.user.UserDto;
import com.example.app.dto.user.UserShortDto;
import com.example.app.http.HttpResponse;
import com.example.app.service.UserService;
import com.example.app.validator.user.groups.Add;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("find-by-username")
    public UserDto findByUsername(@RequestParam("username") String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") @Validated Long id) {
        return userService.findById(id);
    }

    @PostMapping("/save")
    public UserDto save(@Validated @RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @GetMapping("/all")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PostMapping("/add")
    public UserDto add(@Validated(Add.class) @RequestBody UserDto userDto) {
        return userService.add(userDto);
    }

    @GetMapping("all-pagination")
    public Page<UserShortDto> findAllPagination(Pageable pageable) {
        return userService.findAllPagination(pageable);
    }

    @GetMapping("{id}/profile-picture")
    public ResponseEntity<Resource> findProfilePictureById(@PathVariable Long id) throws IOException {

        ByteArrayResource resource = userService.findProfilePictureById(id);

        return ResponseEntity.ok()
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @PostMapping("/upload-profile-image")
    public ResponseEntity<HttpResponse> uploadProfileImage(
            @RequestParam MultipartFile profileImage,
            @RequestParam Long id
    ) throws IOException {


        String resultMessage = userService.uploadProfileImage(id, profileImage);

        return ResponseEntity
                .ok()
                .body(new HttpResponse(200, HttpStatus.OK, "PROFILE_IMAGE_CHANGED", resultMessage));
    }

    @GetMapping("all-pagination-users-in-channel")
    public Page<UserShortDto> findAllPaginationUsersInChannel(
            @RequestParam Long channelId,
            @RequestParam Long loggedUserId,
            @RequestParam Integer page,
            @RequestParam Integer size) {
        return userService.findAllPaginationUsersInChannel(channelId, loggedUserId, PageRequest.of(page, size));
    }

    @GetMapping("all-pagination-users-not-in-channel")
    public Page<UserShortDto> findAllByUserNotChannel(
            @RequestParam Long channelId,
            @RequestParam Long loggedUserId,
            @RequestParam Integer page,
            @RequestParam Integer size) {
        return userService.findAllByUserNotChannel(channelId, loggedUserId, PageRequest.of(page, size));
    }
}
