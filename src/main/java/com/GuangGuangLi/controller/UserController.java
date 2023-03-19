package com.GuangGuangLi.controller;

import com.GuangGuangLi.entity.UserInfo;
import com.GuangGuangLi.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@RequestMapping(value = "/user")
@Controller
public class UserController {
    @Autowired
    private IuserService iuserService;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUse(@RequestParam("name") String name,@RequestParam("address") String address,@RequestParam("sex") String sex){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(27);
        userInfo.setUsername(name);
        userInfo.setBirthday(new Date());
        userInfo.setSex(sex);
        userInfo.setAddress(address);



        if (iuserService.addUser(userInfo)){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping(value = "/getUserInfoByName",method = RequestMethod.GET)
    public void getUserInfoByName(@RequestParam("username") String username){
        UserInfo userInfo = iuserService.getUserInfoByName(username);
        System.out.println(userInfo.toString());
    }

    @RequestMapping(value = "/getUserInfoById",method = RequestMethod.GET)
    public void getUserInfoById(@RequestParam("id") int id){
        UserInfo userInfo = iuserService.getUserInfoById(id);
        System.out.println(userInfo.toString());
    }

    @RequestMapping(value = "/updateUserInfoById",method = RequestMethod.GET)
    public String updateUserInfoById(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(27);
        userInfo.setUsername("王张三");
        userInfo.setBirthday(new Date());
        userInfo.setSex("男");
        userInfo.setAddress("长安");
        if(iuserService.updateUserInfoById(userInfo)){
            return "success";
        }else {
            return "error";
        }

    }

    @RequestMapping(value = "/deleteUserById",method = RequestMethod.DELETE)
    public void deleteUserById(@RequestParam("id") int id){
        boolean b = iuserService.deleteUserById(id);
        System.out.println(b);
    }
}