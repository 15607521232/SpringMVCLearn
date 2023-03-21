package com.GuangGuangLi.service.impl;

import com.GuangGuangLi.dao.OrderDao;
import com.GuangGuangLi.entity.Orders;
import com.GuangGuangLi.entity.OrdersCustom;
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
}
