package com.wangchucheng.goodtoeat.recipe;


import javax.persistence.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String openid;

    @Column(nullable = false)
    private String title;//标题

    @Column(nullable = false)
    private String image;//标题图

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String timeNeeded;//耗时

    @Column(nullable = false)
    private String difficulty;

    @Column(nullable = false)
    private String size;//份量

    @Column(nullable = false)
    private String ingredients;

    @Column(nullable = false)
    private String nutrition;

    @Column(nullable = false)
    private String steps;

    @Column(nullable = false)
    private int collectedTimes;

    public int getCollectedTimes() {
        return collectedTimes;
    }

    public void setCollectedTimes(int collectedTimes) {
        this.collectedTimes = collectedTimes;
    }

    public Recipe() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Recipe(String openid, String title, String image, String timeNeeded, String difficulty, String size,int collectedTimes){
        this.openid = openid;
        this.title=title;
        this.image=image;
        this.timeNeeded=timeNeeded;
        this.difficulty=difficulty;
        this.size=size;
        this.collectedTimes=collectedTimes;
    }

    public String getIngredients() {

        return ingredients;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setIngredients(String ingredientsList) {
        this.ingredients = ingredientsList;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutritionList) {
        this.nutrition = nutritionList;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String stepList) {
        this.steps = stepList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
