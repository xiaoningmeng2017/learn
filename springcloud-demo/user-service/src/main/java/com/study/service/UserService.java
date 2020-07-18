package com.study.service;

import com.study.mapper.UserMapper;
import com.study.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public User queryById (String id){
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public User findById(String id ) throws Exception{
//        Thread.sleep(2000);
        return userMapper.findById(id);
    }

    public List<User> findAll()throws Exception{
        return userMapper.findAll();
    }
}
