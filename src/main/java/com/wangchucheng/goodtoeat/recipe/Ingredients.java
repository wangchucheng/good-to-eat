package com.wangchucheng.goodtoeat.recipe;

public class Ingredients {
    private String name;//用料名
    private String amount;//用量，单位为g

    public Ingredients(String name, String amount) {
        this.name = name;
        this.amount = amount;
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
