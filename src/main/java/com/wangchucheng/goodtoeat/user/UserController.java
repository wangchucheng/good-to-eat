package com.wangchucheng.goodtoeat.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value="")
    public boolean postUserInfo(@RequestParam("openid") String openid,@RequestParam("sex") String sex,@RequestParam("name") String name){
        boolean isSuccess=userService.saveUser(openid,sex,name);
        return isSuccess;
    }





}
