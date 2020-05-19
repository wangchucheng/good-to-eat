package com.wangchucheng.goodtoeat.favorite;

public class FavorResult {
    private long id;
    private String title;
    private String image;
    private String timeNeeded;
    private String difficulty;
    private String nickname;//收藏的作者姓名
    private String profile;//收藏的作者头像

    public FavorResult(long id, String title, String image, String timeNeeded, String difficulty, String nickname, String profile) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.timeNeeded = timeNeeded;
        this.difficulty = difficulty;
        this.nickname = nickname;
        this.profile = profile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTimeNeeded() {
        return timeNeeded;
    }

    public void setTimeNeeded(String timeNeeded) {
        this.timeNeeded = timeNeeded;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
