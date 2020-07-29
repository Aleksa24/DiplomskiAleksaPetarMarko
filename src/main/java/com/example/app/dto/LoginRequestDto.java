package com.example.app.dto;

import com.example.app.validator.user.email.EmailNotTaken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {

    @EmailNotTaken
    private String username;
    private String password; // TODO must me encoded
}
