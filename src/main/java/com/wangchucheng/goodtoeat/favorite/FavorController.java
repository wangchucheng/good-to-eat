package com.wangchucheng.goodtoeat.favorite;

import com.wangchucheng.goodtoeat.recipe.Recipe;
import com.wangchucheng.goodtoeat.recipe.RecipeService;
import com.wangchucheng.goodtoeat.user.User;
import com.wangchucheng.goodtoeat.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/favorite")
public class FavorController {
    @Autowired
    RecipeService recipeService;

    @Autowired
    FavorService favorService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/user/{openid}")
    List<FavorResult> getUserCollection(@PathVariable String openid){
        List<Long> collections=favorService.getCollections(openid);
        List<FavorResult> res=new ArrayList<>();
        for(int i=0;i<collections.size();i++){
            Recipe re=recipeService.findRecipe(collections.get(i));
            User author=userService.findUser(re.getOpenid());
            res.add(new FavorResult(re.getId(),re.getTitle(),re.getImage(),re.getTimeNeeded(),re.getDifficulty(),author.getName(),author.getProfile()));
        }
        return res;
    }

    @GetMapping(value = "/recipe/{id}/number")
    int getCollectedTimes(@PathVariable Long id){

        Recipe re=recipeService.findRecipe(id);
        if(re!=null) {
         return re.getCollectedTimes();
        }else{
            return 0;
        }
    }

    @PostMapping(value = "/user/{openid}/recipe/{id}")
    boolean collect(@PathVariable String openid,@PathVariable long id){
        return favorService.collectRe(openid,id);
    }

    @DeleteMapping(value = "/recipe/{id}")
    boolean cancelCollect(@PathVariable long id, @RequestBody User user){
        return favorService.cancelCol(user.getOpenid(),id);
    }
}
