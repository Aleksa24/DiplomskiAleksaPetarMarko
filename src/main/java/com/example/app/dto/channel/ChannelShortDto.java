package com.example.app.dto.channel;

import com.example.app.dto.Searchable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelShortDto implements Searchable {

    private Long id;
    private String name;
    private Date dateCreated;
    private CategoryDto category;
    private ChannelStatusDto channelStatus;
    private CommunicationDirectionDto communicationDirection;
}
