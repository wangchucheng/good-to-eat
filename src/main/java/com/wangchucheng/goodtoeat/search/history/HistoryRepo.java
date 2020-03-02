package com.wangchucheng.goodtoeat.search.history;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepo extends JpaRepository<History, Long> {
    List <History> findAllByOpenid(String openid);
}
