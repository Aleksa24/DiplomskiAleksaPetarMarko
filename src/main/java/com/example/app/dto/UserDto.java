package com.example.app.dto;

import com.example.app.entity.Post;
import com.example.app.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Date dateCreated;
    private String email;
    private String phone;
    private Boolean isAccountNonExpired;
    private Boolean isCredentialsNonExpired;
    private Boolean isEnabled;
    private Boolean isAccountNonLocked;
    private UserRole role;
    private List<Post> favorites;
}
