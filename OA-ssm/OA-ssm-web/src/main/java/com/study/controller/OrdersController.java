package com.study.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.domian.Orders;
import com.study.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    /**
     * 查询所有订单信息
     * @return
     */
    @RequestMapping("/findAllOrders.do")
    @Secured("ROLE_ADMIN")
    public String findAllOrders(@RequestParam(required = true,name="page",defaultValue = "1") int page ,@RequestParam(required = true,name = "size",defaultValue = "4") int size, Model model) throws Exception {
        List<Orders> orders = ordersService.findAllOrders(page,size);
        PageInfo pageInfo = new PageInfo(orders);
        model.addAttribute("pageInfo",pageInfo);
        return "orders-page-list";
    }


    @RequestMapping("/findById")
    public String findOrdersById(@RequestParam(required = true,name = "id") String ordersId,Model model) throws Exception{
        Orders orders = ordersService.findOrdersById(ordersId);
        model.addAttribute("orders",orders);
        return "orders-show";
    };
}
