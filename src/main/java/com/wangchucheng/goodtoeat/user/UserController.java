package com.wangchucheng.goodtoeat.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping(value = "")
    public User getUser(@RequestParam String openid){
        return userService.findUser(openid);
    }
    @PostMapping(value ="/{openid}/follow" )
    public boolean postFollow(@PathVariable String openid, @RequestParam String folOpenid){
        return userService.saveFollower(openid,folOpenid);
    }

    @GetMapping(value = "/{openid}/follow")
    public List<User> getFollow(@PathVariable String openid){
        if(userService.findUser(openid)!=null){
            List<String> strLists=userService.findUser(openid).getFollow();
            List<User> res=new ArrayList<>();
            for(int i=0;i<strLists.size();i++){
                res.add(userService.findUser(strLists.get(i)));
            }
            return res;
        }else{
            return null;
        }

    }

    @GetMapping(value = "/{openid}/follower")
    public List<User> getFollower(@PathVariable String openid){
        if(userService.findUser(openid)!=null){
            List<String> strlists=userService.findUser(openid).getFollower();
            List<User> res=new ArrayList<>();
            for(int i=0;i<strlists.size();i++){
                res.add(userService.findUser(strlists.get(i)));
            }
            return res;
        }else{
            return null;
        }
    }

    //取消关注
    @DeleteMapping(value = "/{openid}/follow")
    public boolean deletefollow(@PathVariable String openid,@RequestParam String followid){
        //取消关注
        return userService.deleteFollow(openid,followid);
    }


}
