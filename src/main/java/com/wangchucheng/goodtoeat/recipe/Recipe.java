package com.wangchucheng.goodtoeat.recipe;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;//标题

    @Column(nullable = false)
    private String image;//标题图

    @Column(nullable = false)
    private String timeNeeded;//耗时

    @Column(nullable = false)
    private String difficulty;

    @Column(nullable = false)
    private String size;//份量






}
