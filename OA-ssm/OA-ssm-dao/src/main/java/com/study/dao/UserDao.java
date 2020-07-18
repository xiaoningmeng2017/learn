package com.study.dao;

import com.study.domian.Role;
import com.study.domian.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserDao {
    @Select("select * from users where username = #{name}")
    @Results({
            @Result(column = "id" ,property = "id" ,id=true),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = java.util.List.class,many = @Many(select = "com.study.dao.RoleDao.findByUserId")),
    })
    public UserInfo findByName(String name) throws Exception;

    @Select("select * from users")
    public List<UserInfo> findAllUser()throws Exception;

    @Insert("insert into users(email,username,password,phoneNum,status) values (#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo) throws  Exception;

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "email" ,property = "email"),
            @Result(column = "username" ,property = "username"),
            @Result(column = "password" ,property = "password"),
            @Result(column = "phoneNum" ,property = "phoneNum"),
            @Result(column = "status" ,property = "status"),
            @Result(column = "id" ,property = "roles" ,javaType = java.util.List.class,many = @Many(select = "com.study.dao.RoleDao.findAllByUserId")),
    })
    public UserInfo findById(String id) throws  Exception;

    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    public List<Role> findRoleByUserId(String userId) throws Exception;


    @Insert("insert into users_role (userId,roleId) values (#{userId},#{roleId})")
    public void saveUserAndRole(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;


}
