package com.wangchucheng.goodtoeat.like;

import com.wangchucheng.goodtoeat.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/like")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping(value = "/post/{postId}")
    public boolean postLike(@PathVariable Long postId, @RequestBody User user) {
        return likeService.saveLike(postId, user.getOpenid());
    }

    @DeleteMapping(value = "/post/{postId}")
    public boolean deleteLike(@PathVariable Long postId, @RequestBody User user) {
        return likeService.deleteLike(postId, user.getOpenid());
    }

    @GetMapping(value = "/post/{postId}/number")
    public int getLikeNumber(@PathVariable Long postId) {
        return likeService.selectLikeNumber(postId);
    }
}
