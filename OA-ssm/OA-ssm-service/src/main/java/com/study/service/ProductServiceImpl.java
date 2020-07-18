package com.study.service;

import com.study.dao.ProductDao;
import com.study.domian.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAllProduct() throws Exception{
        return productDao.findAllProduct() ;
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
