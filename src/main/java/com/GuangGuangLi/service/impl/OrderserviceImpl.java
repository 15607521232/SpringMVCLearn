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
    public ItemsCustom findItems(int id) {
        return orderDao.findItems(id);
    }

    @Override
    public List<ItemsCustom> queryItems(ItemsQueryVo itemsQueryVo) {


        return orderDao.queryItems(itemsQueryVo);
    }


}
