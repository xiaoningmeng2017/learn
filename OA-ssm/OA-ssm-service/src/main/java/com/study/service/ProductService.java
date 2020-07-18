package com.study.service;

import com.study.domian.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有产品信息
     * @return
     */
    public List<Product> findAllProduct() throws Exception;

    /**
     * 保存产品信息
     * @throws Exception
     */
    public void save(Product product) throws Exception;
}
