package com.example.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelShortDto {

    private Long id;
    private String name;
    private Date dateCreated;
    private CategoryDto category;
    private ChannelStatusDto channelStatus;
    private CommunicationDirectionDto communicationDirection;
//    private List<ChannelDto> channels;
//    private List<AttachmentDto> attachments;
//    private List<UserChannelDto> userChannels;
//    private List<PostDto> posts;
}
