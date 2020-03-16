package com.wangchucheng.goodtoeat.recipe;


import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;//标题

    @Column(nullable = false)
    private String image;//标题图

    @Column(nullable = true)
    private String time;

    @Column(nullable = false)
    private String timeNeeded;//耗时

    @Column(nullable = false)
    private String difficulty;

    @Column(nullable = false)
    private String size;//份量

    @Column(nullable = false)
    @ElementCollection
    private List<Ingredients> ingredients;

    @Column(nullable = false)
    @ElementCollection
    private List<Nutrition> nutrition;

    @Column(nullable = false)
    @ElementCollection
    private List<Step> steps;

    public Recipe() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Recipe(String title, String image, String timeNeeded, String difficulty, String size){
        this.title=title;
        this.image=image;
        this.timeNeeded=timeNeeded;
        this.difficulty=difficulty;
        this.size=size;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredientsList) {
        this.ingredients = ingredientsList;
    }

    public List<Nutrition> getNutrition() {
        return nutrition;
    }

    public void setNutrition(List<Nutrition> nutritionList) {
        this.nutrition = nutritionList;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> stepList) {
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