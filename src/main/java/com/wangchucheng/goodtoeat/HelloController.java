package com.wangchucheng.goodtoeat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "<a href=\"http://www.beian.miit.gov.cn\">津ICP备19004351号</a>";
    }

}
