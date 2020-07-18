package com.study.service;

import com.study.dao.RoleDao;
import com.study.domian.Permission;
import com.study.domian.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
   private RoleDao roleDao;

    @Override
    public List<Role> findAllRole() throws Exception {
        return roleDao.findAllRole();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public List<Permission> findPermissionByRoleId(String roleId) throws Exception {
        return roleDao.findPermissionByRoleId(roleId);
    }

    @Override
    public Role findById(String id) throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public void saveRoleAndPermission(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId: permissionIds) {
            roleDao.saveRoleAndPermission(roleId,permissionId);
        }
    }
}
