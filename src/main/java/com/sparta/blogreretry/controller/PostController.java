package com.sparta.blogreretry.controller;

import com.sparta.blogreretry.dto.PostCreateRequestDto;
import com.sparta.blogreretry.dto.PostInquiryResponseDto;
import com.sparta.blogreretry.dto.PostUpdateRequestDto;
import com.sparta.blogreretry.entity.Post;
import com.sparta.blogreretry.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시글 작성하기
    @PostMapping("/posts")
    public Post createPost(@RequestBody PostCreateRequestDto postCreateRequestDto) {
        return postService.createPost(postCreateRequestDto);
    }

    // 게시글 전체 조회하기
    @GetMapping("/posts")
    public List<PostInquiryResponseDto> inquiryAllPost() {
        return postService.inquiryAllPost();
    }

    // 게시글 선택 조회하기
    @GetMapping("/posts/{id}")
    public PostInquiryResponseDto inquirySelectPost(@PathVariable Long id) {
        return postService.inquirySelectPost(id);
    }

    // 게시글 수정하기
    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto postUpdateRequestDto) {
        return postService.updatePost(id, postUpdateRequestDto);
    }
}
