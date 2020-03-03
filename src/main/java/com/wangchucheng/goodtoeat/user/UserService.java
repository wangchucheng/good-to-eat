package com.wangchucheng.goodtoeat.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    boolean saveUser(String openid,String sex,String name){
        User user=new User();
        if(openid!=null&&name!=null&&sex!=null){
            user.setOpenId(openid);
            user.setName(name);
            user.setSex(sex);
            userRepo.save(user);
            return true;
        }
            return false;

    }
    User findUser(String openid){
        return userRepo.findUserByOpenId(openid);
    }
    boolean updateUser(String openid,User user){
        //用user来更新openid的user
        if(openid!=null&&user!=null){
            User old=userRepo.findUserByOpenId(openid);//openid必须有效
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
