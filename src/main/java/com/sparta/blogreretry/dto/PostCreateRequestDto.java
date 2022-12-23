package com.sparta.blogreretry.dto;

import lombok.Getter;

@Getter
public class PostCreateRequestDto {
    private String title;
    private String writer;
    private String content;
    private String password;

}
