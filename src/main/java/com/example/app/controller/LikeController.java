package com.example.app.controller;

import com.example.app.dto.like.LikeDto;
import com.example.app.entity.HttpResponse;
import com.example.app.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/save")
    public LikeDto save(@RequestBody LikeDto likeDto){
        return likeService.save(likeDto);
    }

    @DeleteMapping("/deleteLike/{likeId}")
    public HttpResponse deleteLike(@PathVariable("likeId") Long likeId){
        likeService.deleteLike(likeId);
        HttpResponse httpResponse = new HttpResponse(HttpStatus.OK.value(), HttpStatus.OK,"deleted like","deleted like");
        return httpResponse;
    }
}
