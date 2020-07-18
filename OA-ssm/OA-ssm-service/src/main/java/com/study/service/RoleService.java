package com.study.service;

import com.study.domian.Permission;
import com.study.domian.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAllRole() throws Exception;

    public void save(Role role) throws Exception;

    public List<Permission> findPermissionByRoleId (String roleId) throws  Exception;

    public Role findById(String id) throws Exception;

    public void saveRoleAndPermission(String roleId,String[] permissionIds) throws Exception;
}
