package com.example.app.controller;

import com.example.app.constants.Constants;
import com.example.app.dto.user.UserDto;
import com.example.app.exception.user.UserNotFoundException;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") @Validated Long id) {
        return userService.findById(id).orElseThrow(() ->
                new UserNotFoundException(String.format(Constants.USER_NOT_FOUND_BY_ID, id)));
    }

    @PostMapping("/save")
    public UserDto save(@Validated @RequestBody UserDto userDto) {
        return userService.save(userDto);

    }

    @GetMapping("/all")
    public List<UserDto> findAll() {
        return userService.findAll();
    }
}
