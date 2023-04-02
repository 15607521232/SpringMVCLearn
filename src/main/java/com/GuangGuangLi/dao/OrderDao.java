package com.GuangGuangLi.dao;

import com.GuangGuangLi.entity.*;

import java.util.List;

public interface OrderDao {


    List<OrdersCustom> findOrdersUser();

    List<Orders> findOrdersUserResultMap();

    List<Orders> findOrdersAndOrderDetailResultMap();

    List<UserInfo> findUserAndItemsResultMap();

    ItemsCustom findItems(int id);

    List<ItemsCustom> queryItems(ItemsQueryVo itemsQueryVo);

    int updateItems(Items items);
}
