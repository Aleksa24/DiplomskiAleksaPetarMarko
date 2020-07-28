package com.example.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto {

    private Long id;
    private Date dateCreated;
    private LikeStatusDto likeStatus;
    private UserDto user;
}
