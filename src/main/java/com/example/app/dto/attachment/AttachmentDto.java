package com.example.app.dto.attachment;

import com.example.app.dto.user.UserShortDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentDto {

    private Long id;
    private String originalName;
    private UserShortDto user;

}
