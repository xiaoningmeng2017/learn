package com.study.dao;

import com.study.domian.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {
    /**
     * 查询所有产品信息
     * @return
     */
    @Select("select * from product")
    public List<Product> findAllProduct() throws Exception;

    /**
     * 保存产品信息
     * @param product
     * @throws Exception
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(Product product) throws Exception;

    /**
     * 根据id查询产品信息
     * @param id
     * @return
     */
    @Select("select * from product where id=#{id}")
    public Product findById(String id);
}
