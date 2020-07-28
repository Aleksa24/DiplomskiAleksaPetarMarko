package com.example.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserChannelDto {

    private Long id;
    private Date dateJoined;
    private ChannelRoleDto channelRole;
    private UserDto user;

}
