package com.GuangGuangLi.service.impl;

import com.GuangGuangLi.dao.UserDao;
import com.GuangGuangLi.entity.UserInfo;
import com.GuangGuangLi.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserserviceImpl implements IuserService {


    @Autowired
    private UserDao userDao;
    public boolean addUser(UserInfo user) {
        return userDao.addUser(user);
    }

    public UserInfo getUserInfoByName(String username){
            return userDao.getUserInfoByName(username);
    }


    public UserInfo getUserInfoById(int id){
        return userDao.getUserInfoById(id);
    }

    @Override
    public boolean updateUserInfoById(UserInfo userInfo) {
        return userDao.updateUserInfoById(userInfo);
    }

    @Override
    public boolean deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }
}
