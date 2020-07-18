package com.study;

import com.study.dao.ProductDao;
import com.study.domian.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class prodectDaoTest {
    @Autowired
    private ProductDao productDao;

    @Test
    public void test01() throws Exception {
        List<Product> products = productDao.findAllProduct();
        for (Product product:products) {
            System.out.println(product);
        }
    }
}
