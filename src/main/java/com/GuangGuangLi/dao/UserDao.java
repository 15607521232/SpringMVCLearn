package com.GuangGuangLi.dao;


import com.GuangGuangLi.entity.UserInfo;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {
    boolean addUser(UserInfo user);

     UserInfo  getUserInfoByName(String username);

     UserInfo  getUserInfoById(int id);

     boolean updateUserInfoById(UserInfo userInfo);

     boolean deleteUserById(int id);
}
