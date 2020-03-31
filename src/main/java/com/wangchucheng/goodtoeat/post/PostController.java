package com.wangchucheng.goodtoeat.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean postPost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List <PostResult> getPosts(@RequestParam @Nullable String openid) {
        return postService.getPosts(openid);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public PostResult getPosts(@PathVariable Long id) {
        return postService.getPost(id);
    }
}
