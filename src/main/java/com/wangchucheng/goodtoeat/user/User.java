package com.wangchucheng.goodtoeat.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;


    @Column(nullable = false)
    private String openId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sex;


    private String profile;//avatar

    protected User() {
    }

    public User(String openId, String name, String sex){
        this.name=name;
        this.openId = openId;
        this.sex=sex;
    }

    public User(String openId, String name, String sex, String profile){
        this.name=name;
        this.openId = openId;
        this.profile=profile;
        this.sex=sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openid) {
        this.openId = openid;
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
