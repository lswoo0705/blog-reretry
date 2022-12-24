package com.sparta.blogreretry.dto;

import com.sparta.blogreretry.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostInquiryResponseDto {
    private final String title;
    private final String writer;
    private final String content;
    private final LocalDateTime dateCreated;
    private final LocalDateTime dateUpdated;

    public PostInquiryResponseDto(Post post) {
        this.title = post.getTitle();
        this.writer = post.getWriter();
        this.content = post.getContent();
        this.dateCreated = post.getCreateAt();
        this.dateUpdated = post.getModifyAt();
    }
}
