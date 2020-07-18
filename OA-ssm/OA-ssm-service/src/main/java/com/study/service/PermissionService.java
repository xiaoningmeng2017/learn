package com.study.service;

import com.study.domian.Permission;

import java.util.List;

public interface PermissionService {
    public List<Permission> findAllPermission() throws Exception;
    public void save(Permission permission) throws Exception;
}
