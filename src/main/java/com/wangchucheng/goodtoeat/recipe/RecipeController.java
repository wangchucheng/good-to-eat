package com.wangchucheng.goodtoeat.recipe;

import com.wangchucheng.goodtoeat.user.User;
import com.wangchucheng.goodtoeat.user.UserRepo;
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
    UserRepo userRepo;


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
        breakfast.add(recipeService.findRecipe(0L));
        lunch.add(recipeService.findRecipe(1L));
        dinner.add(recipeService.findRecipe(2L));
        TodayRes result=new TodayRes(breakfast,lunch,dinner);
        return result;
    }

    @GetMapping(value="/recommendation")
    public List<Recipe> getRecomendRecipe(@RequestParam String openid) throws TasteException {
        List<Recipe> result=new ArrayList<>();
        User user=userRepo.findByOpenid(openid);
//        recipeService.getRecommend(user.getId());
        result.add(recipeService.findRecipe(0L));
        return result;
    }

    @GetMapping(value="/{id}")
    public Recipe getRecipeInfo(@PathVariable Long id){
        return recipeService.findRecipe(id);
    }


}
