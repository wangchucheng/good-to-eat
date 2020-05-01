package com.wangchucheng.goodtoeat.favorite;

import javax.persistence.*;
import java.util.List;


@Entity
public class Favor {

    @Id
    @GeneratedValue
    private long userId;

    @Column
    private String openid;

    @ElementCollection
    private List<Long> recipeCollections;
    //这个里面存储了openid对应用户收藏的所有菜单


    public Favor() {

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

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
