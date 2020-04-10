package com.wangchucheng.goodtoeat.recommendation;

public class RecommendationDto {
    private Long id;
    private String openid;
    private String name;
    private String profile;
    private String title;
    private String image;
    private String timeNeeded;
    private String difficulty;
    private int favoriteNum;
    private int commentNum;

    public RecommendationDto() {
    }

    public RecommendationDto(Long id, String openid, String name, String profile,
                             String title, String image, String timeNeeded, String difficulty,
                             int favoriteNum, int commentNum) {
        this.id = id;
        this.openid = openid;
        this.name = name;
        this.profile = profile;
        this.title = title;
        this.image = image;
        this.timeNeeded = timeNeeded;
        this.difficulty = difficulty;
        this.favoriteNum = favoriteNum;
        this.commentNum = commentNum;
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

    public int getFavoriteNum() {
        return favoriteNum;
    }

    public void setFavoriteNum(int favoriteNum) {
        this.favoriteNum = favoriteNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }
}
