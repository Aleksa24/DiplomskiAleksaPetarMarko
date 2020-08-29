package com.example.app.controller;

import com.example.app.dto.attachment.AttachmentDto;
import com.example.app.dto.post.PostDto;
import com.example.app.entity.HttpResponse;
import com.example.app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all")
    public List<PostDto> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostDto findById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    //todo:videti kako da se imenuje kasnije
    @PostMapping("/addComment")
    public PostDto addComment(@RequestBody PostDto postDto){
        return postService.update(postDto);
    }
    @PostMapping("/save")
    public PostDto save(@RequestBody PostDto postDto){
        return postService.save(postDto);
    }

    @PostMapping("/addLike")
    public PostDto addLike(@RequestBody PostDto postDto){
        return this.postService.save(postDto);
    }


}

