package com.wangchucheng.goodtoeat.like;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "post_like")
public class Like {
    @Id
    private Long postId;

    @ElementCollection
    private List <String> users;

    public Like() {
    }

    public Like(Long postId) {
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public List <String> getUsers() {
        return users;
    }

    public void setUsers(List <String> users) {
        this.users = users;
    }
}
