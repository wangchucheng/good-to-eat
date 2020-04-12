package com.wangchucheng.goodtoeat.favorite;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

class FavorResult{
    private long id;
    private String title;
    private String image;
    private String timeNeeded;
    private String difficulty;

    public FavorResult(long id, String title, String image, String timeNeeded, String difficulty) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.timeNeeded = timeNeeded;
        this.difficulty = difficulty;
    }
}

@Entity
public class Favor {
    @Id
    private String openid;

    @ElementCollection
    private List<Long> recipeCollections;
    //这个里面存储了openid对应用户收藏的所有菜单


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public List<Long> getRecipeCollections() {
        return recipeCollections;
    }

    public void setRecipeCollections(List<Long> recipeCollections) {
        this.recipeCollections = recipeCollections;
    }
}
