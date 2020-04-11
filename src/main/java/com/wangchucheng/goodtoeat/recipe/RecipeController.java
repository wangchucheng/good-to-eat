package com.wangchucheng.goodtoeat.recipe;

import com.sun.istack.Nullable;
import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public TodayRes getTodayRecipe(@RequestParam String openid) throws TasteException {
    //应该用推荐算法的，暂时用随机来代替
        List<Recipe> breakfast=new ArrayList<>();
        List<Recipe> lunch=new ArrayList<>();
        List<Recipe> dinner=new ArrayList<>();
        /*User user=userRepo.findByOpenid(openid);
        List<RecommendedItem> recItems=recipeService.getRecommend(user.getId());
        for(RecommendedItem recommendation:recItems){
        }
         */
        if(recipeService.findRecipe(0L)!=null) {
            breakfast.add(recipeService.findRecipe(0L));
            lunch.add(recipeService.findRecipe(0L));
            dinner.add(recipeService.findRecipe(0L));
        }else{
            //如果数据不够，用这个做测试
            Recipe test=new Recipe();
            test.setId(10L);
            test.setTitle("测试菜例");
            test.setImage("https://img-global.cpcdn.com/012_recipes/477df03d4329e08296d2932427895151/1200x630cq70/photo.jpg");
            breakfast.add(test);
            lunch.add(test);
            dinner.add(test);
        }
        TodayRes result=new TodayRes(breakfast,lunch,dinner);
        return result;
    }

    @GetMapping(value="/recommendation")
    public List<Recipe> getRecommendRecipe(@RequestParam String openid) throws TasteException {
        List<Recipe> result=new ArrayList<>();
  //      User user=userRepo.findByOpenid(openid);
//        recipeService.getRecommend(user.getId());
        if(recipeService.findRecipe(0L)!=null) {
            result.add(recipeService.findRecipe(0L));
        }else{
            //如果数据不够，用这个做测试
            Recipe test=new Recipe();
            test.setId(10L);
            test.setTitle("测试菜例");
            test.setImage("https://img-global.cpcdn.com/012_recipes/477df03d4329e08296d2932427895151/1200x630cq70/photo.jpg");
            result.add(test);

        }
        return result;
    }

    @GetMapping(value="/{id}")
    public Recipe getRecipeInfo(@PathVariable Long id){

        Recipe s=recipeService.findRecipe(id);
        if(s==null){
            //如果数据不够，用这个做测试
            Recipe test=new Recipe();
            String ingre="黄油200g,面粉300g,酵母3g";
            String nutris="维他命A 2%, 蛋白质 30%";
            String steps="1. 将黄油切碎，与面粉混合均匀 2. 将酵母放入适当水中化开，并与第一步中的食物混合 3. 揉成一个面团";
            test.setId(10L);
            test.setTitle("测试菜例");
            test.setImage("https://img-global.cpcdn.com/012_recipes/477df03d4329e08296d2932427895151/1200x630cq70/photo.jpg");
            test.setTimeNeeded("10min");
            test.setDifficulty("easy");
            test.setSize("medium");
            test.setIngredients(ingre);
            test.setNutrition(nutris);
            test.setSteps(steps);
            return test;
        }else{
            return s;
        }
    }
    //获取食谱列表
    @GetMapping
    public List<Recipe> getRecipeList(@RequestParam @Nullable String openid){
        return recipeService.findUserRecipe(openid);
    }
}
