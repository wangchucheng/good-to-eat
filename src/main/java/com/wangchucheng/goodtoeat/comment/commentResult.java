package com.wangchucheng.goodtoeat.comment;

public class commentResult {
    private String openid;
    private String profile;
    private String name;
    private String content;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public commentResult(String openid, String profile, String name, String content) {
        this.openid = openid;
        this.profile = profile;
        this.name = name;
        this.content = content;
    }
}
