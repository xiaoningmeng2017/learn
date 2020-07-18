package com.study.dao;

import com.study.domian.Member;
import com.study.domian.Orders;
import com.study.domian.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {
    /**
     * 查询所有订单
     * @return
     */
    @Select("select * from orders")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum" ,property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderTimeStr" ,property = "orderTimeStr"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "orderStatusStr" ,property = "orderStatusStr"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "payTypeStr" ,property = "payTypeStr"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId" ,property = "product",javaType = Product.class,one = @One(select = "com.study.dao.ProductDao.findById")),
    })
    public List<Orders> findAllOrders() throws Exception;

    /**
     * 查询订单详情
     * @return
     */
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum" ,property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderTimeStr" ,property = "orderTimeStr"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "orderStatusStr" ,property = "orderStatusStr"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "payTypeStr" ,property = "payTypeStr"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId" ,property = "product",javaType = Product.class,one = @One(select = "com.study.dao.ProductDao.findById")),
            @Result(column = "memberId",property = "member" ,javaType = Member.class,one=@One(select = "com.study.dao.MemberDao.findById")),
            @Result(column = "id",property = "travellers",javaType = java.util.List.class,many = @Many(select = "com.study.dao.TravellerDao.findByOrdersId")),
    })
    public Orders findOrdersById(String OrdersId) throws Exception;
}
