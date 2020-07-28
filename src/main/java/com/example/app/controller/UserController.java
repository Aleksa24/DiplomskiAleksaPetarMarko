package com.example.app.controller;

import com.example.app.dto.UserDto;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable("id") @Validated Long id) {
        UserDto userDto = userService.findById(id);
        System.out.println("UserDto found:" + userDto);
        return userDto;
    }

    @PostMapping("/add")
    public UserDto add(@RequestBody @Validated UserDto userDto){
        UserDto savedUserDto = userService.save(userDto);
        System.out.println("Saved userDto:" + userDto);
        return savedUserDto;
    }

}
