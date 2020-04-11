package com.wangchucheng.goodtoeat.user;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String openid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private String profile;//avatar

    @ElementCollection
    private List<String> follower;//我的粉丝们

    @ElementCollection
    private List<String> follow;//我的关注们


    protected User() {
    }

    public List<String> getFollow() {
        return follow;
    }

    public void setFollow(List<String> follow) {
        this.follow = follow;
    }

    public List<String> getFollower() {
        return follower;
    }

    public void setFollower(List<String> follower) {
        this.follower = follower;
    }

    public User(String openid, String name, String sex, String profile){
        this.name=name;
        this.openid = openid;
        this.profile=profile;
        this.sex=sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
