package com.GuangGuangLi.controller;

import com.GuangGuangLi.entity.UserCustom;
import com.GuangGuangLi.entity.UserInfo;
import com.GuangGuangLi.entity.UserQueryVo;
import com.GuangGuangLi.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        List<UserInfo> userInfoByName = iuserService.getUserInfoByName(username);
        for (UserInfo user:userInfoByName){
            System.out.println(user);
        }

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

    //用户综合信息查询

    /**
     *输入映射
     *  传递pojo的包装对象
     *  需求: 完成用户信息的综合查询，需要传入查询条件很复杂（可能包括用户信息、其它信息，比如商品、订单的）
     *
     *  针对上边需求，建议使用自定义的包装类型的pojo。
     * 在包装类型的pojo中将复杂的查询条件包装进去。
     */

    @RequestMapping(value = "/findUserInfoList",method = RequestMethod.GET)
    public void  findUserInfoList(){
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("1");
        userCustom.setUsername("张三丰");
        userQueryVo.setUserCustom(userCustom);

        List<UserCustom> userInfoList = iuserService.findUserInfoList(userQueryVo);
        for (UserCustom us:userInfoList){
            System.out.println(us);
        }


    }

    /**
     * 输出映射
     * resultType
     * 使用resultType进行输出映射，只有查询出来的列名和pojo中的属性名一致，该列才可以映射成功。
     * 如果查询出来的列名和pojo中的属性名全部不一致，没有创建pojo对象。
     * 只要查询出来的列名和pojo中的属性有一个一致，就会创建pojo对象。
     *
     * 需求
     *      用户信息的综合查询列表总数，通过查询总数和上边用户综合查询列表才可以实现分页。
     */

    @RequestMapping(value = "/findUserCount",method = RequestMethod.GET)
    public void  findUserCount(){
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        //userCustom.setSex("1");
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(22);
        ids.add(25);
        ids.add(16);
        userCustom.setUsername("小明");
        userQueryVo.setIds(ids);
        userQueryVo.setUserCustom(userCustom);

        int userCount = iuserService.findUserCount(userQueryVo);
        System.out.println(userCount);


    }


    /**
     * 输出映射 resultMap
     */
    @RequestMapping(value = "/findUserByIdResultMap")
    public void findUserByIdResultMap(){

        UserInfo userInfo = iuserService.findUserByIdResultMap(1);
        System.out.println(userInfo);


    }


}