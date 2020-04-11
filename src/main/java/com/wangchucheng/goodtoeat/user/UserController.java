package com.wangchucheng.goodtoeat.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(value ="/user/{openid}/follow" )
    public boolean postFollow(@PathVariable String openid, @RequestParam String folOpenid){
        return userService.saveFollower(openid,folOpenid);
    }

    @GetMapping(value = "/user/{openid}/follow")
    public List<String> getFollow(@PathVariable String openid){
        if(userService.findUser(openid)!=null){
            return userService.findUser(openid).getFollow();
        }else{
            return null;
        }

    }

    @GetMapping(value = "/user/{openid}/follower")
    public List<String> getFollower(@PathVariable String openid){
        if(userService.findUser(openid)!=null){
            return userService.findUser(openid).getFollower();
        }else{
            return null;
        }
    }

    //取消关注
    @DeleteMapping(value = "/user/{openid}/follow")

}
