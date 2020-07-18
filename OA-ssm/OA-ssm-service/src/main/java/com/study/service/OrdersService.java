package com.study.service;

import com.study.domian.Orders;
import com.study.domian.Product;

import java.util.List;

public interface OrdersService {
    /**
     * 查询所有订单信息
     * @return
     */
    public List<Orders> findAllOrders(int page,int size) throws Exception;

    public Orders findOrdersById(String ordersId) throws Exception;



}
