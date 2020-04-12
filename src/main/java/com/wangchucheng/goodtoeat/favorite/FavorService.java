package com.wangchucheng.goodtoeat.favorite;

import com.wangchucheng.goodtoeat.recipe.RecipeRepo;

import java.util.List;

public class FavorService {
  FavorRepo favorRepo;
  RecipeRepo recipeRepo;
  List<Long> getCollections(String openid){
      return favorRepo.findAllByOpenid(openid).getRecipeCollections();
  }

  boolean collectRe(String openid,long id){
      if(favorRepo.findAllByOpenid(openid)!=null&&recipeRepo.findAllById(id)!=null){
          List<Long> sl=favorRepo.findAllByOpenid(openid).getRecipeCollections();
          sl.add(id);
          int sum=recipeRepo.findAllById(id).getCollectedTimes()+1;
          recipeRepo.findAllById(id).setCollectedTimes(sum);
          favorRepo.findAllByOpenid(openid).setRecipeCollections(sl);
          return true;
      }
      return false;

  }
  boolean cancelCol(String openid, long id){
      if(favorRepo.findAllByOpenid(openid)!=null&&recipeRepo.findAllById(id)!=null){
          List<Long> sl=favorRepo.findAllByOpenid(openid).getRecipeCollections();
          if(sl.indexOf(id)!=-1){
              sl.remove(id);
              favorRepo.findAllByOpenid(openid).setRecipeCollections(sl);
              int sum=recipeRepo.findAllById(id).getCollectedTimes()-1;
              recipeRepo.findAllById(id).setCollectedTimes(sum);
              return true;
          }else{
              return false;
          }
      }else{
          return false;
      }
  }
}
