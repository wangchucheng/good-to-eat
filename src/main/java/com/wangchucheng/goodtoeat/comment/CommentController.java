package com.wangchucheng.goodtoeat.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/recipe/{recipeId}")
    public boolean postRecipeComment(@PathVariable Long recipeId, @RequestBody Comment comment) {
        return commentService.saveRecipeComment(recipeId, comment);
    }

    @GetMapping(value = "/recipe/{recipeId}")
    public List <Comment> getRecipeComments(@PathVariable Long recipeId) {
        return commentService.selectRecipeComment(recipeId);
    }

    @PostMapping(value = "/post/{postId}")
    public boolean postPostComment(@PathVariable Long postId, @RequestBody Comment comment) {
        return commentService.savePostComment(postId, comment);
    }

    @GetMapping(value = "/post/{postId}")
    public List <Comment> getPostComments(@PathVariable Long postId) {
        return commentService.selectPostComment(postId);
    }
}
