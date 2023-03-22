package com.GuangGuangLi.service.impl;

import com.GuangGuangLi.dao.UserDao;
import com.GuangGuangLi.entity.UserCustom;
import com.GuangGuangLi.entity.UserInfo;
import com.GuangGuangLi.entity.UserQueryVo;
import com.GuangGuangLi.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserserviceImpl implements IuserService {


    @Autowired
    private UserDao userDao;
    public boolean addUser(UserInfo user) {
        return userDao.addUser(user);
    }

    public List<UserInfo> getUserInfoByName(String username){
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

    @Override
    public List<UserCustom> findUserInfoList(UserQueryVo userQueryVo) {
        return userDao.findUserInfoList(userQueryVo);
    }

    @Override
    public int findUserCount(UserQueryVo userQueryVo) {
        return  userDao.findUserCount(userQueryVo);
    }

    @Override
    public UserInfo findUserByIdResultMap(int id) {
        return userDao.findUserByIdResultMap(id);
    }



}
