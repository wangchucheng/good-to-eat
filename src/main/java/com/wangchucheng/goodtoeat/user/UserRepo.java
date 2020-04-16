package com.wangchucheng.goodtoeat.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByOpenid(String openid);
    boolean existsUserByOpenid(String openid);
}
