package com.GuangGuangLi.controller;

import com.GuangGuangLi.entity.UserInfo;
import com.GuangGuangLi.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/user")
@Controller
public class UserController {
    @Autowired
    private IuserService iuserService;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUse(@RequestParam("name") String name,@RequestParam int age){
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setAge(age);
        userInfo.setId(12);
        if (iuserService.addUser(userInfo)){
            return "success";
        }else {
            return "error";
        }
    }
}