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
}
