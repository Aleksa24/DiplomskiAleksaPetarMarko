package com.example.app.controller;

import com.example.app.entity.HttpResponse;
import com.example.app.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @DeleteMapping("/deleteLike/{likeId}")
    public HttpResponse deleteLike(@PathVariable("likeId") Long likeId){
        likeService.deleteLike(likeId);
        HttpResponse httpResponse = new HttpResponse(HttpStatus.OK.value(), HttpStatus.OK,"deleted like","deleted like");
        return httpResponse;
    }
}
