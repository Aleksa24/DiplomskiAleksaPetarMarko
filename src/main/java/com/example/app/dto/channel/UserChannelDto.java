package com.example.app.dto.channel;

import com.example.app.dto.user.UserShortDto;
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
    private UserShortDto user;

}
