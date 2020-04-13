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
}
