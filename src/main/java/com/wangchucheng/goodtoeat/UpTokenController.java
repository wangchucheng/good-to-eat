package com.wangchucheng.goodtoeat;

import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value="/uptoken")
public class UpTokenController {
    @GetMapping
    public String getUpToken() {
        String accessKey = "i8cc0DkW0Td9rishy0HDcZ2JUbHB9tUWcJGM__PI";
        String secretKey = "c_AVQPGFG5wUXbiBiJ-r5o08eFwmmCS_xMeDX500";
        String bucket = "foodimages";
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket);
    }
}
