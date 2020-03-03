package com.wangchucheng.goodtoeat.recipe;

import javax.persistence.Embeddable;

@Embeddable
public class Nutrition {
    private String name;
    private String amount;

    public Nutrition() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
