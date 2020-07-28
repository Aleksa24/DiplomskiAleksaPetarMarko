package com.example.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserShortDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;

}
