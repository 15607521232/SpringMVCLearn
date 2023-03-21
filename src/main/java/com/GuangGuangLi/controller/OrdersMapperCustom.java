package com.GuangGuangLi.controller;


import com.GuangGuangLi.entity.Orders;
import com.GuangGuangLi.entity.OrdersCustom;
import com.GuangGuangLi.service.IorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping(value = "/orders")
@Controller
public class OrdersMapperCustom {


    @Autowired
    private IorderService iorderService;


    /**
     * 确定查询的主表：订单表
     * 确定查询的关联表：用户表
     * 	关联查询使用内链接？还是外链接？
     * 	由于orders表中有一个外键（user_id），通过外键关联查询用户表只能查询出一条记录，可以使用内链接。
     *
     * SELECT
     *   orders.*,
     *   USER.username,
     *   USER.sex,
     *   USER.address
     * FROM
     *   orders,
     *   USER
     * WHERE orders.user_id = user.id
     *
     * 使用resultType为OrdersCustom 显示的信息只有orders表的信息
     * Orders{id=3, userId=0, number='1000010', createtime=Wed Feb 04 13:22:35 CST 2015, note='null'}
     * Orders{id=4, userId=0, number='1000011', createtime=Tue Feb 03 13:22:41 CST 2015, note='null'}
     * Orders{id=5, userId=0, number='1000012', createtime=Thu Feb 12 16:13:23 CST 2015, note='null'}
     */
    @RequestMapping(value = "/findOrdersUser",method = RequestMethod.GET)
    public void findOrdersUser(){

        List<OrdersCustom> ordersUser = iorderService.findOrdersUser();

        for (OrdersCustom ordersCustom:ordersUser){
            System.out.println(ordersCustom.getId() + "-" + ordersCustom.getUserId() + "-" + ordersCustom.getNumber() + "-"
            + ordersCustom.getCreatetime() + "-" + ordersCustom.getNote() + "||" + ordersCustom.getUsername() + "-" + ordersCustom.getSex() + "-" + ordersCustom.getAddress());
        }


    }

    /**
     *  使用resultMap映射的思路
     *  使用resultMap将查询结果中的订单信息映射到Orders对象中，在orders类中添加User属性，将关联查询出来的用户信息映射到orders对象中的user属性中
     *
     *  1:在Orders类中添加UserInfo的属性
     */

    @RequestMapping(value = "/findOrdersUserResultMap",method = RequestMethod.GET)
    public void findOrdersUserResultMap(){

        List<Orders> userResultMap = iorderService.findOrdersUserResultMap();
        for (Orders orders:userResultMap){
            System.out.println(orders.getId() + "-" + orders.getUserId() + "-" + orders.getNumber() + "- " + orders.getCreatetime()
            + "-" + orders.getNote() + "| |" + orders.getUserInfo().toString());
        }

    }




}
