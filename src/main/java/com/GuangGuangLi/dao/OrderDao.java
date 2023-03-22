package com.GuangGuangLi.dao;

import com.GuangGuangLi.entity.Orders;
import com.GuangGuangLi.entity.OrdersCustom;
import com.GuangGuangLi.entity.UserInfo;

import java.util.List;

public interface OrderDao {


    List<OrdersCustom> findOrdersUser();

    List<Orders> findOrdersUserResultMap();

    List<Orders> findOrdersAndOrderDetailResultMap();

    List<UserInfo> findUserAndItemsResultMap();
}
