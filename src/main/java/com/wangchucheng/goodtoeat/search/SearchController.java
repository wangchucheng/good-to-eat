package com.wangchucheng.goodtoeat.search;

import com.wangchucheng.goodtoeat.recipe.Recipe;
import com.wangchucheng.goodtoeat.search.history.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @Autowired
    private HistoryService historyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List <Recipe> getSearchResult(@RequestParam String openid, @RequestParam String keyword) {
        historyService.saveHistory(openid, keyword);
        return searchService.searchRecipe(keyword);
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public List <String> getHistories(@RequestParam String openid) {
        return historyService.getHistory(openid);
    }

    @RequestMapping(value = "/hot", method = RequestMethod.GET)
    public List <String> getHot(@RequestParam String openid) {
        List<String> hotWords = new ArrayList <>();
        hotWords.add("汉堡");
        hotWords.add("披萨");
        return hotWords;
    }
}
