package com.wangchucheng.goodtoeat.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    Post findAllById(Long id);

    @Nullable
    List <Post> findAllByOpenid(String openid);
}
