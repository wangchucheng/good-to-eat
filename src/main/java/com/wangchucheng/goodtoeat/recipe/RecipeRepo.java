package com.wangchucheng.goodtoeat.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
    Recipe findAllById(Long id);

    @Nullable
    List <Recipe> findByTitleContainingOrIngredientsContaining(String title, String ingredients);

    @Nullable
    List<Recipe> findAllByOpenid(String openid);

}
