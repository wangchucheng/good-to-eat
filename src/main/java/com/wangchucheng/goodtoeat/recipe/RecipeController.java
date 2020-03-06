package com.wangchucheng.goodtoeat.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/recipe")
public class RecipeController {
    @Autowired
    RecipeService recipeService;


    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean postRecipeInfo(@RequestBody Recipe recipe){
        boolean isSuccess=recipeService.saveRecipe(recipe);
        return isSuccess;
    }

    @GetMapping(value="/today")
    public TodayRes getTodayRecipe(@RequestParam String openid, @RequestParam Timestamp time){
    //应该用推荐算法的，暂时用随机来代替
        List<Recipe> breakfast=new ArrayList<>();
        List<Recipe> lunch=new ArrayList<>();
        List<Recipe> dinner=new ArrayList<>();

        TodayRes result=new TodayRes(breakfast,lunch,dinner);
        return result;
    }

    @GetMapping(value="/recommendation")
    public List<Recipe> getRecomendRecipe(@RequestParam String openid, @RequestParam Timestamp time){
        List<Recipe> result=new ArrayList<>();

        return result;
    }

    @GetMapping(value="/{id}")
    public Recipe getRecipeInfo(@PathVariable Long id){
        return recipeService.findRecipe(id);
    }


}
