package com.example.app.mapper;

import com.example.app.dto.ChannelDto;
import com.example.app.entity.Channel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CategoryMapper.class,ChannelStatusMapper.class,
                CommunicationDirectionMapper.class,AttachmentMapper.class,
                UserChannelMapper.class,PostMapper.class})
public abstract class ChannelMapper {

    private final CategoryMapper categoryMapper;
    private final ChannelStatusMapper channelStatusMapper;
    private final CommunicationDirectionMapper communicationDirectionMapper;
    private final AttachmentMapper attachmentMapper;
    private final UserChannelMapper userChannelMapper;
    private final PostMapper postMapper;

    @Autowired
    protected ChannelMapper(CategoryMapper categoryMapper,
                            ChannelStatusMapper channelStatusMapper,
                            CommunicationDirectionMapper communicationDirectionMapper,
                            AttachmentMapper attachmentMapper,
                            UserChannelMapper userChannelMapper,
                            PostMapper postMapper) {
        this.categoryMapper = categoryMapper;
        this.channelStatusMapper = channelStatusMapper;
        this.communicationDirectionMapper = communicationDirectionMapper;
        this.attachmentMapper = attachmentMapper;
        this.userChannelMapper = userChannelMapper;
        this.postMapper = postMapper;
    }

    abstract ChannelDto toDto(Channel channel);

    @InheritInverseConfiguration
    abstract Channel toEntity(ChannelDto channel);

    abstract List<ChannelDto> toDtoList(List<Channel> list);

    @InheritInverseConfiguration
    abstract List<Channel> toEntityList(List<ChannelDto> list);

}
