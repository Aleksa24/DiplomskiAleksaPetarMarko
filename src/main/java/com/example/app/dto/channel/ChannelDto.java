package com.example.app.dto.channel;

import com.example.app.dto.attachment.AttachmentDto;
import com.example.app.dto.post.PostShortDto;
import com.example.app.validator.channel.Channel;
import com.example.app.validator.channel.groups.Edit;
import com.example.app.validator.channel.groups.Save;
import com.example.app.validator.channel.name.ChannelNameNotTaken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Channel(groups = Edit.class)
public class ChannelDto {

    private Long id;
    @ChannelNameNotTaken(groups = Save.class)
    private String name;
    private Date dateCreated;
    private CategoryDto category;
    private ChannelStatusDto channelStatus;
    private CommunicationDirectionDto communicationDirection;
    private List<ChannelShortDto> channels;
    private List<AttachmentDto> attachments;
    private List<UserChannelDto> userChannels;
    private List<PostShortDto> posts;
    private ChannelShortDto parentChannel;

}
