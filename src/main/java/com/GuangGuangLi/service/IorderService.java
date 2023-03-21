package com.GuangGuangLi.service;

import com.GuangGuangLi.entity.Orders;
import com.GuangGuangLi.entity.OrdersCustom;

import java.util.List;

public interface IorderService {

    List<OrdersCustom> findOrdersUser();


    List<Orders> findOrdersUserResultMap();
}
