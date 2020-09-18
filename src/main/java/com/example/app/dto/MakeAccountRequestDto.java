package com.example.app.dto;

import com.example.app.dto.user.UserDto;
import lombok.Data;

@Data
public class MakeAccountRequestDto {
    private String token;
    private UserDto user;
}
