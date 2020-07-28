package com.example.app.mapper;

import com.example.app.dto.AttachmentDto;
import com.example.app.entity.Attachment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttachmentMapper {

    AttachmentDto toDto(Attachment attachment);

    @InheritInverseConfiguration
    Attachment toEntity(AttachmentDto attachment);

    List<AttachmentDto> toDtoList(List<Attachment> list);

    @InheritInverseConfiguration
    List<Attachment> toEntityList(List<AttachmentDto> list);
}
