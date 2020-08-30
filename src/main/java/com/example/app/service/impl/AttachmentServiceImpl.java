package com.example.app.service.impl;

import com.example.app.attachment.AttachmentParent;
import com.example.app.constants.AttachmentParentConstant;
import com.example.app.constants.FileConstant;
import com.example.app.dto.attachment.AttachmentDto;
import com.example.app.dto.attachment.AttachmentUploadDataDto;
import com.example.app.entity.*;
import com.example.app.exception.user.UserNotFoundException;
import com.example.app.mapper.AttachmentMapper;
import com.example.app.mapper.AttachmentRepository;
import com.example.app.repository.ChannelRepository;
import com.example.app.repository.CommentRepository;
import com.example.app.repository.PostRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.AttachmentService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.example.app.constants.FileConstant.*;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentMapper attachmentMapper;

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final ChannelRepository channelRepository;
    private final CommentRepository commentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository, AttachmentMapper attachmentMapper, UserRepository userRepository, PostRepository postRepository, ChannelRepository channelRepository, CommentRepository commentRepository) {
        this.attachmentRepository = attachmentRepository;
        this.attachmentMapper = attachmentMapper;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.channelRepository = channelRepository;
        this.commentRepository = commentRepository;
    }







    @Override
    public AttachmentDto add(AttachmentUploadDataDto attachmentUploadDataDto) throws IOException {
        Post post = attachmentUploadDataDto.getPostId() != null ? postRepository.findById(attachmentUploadDataDto.getPostId()).orElseThrow() : null;
        Comment comment = attachmentUploadDataDto.getCommentId() != null ? commentRepository.findById(attachmentUploadDataDto.getCommentId()).orElseThrow() : null;
        Channel channel = attachmentUploadDataDto.getChannelId() != null ? channelRepository.findById(attachmentUploadDataDto.getChannelId()).orElseThrow() : null; // TODO: Add exceptions
        User user = userRepository.findById(attachmentUploadDataDto.getUserId()).orElseThrow(
                () -> new UserNotFoundException("User with id not found")
        );

        String fileCreationPath = attachmentUploadDataDto.getFileCreationPath();

        Attachment newAttachment = new Attachment();
        newAttachment.setUser(user);
        newAttachment.setPost(post);
        newAttachment.setChannel(channel);
        newAttachment.setComment(comment);
        newAttachment.setOriginalName(attachmentUploadDataDto.getOriginalFileName());
        newAttachment.setUrl(fileCreationPath);

        System.out.println("new Attachment postFolder.toAbsolutePath().toString(): " + newAttachment.getUrl());

        Attachment savedAttachment = attachmentRepository.save(newAttachment);
        return attachmentMapper.toDto(savedAttachment);
    }


    @Override
    public AttachmentParent resolveParent(String attachmentParentName) {
        switch (attachmentParentName) {
            case AttachmentParentConstant
                    .POST -> {
                return AttachmentParent.POST;
            }
            case AttachmentParentConstant
                    .CHANNEL -> {
                return AttachmentParent.CHANNEL;
            }
            case AttachmentParentConstant
                    .COMMENT -> {
                return AttachmentParent.COMMENT;
            }
            default -> throw new IllegalArgumentException("Invalid attachment parent");
        }
    }

    @Override
    public String deleteById(Long id) {
        attachmentRepository.deleteById(id);
        return "Attachment successfully deleted";
    }

    @Override
    public AttachmentDto findById(Long id) {
        return attachmentMapper.toDto(attachmentRepository.findById(id).orElseThrow()); // TODO add exception
     }
}
