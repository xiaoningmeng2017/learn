package com.study.service;

import com.study.domian.Role;
import com.study.domian.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<UserInfo> findAllUser() throws Exception;

    public void save(UserInfo userInfo) throws  Exception;

    public UserInfo findById(String id) throws Exception;

    public List<Role> findRoleByUserId(String userId) throws Exception;

    public void saveUserAndRole(String userId,String[] roleIds) throws Exception;
}
