package com.example.app.dto.channel;

import com.example.app.dto.attachment.AttachmentDto;
import com.example.app.dto.post.PostShortDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelDto {

    private Long id;
    private String name;
    private Date dateCreated;
    private CategoryDto category;
    private ChannelStatusDto channelStatus;
    private CommunicationDirectionDto communicationDirection;
    private List<ChannelShortDto> channels;
    private List<AttachmentDto> attachments;
    private List<UserChannelDto> userChannels;
    private List<PostShortDto> posts;

}
