package com.example.app.controller;

import com.example.app.dto.user.UserDto;
import com.example.app.dto.user.UserShortDto;
import com.example.app.http.HttpResponse;
import com.example.app.service.EmailService;
import com.example.app.service.UserService;
import com.example.app.validator.user.groups.Add;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final EmailService emailService;

    @Autowired
    public UserController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
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
    public UserDto add(@Validated(Add.class) @RequestBody UserDto userDto) throws IOException {
        String email = userDto.getEmail();

        String password = generateRandomPassword();
        userDto.setPassword(password);

        UserDto savedUserDto = userService.add(userDto);

        userService.saveDefaultProfileImage(savedUserDto.getId());

        emailService.sendPasswordToUserEmail(email, password);

        return savedUserDto;
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

    private String generateRandomPassword() {
        int leftLimit = 33;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new SecureRandom();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);

        return generatedString;
    }



}
