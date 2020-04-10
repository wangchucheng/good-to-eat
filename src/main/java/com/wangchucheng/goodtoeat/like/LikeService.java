package com.wangchucheng.goodtoeat.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepo likeRepo;

    public boolean initLike(Long postId) {
        Like like = new Like(postId);
        likeRepo.save(like);
        return true;
    }

    public boolean saveLike(Long postId, String openid) {
        Optional <Like> likeOptional = likeRepo.findById(postId);
        if (!likeOptional.isPresent()) {
            initLike(postId);
            likeOptional = likeRepo.findById(postId);
        }
        Like like = likeOptional.get();
        List <String> users= like.getUsers();
        if (users == null) {
            users = new ArrayList <>();
        }
        if (!users.contains(openid)) {
            users.add(openid);
            like.setUsers(users);
            likeRepo.save(like);
        }
        return true;
    }

    public boolean deleteLike(Long postId, String openid) {
        Optional <Like> likeOptional = likeRepo.findById(postId);
        if (likeOptional.isPresent()) {
            Like like = likeOptional.get();
            List <String> users= like.getUsers();
            if (users.contains(openid)) {
                users.remove(openid);
                like.setUsers(users);
                likeRepo.save(like);
            }
        }
        return true;
    }

    public int selectLikeNumber(Long postId) {
        Optional <Like> likeOptional = likeRepo.findById(postId);
        return likeOptional.map(like -> like.getUsers().size()).orElse(0);
    }
}
