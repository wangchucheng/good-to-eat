package com.wangchucheng.goodtoeat.recipe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
    Recipe findAllById(Long id);
    Recipe findByTitle(String title);
}
