package com.GuangGuangLi.service.impl;

import com.GuangGuangLi.dao.OrderDao;
import com.GuangGuangLi.entity.*;
import com.GuangGuangLi.service.IorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderserviceImpl implements IorderService {

    @Autowired
    private OrderDao orderDao;


    @Override
    public List<OrdersCustom> findOrdersUser() {
        return orderDao.findOrdersUser();
    }

    @Override
    public List<Orders> findOrdersUserResultMap() {
        return orderDao.findOrdersUserResultMap();
    }

    @Override
    public List<Orders> findOrdersAndOrderDetailResultMap() {
        return orderDao.findOrdersAndOrderDetailResultMap();
    }

    @Override
    public List<UserInfo> findUserAndItemsResultMap() {
        return orderDao.findUserAndItemsResultMap();
    }

    @Override
    public ItemsCustom findItems(int items_id) {
        return orderDao.findItems(items_id);
    }

    @Override
    public List<ItemsCustom> queryItems(ItemsQueryVo itemsQueryVo) {


        return orderDao.queryItems(itemsQueryVo);
    }

    @Override
    public void updateItems(Integer id, ItemsCustom itemsCustom) {

        //添加业务校验，通常在service接口对关键参数进行校验
        //例如校验id是否为空，通常为空抛出异常  更新商品信息使用updateByPrimaryKeyWithBLOBs更新items表中所有字段，包括大文本类型字段

        itemsCustom.setId(id);
        orderDao.updateItems(itemsCustom);

    }


}
