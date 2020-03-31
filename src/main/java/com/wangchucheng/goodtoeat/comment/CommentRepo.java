package com.wangchucheng.goodtoeat.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CommentRepo extends JpaRepository <Comment, Long> {
    @Nullable
    List <Comment> findAllByRecipeId(Long recipeId);

    @Nullable
    List <Comment> findAllByPostId(Long postId);

    int countByRecipeId(Long recipeId);
}
