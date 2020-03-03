package com.wangchucheng.goodtoeat.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    @Autowired
   public  RecipeRepo recipeRepo;
    public boolean saveRecipe(String title, String image, String timeNeeded, String difficulty, String size){

        if(title!=null&&image!=null&&timeNeeded!=null&&difficulty!=null&&size!=null){
            Recipe re=new Recipe(title,image, timeNeeded,difficulty,size);
            recipeRepo.save(re);
            return true;
        }
        return false;
    }

}
