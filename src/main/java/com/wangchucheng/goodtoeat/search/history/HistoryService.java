package com.wangchucheng.goodtoeat.search.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepo historyRepo;

    public boolean saveHistory(String openid, String word) {
        long tempTime = System.currentTimeMillis();
        Timestamp time = new Timestamp(tempTime);
        History history = new History(openid, word, time);
        historyRepo.save(history);
        return true;
    }

    public List <String> getHistory(String openid) {
        List <History> histories = historyRepo.findAllByOpenid(openid);
        List <String> words = new ArrayList <>();
        for(History tempHistory: histories) {
            words.add(tempHistory.getWord());
        }
        return  words;
    }
}
