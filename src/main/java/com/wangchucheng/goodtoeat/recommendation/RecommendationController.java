package com.wangchucheng.goodtoeat.recommendation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recommendation")
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;

    @GetMapping(value = "/user/{openid}")
    public Pagination <List <RecommendationDto>> getRecommendationByUserId(@PathVariable String openid,
                                                                           @RequestParam int page,
                                                                           @RequestParam int size) {
        return recommendationService.selectRecipesByOpenid(openid, page, size);
    }
}
