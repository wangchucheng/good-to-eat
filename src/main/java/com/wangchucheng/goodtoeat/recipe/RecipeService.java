package com.wangchucheng.goodtoeat.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
   public  RecipeRepo recipeRepo;
    public boolean saveRecipe(String title,
                              String image,
                              String timeNeeded,
                              String difficulty,
                              String size,
                              List<Ingredients> ingredientsList,
                              List<Nutrition> nutritionList,
                              List<Step> stepList){

        if(title!=null&&image!=null&&timeNeeded!=null&&difficulty!=null&&size!=null&&ingredientsList!=null&&nutritionList!=null&& stepList!=null){
            Recipe re=new Recipe(title,image, timeNeeded,difficulty,size);
            recipeRepo.save(re);
            return true;
        }
        return false;
    }

}
