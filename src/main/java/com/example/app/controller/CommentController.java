package com.example.app.controller;

import com.example.app.dto.comment.CommentDto;
import com.example.app.dto.comment.CommentStatusDto;
import com.example.app.dto.like.LikeStatusDto;
import com.example.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public CommentDto findById(@PathVariable("id") Long id) {
        return commentService.findById(id);
    }

    @GetMapping("/comment-status/{name}")
    public CommentStatusDto findCommentStatusByName(@PathVariable("name") String name) {
        return commentService.findCommentStatusByName(name);
    }
    @PostMapping("/addReplay")
    public CommentDto addReplay(@RequestBody CommentDto commentDto){
        return this.commentService.save(commentDto);
    }

    @GetMapping("/like-status/{likeStatusString}")
    public LikeStatusDto findLikeStatusByName(@PathVariable("likeStatusString") String likeStatusString){
        return this.commentService.findLikeStatusByName(likeStatusString);
    }

}
