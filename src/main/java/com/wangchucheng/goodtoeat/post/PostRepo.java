package com.wangchucheng.goodtoeat.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    Post findAllById(Long id);
    List <Post> findAllByIdGreaterThan(Long id);
}
