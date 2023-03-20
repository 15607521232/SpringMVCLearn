package com.GuangGuangLi.dao;


import com.GuangGuangLi.entity.UserCustom;
import com.GuangGuangLi.entity.UserInfo;
import com.GuangGuangLi.entity.UserQueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {
    boolean addUser(UserInfo user);

     List<UserInfo>  getUserInfoByName(String username);

     UserInfo  getUserInfoById(int id);

     boolean updateUserInfoById(UserInfo userInfo);

     boolean deleteUserById(int id);

     List<UserCustom> findUserInfoList(UserQueryVo userQueryVo);

     int findUserCount(UserQueryVo userQueryVo);

     UserInfo findUserByIdResultMap(int id);
}
