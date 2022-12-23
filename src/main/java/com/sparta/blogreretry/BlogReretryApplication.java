package com.sparta.blogreretry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlogReretryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogReretryApplication.class, args);
    }

}
