package com.wangchucheng.goodtoeat.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    boolean saveUser(String openId,User user){
        if(openId!=null&&user!=null){
        user.setOpenId(openId);
        if(user.getName()!=null&&user.getSex()!=null){
            userRepo.save(user);
            return true;
        }
        }
            return false;

    }
    User findUser(String openId){
        return userRepo.findUserByOpenId(openId);
    }
    boolean updateUser(String openId,User user){
        //用user来更新openid的user
        if(openId!=null&&user!=null){
            User old=userRepo.findUserByOpenId(openId);//openid必须有效
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







}
