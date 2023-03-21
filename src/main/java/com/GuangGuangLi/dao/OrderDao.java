package com.GuangGuangLi.dao;

import com.GuangGuangLi.entity.Orders;
import com.GuangGuangLi.entity.OrdersCustom;

import java.util.List;

public interface OrderDao {


    List<OrdersCustom> findOrdersUser();

    List<Orders> findOrdersUserResultMap();
}
