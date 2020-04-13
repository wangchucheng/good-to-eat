package com.wangchucheng.goodtoeat.favorite;

import com.wangchucheng.goodtoeat.recipe.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FavorService {
    @Autowired
  FavorRepo favorRepo;
    @Autowired
  RecipeRepo recipeRepo;
  List<Long> getCollections(String openid){
      List<Long> res=new ArrayList<>();
      Favor f=favorRepo.findByOpenid(openid);
      if(f!=null) {
          res = f.getRecipeCollections();
      }
      return res;
  }

  boolean collectRe(String openid,long id){
      if(favorRepo.findByOpenid(openid)!=null&&recipeRepo.findAllById(id)!=null){
          List<Long> sl=favorRepo.findByOpenid(openid).getRecipeCollections();
          sl.add(id);
          int sum=recipeRepo.findAllById(id).getCollectedTimes()+1;
          recipeRepo.findAllById(id).setCollectedTimes(sum);
          favorRepo.findByOpenid(openid).setRecipeCollections(sl);
          return true;
      }
      return false;

  }
  boolean cancelCol(String openid, long id){
      if(favorRepo.findByOpenid(openid)!=null&&recipeRepo.findAllById(id)!=null){
          List<Long> sl=favorRepo.findByOpenid(openid).getRecipeCollections();
          if(sl.indexOf(id)!=-1){
              sl.remove(id);
              favorRepo.findByOpenid(openid).setRecipeCollections(sl);
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
