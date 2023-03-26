package com.GuangGuangLi.service;

import com.GuangGuangLi.entity.*;

import java.util.List;

public interface IorderService {

    List<OrdersCustom> findOrdersUser();


    List<Orders> findOrdersUserResultMap();

    List<Orders> findOrdersAndOrderDetailResultMap();

    List<UserInfo> findUserAndItemsResultMap();

    ItemsCustom findItems(int id);

    List<ItemsCustom> queryItems(ItemsQueryVo itemsQueryVo);
}
