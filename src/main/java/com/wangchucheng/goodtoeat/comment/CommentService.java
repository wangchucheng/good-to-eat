package com.wangchucheng.goodtoeat.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;

    public boolean saveRecipeComment(Long recipeId, Comment comment) {
        comment.setRecipeId(recipeId);
        commentRepo.save(comment);
        return true;
    }

    public List <Comment> selectRecipeComment(Long recipeId) {
        return commentRepo.findAllByRecipeId(recipeId);
    }

    public boolean savePostComment(Long postId, Comment comment) {
        comment.setPostId(postId);
        commentRepo.save(comment);
        return true;
    }

    public List <Comment> selectPostComment(Long postId) {
        return commentRepo.findAllByPostId(postId);
    }
}
