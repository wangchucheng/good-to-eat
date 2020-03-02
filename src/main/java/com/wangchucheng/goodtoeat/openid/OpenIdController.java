package com.wangchucheng.goodtoeat.openid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/openid")
public class OpenIdController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public String getOpenId(@RequestParam String appid, @RequestParam String secret, @RequestParam String js_code, @RequestParam String grant_type) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid +
                "&secret="+ secret + "&js_code=" + js_code + "&grant_type=" + grant_type;
        //WXSession result = restTemplate.getForObject(url, WXSession.class);
        ResponseEntity <String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String json = results.getBody();
        //Response response = new Response <>(result.getOpenid(), null, 0, "success");
        return json;
    }
}
