package com.sparta.blogreretry.controller;

import com.sparta.blogreretry.dto.PostCreateRequestDto;
import com.sparta.blogreretry.entity.Post;
import com.sparta.blogreretry.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {
    private final PostService postService;
    @PostMapping("/posts")
    public Post createPost(@RequestBody PostCreateRequestDto postCreateRequestDto) {
        return postService.createPost(postCreateRequestDto);
    }
}
