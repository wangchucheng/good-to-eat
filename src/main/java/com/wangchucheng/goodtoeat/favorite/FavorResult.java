package com.wangchucheng.goodtoeat.favorite;

public class FavorResult {
    private long id;
    private String title;
    private String image;
    private String timeNeeded;
    private String difficulty;

    public FavorResult(long id, String title, String image, String timeNeeded, String difficulty) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.timeNeeded = timeNeeded;
        this.difficulty = difficulty;
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
