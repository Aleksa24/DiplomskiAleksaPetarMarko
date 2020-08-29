package com.example.app.service;

import com.example.app.dto.attachment.AttachmentDto;
import com.example.app.dto.post.PostDto;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PostService {

    List<PostDto> findAll();

    PostDto findById(Long id);

    PostDto update(PostDto postDto);

    PostDto save(PostDto postDto);


}
