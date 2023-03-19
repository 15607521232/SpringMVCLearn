package com.GuangGuangLi.service;

import com.GuangGuangLi.entity.UserInfo;

public interface IuserService {
    boolean addUser(UserInfo user);

    UserInfo getUserInfoByName(String username);

    UserInfo getUserInfoById(int id);

    boolean updateUserInfoById(UserInfo userInfo);

    boolean deleteUserById(int id);

}


