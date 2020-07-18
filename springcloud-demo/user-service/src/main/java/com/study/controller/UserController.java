package com.study.controller;

import com.study.pojo.User;
import com.study.service.UserService;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private DataSource druidDatasource;

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public User demoController() throws Exception{
        log.debug("demoController执行了!");
        //return "hello springboot!";
        return userService.queryById("41");
    }

    @GetMapping("/hello01")
    public User findById() throws Exception{
        log.debug("findById方法执行了！");
        return userService.findById("41");
    }

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") String id) throws Exception {
        log.debug("queryById方法执行了！");
        log.debug("连接池打印："+druidDatasource);
        return userService.findById(id);
    }

}
