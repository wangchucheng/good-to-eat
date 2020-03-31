package com.wangchucheng.goodtoeat.recommendation;

import com.wangchucheng.goodtoeat.comment.CommentRepo;
import com.wangchucheng.goodtoeat.recipe.Recipe;
import com.wangchucheng.goodtoeat.recipe.RecipeRepo;
import com.wangchucheng.goodtoeat.user.User;
import com.wangchucheng.goodtoeat.user.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class RecommendationService {
    @Autowired
    private RecipeRepo recipeRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CommentRepo commentRepo;

    public Pagination <List <RecommendationDto>> selectRecipesByOpenid(String openid, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page <Recipe> recipes = recipeRepo.findAll(pageable);
        if (recipes != null) {
            Type dtoType = new TypeToken <List <RecommendationDto>>(){}.getType();
            ModelMapper modelMapper = new ModelMapper();
            List <RecommendationDto> recommendations = modelMapper.map(recipes.getContent(), dtoType);
            for (RecommendationDto recommendation : recommendations) {
                User user = userRepo.findByOpenid(recommendation.getOpenid());
                recommendation.setName(user.getName());
                recommendation.setProfile(user.getProfile());
                recommendation.setFavoriteNum(0);
                recommendation.setCommentNum(commentRepo.countByRecipeId(recommendation.getId()));
            }
            return new Pagination <>(recipes.getTotalElements(), recipes.getTotalPages(), recommendations);
        } else {
            return null;
        }
    }
}
