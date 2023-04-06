package com.GuangGuangLi.dao;

import com.GuangGuangLi.entity.*;

import java.util.List;

public interface OrderDao {


    List<OrdersCustom> findOrdersUser();

    List<Orders> findOrdersUserResultMap();

    List<Orders> findOrdersAndOrderDetailResultMap();

    List<UserInfo> findUserAndItemsResultMap();

    ItemsCustom findItems(int items_id);

    List<ItemsCustom> queryItems(ItemsQueryVo itemsQueryVo);

    int updateItems(ItemsCustom itemsCustom);
}
