package com.wangchucheng.goodtoeat.search.history;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class History {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String openid;

    @Column(nullable = false)
    private String word;

    private Timestamp time;

    public History() {
    }

    public History(String openid, String word, Timestamp time) {
        this.openid = openid;
        this.word = word;
        this.time = time;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
