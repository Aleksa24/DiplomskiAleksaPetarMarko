package com.example.app.service.impl;

import com.example.app.dto.attachment.AttachmentDto;
import com.example.app.dto.post.PostDto;
import com.example.app.entity.Attachment;
import com.example.app.entity.Post;
import com.example.app.entity.User;
import com.example.app.mapper.AttachmentMapper;
import com.example.app.mapper.AttachmentRepository;
import com.example.app.mapper.PostMapper;
import com.example.app.repository.PostRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.example.app.constants.FileConstant.POST_FOLDER;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final AttachmentMapper attachmentMapper;
    private final UserRepository userRepository;
    private final AttachmentRepository attachmentRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository,
                           PostMapper postMapper,
                           AttachmentMapper attachmentMapper,
                           UserRepository userRepository,
                           AttachmentRepository attachmentRepository) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.attachmentMapper = attachmentMapper;
        this.userRepository = userRepository;
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public List<PostDto> findAll() {
        return postMapper.toDtoList(postRepository.findAll());
    }

    @Override
    public PostDto findById(Long id) {
        return this.postMapper.toDto(postRepository.findById(id).get());//todo: odraditi validaciju i sve sto treba, bacanje greske ako nema post
    }

    @Override
    public PostDto update(PostDto postDto) {
        Post post = postMapper.toEntity(postDto);
        PostDto postDto1 = postMapper.toDto(postRepository.save(post));//todo: odraditi validaciju i sve sto treba, bacanje greske ako nema post
        return postDto1;
    }

    @Override
    public PostDto save(PostDto postDto) {
        return postMapper.toDto(postRepository.save(postMapper.toEntity(postDto)));//todo: odraditi validaciju i sve sto treba, bacanje greske ako nema post
    }

    @Override
    public AttachmentDto addAttachment(Long postId,Long userId, MultipartFile file) throws IOException {
        Post post = postRepository.findById(postId).get();
        User user = userRepository.findById(userId).get();
        Attachment newAttachment = new Attachment();
        newAttachment.setUser(user);

        Path postFolder = Paths.get(POST_FOLDER+postId+"/attachments/"+file.getOriginalFilename());
        if (!Files.exists(postFolder)){
            Files.createDirectories(postFolder);
        }
        newAttachment.setUrl(postFolder.toAbsolutePath().toString());
        System.out.println("new Attachment postFolder.toAbsolutePath().toString(): " + newAttachment.getUrl());
        post.getAttachments().add(newAttachment);
        postRepository.save(post);

        Files.copy(file.getInputStream(),
                postFolder.resolve(file.getOriginalFilename()));

        Attachment attachmentWithId = attachmentRepository.findByUrl(newAttachment.getUrl()).get();

        System.out.println("NEW ATTACHMENT: " + attachmentWithId.getId());

        return attachmentMapper.toDto(attachmentWithId);
    }
}


