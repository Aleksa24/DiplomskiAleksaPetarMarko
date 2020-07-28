package com.example.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostShortDto {

    private Long id;
    private String title;
    private String body;
    private Date dateCreated;
    private UserShortDto user;
    private ChannelShortDto channel;


}
