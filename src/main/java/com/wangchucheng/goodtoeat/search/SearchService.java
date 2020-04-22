package com.wangchucheng.goodtoeat.search;

import com.wangchucheng.goodtoeat.recipe.Recipe;
import com.wangchucheng.goodtoeat.recipe.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private RecipeRepo recipeRepo;

    public List <Recipe> searchRecipe(String keyword) {
        return recipeRepo.findByTitleContainingOrIngredientsContaining(keyword, keyword);
    }
}
