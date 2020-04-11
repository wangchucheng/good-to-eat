package com.wangchucheng.goodtoeat.recipe;

import com.sun.istack.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
    Recipe findAllById(Long id);
    Recipe findByTitle(String title);

    @Nullable
    List<Recipe> findAllByOpenid(String openid);

}
