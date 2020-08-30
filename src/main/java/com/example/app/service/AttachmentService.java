package com.example.app.service;

import com.example.app.attachment.AttachmentParent;
import com.example.app.dto.attachment.AttachmentDto;
import com.example.app.dto.attachment.AttachmentUploadDataDto;
import com.example.app.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AttachmentService {


    AttachmentDto add(AttachmentUploadDataDto attachmentUploadDataDto) throws IOException;

    AttachmentParent resolveParent(String attachmentParentName);

    String deleteById(Long id);

    AttachmentDto findById(Long id);
}
