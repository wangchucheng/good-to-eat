package com.wangchucheng.goodtoeat.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    boolean saveUser(User user){
        if (user != null) {
            userRepo.save(user);
            return true;
        }
        return false;
    }
    User findUser(String openid){
        return userRepo.findByOpenid(openid);
    }
    boolean updateUser(String openid,User user){
        //用user来更新openid的user
        if(openid!=null&&user!=null){
            User old=userRepo.findByOpenid(openid);//openid必须有效
            if(user.getSex()!=null){
                old.setSex(user.getSex());
            }else{
                return false;
            }
            if(user.getName()!=null){
                old.setName(user.getName());
            }else{
                return false;
            }
            if(user.getProfile()!=null){
                old.setProfile(user.getProfile());
            }
            return true;
        }
        return false;
    }

    //不仅仅是savefollower，将follow也一并处理了
    boolean saveFollower(String openid,String followid){
        //followid是被关注的人的openid
        User u=userRepo.findByOpenid(openid);
        User f=userRepo.findByOpenid(followid);
        if(u!=null&&f!=null){
            //follower和openid对应的用户都是存在的
             List<String> followers= f.getFollower();
             followers.add(followid);
             f.setFollower(followers);//被关注人的粉丝更新
            u.setFollow(followers);//用户关注的人的数量更新
            return true;
        }else{
            return false;
        }
    }

    boolean deleteFollow(String openid,String followid){
        User u=userRepo.findByOpenid(openid);
        User f=userRepo.findByOpenid(followid);
        if(u!=null&&f!=null){
            List<String> follow=u.getFollow()
        }
    }







}
