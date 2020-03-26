package com.wangchucheng.goodtoeat.recipe;

import javax.persistence.Embeddable;

@Embeddable
public class Step {
    private String image;
    private String description;

    public Step() {
    }

    public Step(String image,String description) {
        this.image=image;
        this.description=description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
