package com.wangchucheng.goodtoeat.post;

import com.wangchucheng.goodtoeat.user.User;
import com.wangchucheng.goodtoeat.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    boolean savePost(Post post){
        if (post != null) {
            postRepo.save(post);
            return true;
        }
        return false;
    }

    List <PostResult> getPosts() {
        List <Post> posts= postRepo.findAllByIdGreaterThan(new Long(0));
        List <PostResult> postResults = new ArrayList <>();
        for(Post post: posts){
            User user = userRepo.findByOpenid(post.getOpenid());
            PostResult postResult = new PostResult(post.getId(), post.getOpenid(), user.getName(), user.getProfile(),
                    post.getImages(), post.getText(), post.getTime(), post.getRecipeid());
            postResults.add(postResult);
        }
        return postResults;
    }

    PostResult getPost(Long id) {
        Post post = postRepo.findAllById(id);
        User user = userRepo.findByOpenid(post.getOpenid());
        PostResult postResult = new PostResult(post.getId(), post.getOpenid(), user.getName(), user.getProfile(),
                post.getImages(), post.getText(), post.getTime(), post.getRecipeid());
        return postResult;
    }
}
