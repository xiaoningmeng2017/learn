package com.study.service;

import com.github.pagehelper.PageHelper;
import com.study.dao.OrdersDao;
import com.study.domian.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAllOrders(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return ordersDao.findAllOrders();
    }

    @Override
    public Orders findOrdersById(String ordersId) throws Exception {
        return ordersDao.findOrdersById(ordersId);
    }
}
