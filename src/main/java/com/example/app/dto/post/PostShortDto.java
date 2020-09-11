package com.example.app.dto.post;

import com.example.app.dto.Searchable;
import com.example.app.dto.channel.ChannelShortDto;
import com.example.app.dto.user.UserShortDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostShortDto implements Searchable {

    private Long id;
    private String title;
    private String body;
    private Date dateCreated;
    private UserShortDto user;
    private ChannelShortDto channel;

}
