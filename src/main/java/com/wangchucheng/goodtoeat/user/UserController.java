package com.wangchucheng.goodtoeat.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean postUserInfo(@RequestBody User user){
        boolean isSuccess=userService.saveUser(user);
        return isSuccess;
    }
}
