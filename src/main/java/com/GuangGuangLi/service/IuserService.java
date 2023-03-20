package com.GuangGuangLi.service;

import com.GuangGuangLi.entity.UserCustom;
import com.GuangGuangLi.entity.UserInfo;
import com.GuangGuangLi.entity.UserQueryVo;

import java.util.List;

public interface IuserService {
    boolean addUser(UserInfo user);

    List<UserInfo> getUserInfoByName(String username);

    UserInfo getUserInfoById(int id);

    boolean updateUserInfoById(UserInfo userInfo);

    boolean deleteUserById(int id);

    List<UserCustom> findUserInfoList(UserQueryVo userQueryVo);


    int findUserCount(UserQueryVo userQueryVo);

    UserInfo findUserByIdResultMap(int id);

}


