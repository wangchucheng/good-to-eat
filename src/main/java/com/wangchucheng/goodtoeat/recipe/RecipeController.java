package com.wangchucheng.goodtoeat.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
