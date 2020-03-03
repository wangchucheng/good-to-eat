package com.wangchucheng.goodtoeat.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/recipe")
public class RecipeController {
    @Autowired
    RecipeService recipeService;
    @PostMapping(value="")
    public boolean postRecipeInfo(@RequestParam("title") String title,
                                  @RequestParam("image") String image,
                                  @RequestParam("timeNeeded") String timeNeeded,
                                  @RequestParam("difficulty") String difficulty,
                                  @RequestParam("size") String size){
        boolean isSuccess=recipeService.saveRecipe(title,image,timeNeeded,difficulty,size);
        return isSuccess;

    }

}
