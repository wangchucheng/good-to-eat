package com.wangchucheng.goodtoeat.search;

import com.wangchucheng.goodtoeat.recipe.Recipe;
import com.wangchucheng.goodtoeat.recipe.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    @Autowired
    private RecipeRepo recipeRepo;

    public List <Recipe> searchRecipe(String title) {
        Recipe recipe = recipeRepo.findByTitle(title);
        recipe.setSize(null);
        recipe.setIngredients(null);
        recipe.setNutrition(null);
        recipe.setSteps(null);
        List <Recipe> recipes = new ArrayList <>();
        recipes.add(recipe);
        return recipes;
    }
}
