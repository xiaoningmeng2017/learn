package com.study.dao;

import com.study.domian.Permission;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    @Select("select p.* from  permission p,role_permission rp where p.id=rp.permissionId and rp.roleId = #{id}")
    public List<Permission> findByRoleId(String id) throws Exception;

    @Select("select * from permission")
    public List<Permission> findAllPermission() throws Exception;

    @Insert("insert into permission(permissionName,url) values (#{permissionName},#{url}) " )
    public void save(Permission permission) throws Exception;
}
