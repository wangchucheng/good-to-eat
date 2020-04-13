package com.wangchucheng.goodtoeat.favorite;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FavorRepo extends JpaRepository<Favor,Long> {
    Favor findByOpenid(String openid);
}
