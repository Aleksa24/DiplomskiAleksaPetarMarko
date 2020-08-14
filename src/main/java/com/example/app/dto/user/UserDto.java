package com.example.app.dto.user;

import com.example.app.dto.post.PostShortDto;
import com.example.app.validator.user.email.EmailNotTaken;
import com.example.app.validator.user.groups.Add;
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
    @EmailNotTaken(groups = Add.class)
    private String email;
    private String phone;
    private boolean isAccountNonExpired;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private boolean isAccountNonLocked;
    private UserRoleDto role;
    private List<PostShortDto> favorites;
}
