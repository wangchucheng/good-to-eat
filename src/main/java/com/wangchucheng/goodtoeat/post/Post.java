package com.wangchucheng.goodtoeat.post;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String openid;

    @Column(nullable = false)
    @ElementCollection
    private List <String> images;

    private String text;

    @Column(nullable = false)
    private Timestamp time;

    private String recipeId;

    public Post() {
    }

    public Post(String openid, List <String> images, String text, Timestamp time, String recipeId) {
        this.openid = openid;
        this.images = images;
        this.text = text;
        this.time = time;
        this.recipeId = recipeId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public List <String> getImages() {
        return images;
    }

    public void setImages(List <String> images) {
        this.images = images;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }
}
