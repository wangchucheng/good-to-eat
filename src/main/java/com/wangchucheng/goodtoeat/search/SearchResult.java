package com.wangchucheng.goodtoeat.search;

public class SearchResult {
    private String recipeId;
    private String name;
    private String image;
    private String timeNeeded;
    private String difficulty;

    public SearchResult() {
    }

    public SearchResult(String recipeId, String name, String image, String timeNeeded, String difficulty) {
        this.recipeId = recipeId;
        this.name = name;
        this.image = image;
        this.timeNeeded = timeNeeded;
        this.difficulty = difficulty;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
