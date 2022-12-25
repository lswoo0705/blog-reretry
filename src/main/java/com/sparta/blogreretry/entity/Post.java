package com.sparta.blogreretry.entity;

import com.sparta.blogreretry.dto.PostCreateRequestDto;
import com.sparta.blogreretry.dto.PostUpdateRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Post extends TimeStamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String writer;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String password;

    public Post(PostCreateRequestDto postCreateRequestDto) {
        this.title = postCreateRequestDto.getTitle();
        this.writer = postCreateRequestDto.getWriter();
        this.content = postCreateRequestDto.getContent();
        this.password = postCreateRequestDto.getPassword();
    }

    public boolean isValidPassword(String inputPassword) {
        if (inputPassword.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }

    public void updatePost(PostUpdateRequestDto postUpdateRequestDto) {
        this.title = postUpdateRequestDto.getTitle();
        this.writer = postUpdateRequestDto.getWriter();
        this.content = postUpdateRequestDto.getContent();
    }
}
