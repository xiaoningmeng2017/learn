package com.study.mapper;

import com.study.pojo.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    @Select("select * from user where id =#{id}")
    public User findById(String id) throws Exception;

    @Select("select * from user")
    public List<User> findAll() throws Exception;

}
