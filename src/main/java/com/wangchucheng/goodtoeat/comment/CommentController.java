package com.wangchucheng.goodtoeat.comment;

import com.wangchucheng.goodtoeat.user.User;
import com.wangchucheng.goodtoeat.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "/recipe/{recipeId}")
    public boolean postRecipeComment(@PathVariable Long recipeId, @RequestBody Comment comment) {
        return commentService.saveRecipeComment(recipeId, comment);
    }

    @GetMapping(value = "/recipe/{recipeId}")
    public List <commentResult> getRecipeComments(@PathVariable Long recipeId) {
        List<Comment> co=commentService.selectRecipeComment(recipeId);
        List<commentResult> res=new ArrayList<>();
        for(int i=0;i<co.size();i++){
            String openid=co.get(i).getOpenid();
            String content=co.get(i).getContent();
            User u=userService.findUser(openid);
            String profile=u.getProfile();
            String name=u.getName();
            res.add(new commentResult(openid,profile,name,content));
        }
        return res;
    }

    @PostMapping(value = "/post/{postId}")
    public boolean postPostComment(@PathVariable Long postId, @RequestBody Comment comment) {
        return commentService.savePostComment(postId, comment);
    }

    @GetMapping(value = "/post/{postId}")
    public List <commentResult> getPostComments(@PathVariable Long postId) {
        List<Comment> co=commentService.selectPostComment(postId);
        List<commentResult> res=new ArrayList<>();
        for(int i=0;i<co.size();i++){
            String openid=co.get(i).getOpenid();
            String content=co.get(i).getContent();
            User u=userService.findUser(openid);
            String profile=u.getProfile();
            String name=u.getName();
            res.add(new commentResult(openid,profile,name,content));
        }
        return res;
    }
}
