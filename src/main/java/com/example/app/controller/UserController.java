package com.example.app.controller;

import com.example.app.dto.user.UserDto;
import com.example.app.service.UserService;
import com.example.app.validator.user.groups.Add;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("all_pagination")
    public List<UserDto> findAllPagination(Pageable pageable) {
        return userService.findAllPagination(pageable);
    }
    @GetMapping("total_count")
    public Long totalCount(){
        return userService.totalCount();
    }
}
