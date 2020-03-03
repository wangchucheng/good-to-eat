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

    @Column(nullable = false)
    private String timeNeeded;//耗时

    @Column(nullable = false)
    private String difficulty;

    @Column(nullable = false)
    private String size;//份量

    @Column(nullable = false)
    @ElementCollection
    private List<Ingredients> ingredientsList;

    @Column(nullable = false)
    @ElementCollection
    private List<Nutrition> nutritionList;

    @Column(nullable = false)
    @ElementCollection
    private List<Step> stepList;

    public Recipe() {
    }

    public Recipe(String title,String image,String timeNeeded,String difficulty,String size){
        this.title=title;
        this.image=image;
        this.timeNeeded=timeNeeded;
        this.difficulty=difficulty;
        this.size=size;
    }

    public List<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public List<Nutrition> getNutritionList() {
        return nutritionList;
    }

    public void setNutritionList(List<Nutrition> nutritionList) {
        this.nutritionList = nutritionList;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
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
