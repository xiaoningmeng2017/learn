package com.study.controller;

import com.study.domian.Product;
import com.study.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 查询所有产品信息
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAllProduct.do")
    @RolesAllowed("ADMIN")
    public String findAllProduct(Model model) throws Exception{
        List<Product> productList = productService.findAllProduct();
        model.addAttribute("productList",productList);
        return "product-list";
    }

    /**
     * 保存产品信息
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAllProduct.do";
    }

}
