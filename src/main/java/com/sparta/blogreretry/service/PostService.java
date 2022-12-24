package com.sparta.blogreretry.service;

import com.sparta.blogreretry.dto.PostCreateRequestDto;
import com.sparta.blogreretry.dto.PostInquiryResponseDto;
import com.sparta.blogreretry.entity.Post;
import com.sparta.blogreretry.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor // 얘가 있어야 final이 붙어있는 레퍼지토리 필드에 연결
public class PostService {
    private final PostRepository postRepository;
    public Post createPost(PostCreateRequestDto postCreateRequestDto) {
        Post post = new Post(postCreateRequestDto);
        postRepository.save(post);
        return post;
    }

    public List<PostInquiryResponseDto> inquiryAllPost() {
        List<Post> postList = postRepository.findAllByOrderByCreateAtDesc();
        List<PostInquiryResponseDto> postInquiryResponseDtoList = new ArrayList<>();
        for (Post post : postList) {
            postInquiryResponseDtoList.add(new PostInquiryResponseDto(post));
        }
        return postInquiryResponseDtoList;
    }
}