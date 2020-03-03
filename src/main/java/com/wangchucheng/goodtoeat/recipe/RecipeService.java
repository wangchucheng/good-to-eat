package com.wangchucheng.goodtoeat.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    @Autowired
   public  RecipeRepo recipeRepo;
    public boolean saveRecipe(Recipe recipe){

        if(recipe != null){
            recipeRepo.save(recipe);
            return true;
        }
        return false;
    }

}
