package com.wangchucheng.goodtoeat.recipe;


//today的返回结果

import java.util.List;

public class TodayRes {
    List<Recipe> breakfastRecipes;
    List<Recipe> lunchRecipes;
    List<Recipe> dinnerRecipes;

    public TodayRes(List<Recipe> breakfastRecipes, List<Recipe> lunchRecipes, List<Recipe> dinnerRecipes) {
        this.breakfastRecipes = breakfastRecipes;
        this.lunchRecipes = lunchRecipes;
        this.dinnerRecipes = dinnerRecipes;
    }

    public List<Recipe> getBreakfastRecipes() {
        return breakfastRecipes;
    }

    public void setBreakfastRecipes(List<Recipe> breakfastRecipes) {
        this.breakfastRecipes = breakfastRecipes;
    }

    public List<Recipe> getLunchRecipes() {
        return lunchRecipes;
    }

    public void setLunchRecipes(List<Recipe> lunchRecipes) {
        this.lunchRecipes = lunchRecipes;
    }

    public List<Recipe> getDinnerRecipes() {
        return dinnerRecipes;
    }

    public void setDinnerRecipes(List<Recipe> dinnerRecipes) {
        this.dinnerRecipes = dinnerRecipes;
    }
}
