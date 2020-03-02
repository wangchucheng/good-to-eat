package com.wangchucheng.goodtoeat.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @Column(nullable = false)
    private String openId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sex;


    private String profile;//avatar

    protected User() {
    }

    public User(String openId,String name,String sex,String profile){
        this.name=name;
        this.openId=openId;
        this.profile=profile;
        this.sex=sex;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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
