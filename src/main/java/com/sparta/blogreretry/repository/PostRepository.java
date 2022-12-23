package com.sparta.blogreretry.repository;

import com.sparta.blogreretry.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
