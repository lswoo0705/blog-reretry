package com.sparta.blogreretry.service;

import com.sparta.blogreretry.dto.PostCreateRequestDto;
import com.sparta.blogreretry.dto.PostInquiryResponseDto;
import com.sparta.blogreretry.dto.PostUpdateRequestDto;
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

    // 게시글 작성
    public Post createPost(PostCreateRequestDto postCreateRequestDto) {
        Post post = new Post(postCreateRequestDto);
        postRepository.save(post);
        return post;
    }

    // 게시글 전체 조회
    public List<PostInquiryResponseDto> inquiryAllPost() {
        List<Post> postList = postRepository.findAllByOrderByCreateAtDesc();
        List<PostInquiryResponseDto> postInquiryResponseDtoList = new ArrayList<>();
        for (Post post : postList) {
            postInquiryResponseDtoList.add(new PostInquiryResponseDto(post));
        }
        return postInquiryResponseDtoList;
    }

    // 게시글 선택 조회
    public PostInquiryResponseDto inquirySelectPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("조회하신 아이디의 게시글이 없습니다.")
        );
        return new PostInquiryResponseDto(post);
    }

    // 게시글 수정하기
//    public Post updatePost(PostUpdateRequestDto postUpdateRequestDto) {
//        Post post =
//    }
}