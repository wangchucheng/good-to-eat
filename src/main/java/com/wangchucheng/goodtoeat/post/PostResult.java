package com.wangchucheng.goodtoeat.post;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.sql.Timestamp;
import java.util.List;

public class PostResult {
    private Long id;
    private String openid;
    private String name;
    private String profile;
    private List <String> images;
    private String text;
    private Timestamp time;
    private String recipeid;

    public PostResult() {
    }

    public PostResult(Long id, String openid, String name, String profile,
                      List <String> images, String text, Timestamp time, String recipeid) {
        this.id = id;
        this.openid = openid;
        this.name = name;
        this.profile = profile;
        this.images = images;
        this.text = text;
        this.time = time;
        this.recipeid = recipeid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
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

    public String getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(String recipeid) {
        this.recipeid = recipeid;
    }
}
