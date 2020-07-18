package com.study.dao;

import com.study.domian.Permission;
import com.study.domian.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

    /**
     * 不包含权限信息,用户登录验证使用
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select r.* from role r,users_role ur where r.id=ur.roleId and ur.userId = #{id}")
    public List<Role> findByUserId(String id) throws Exception;

    @Select("select r.* from role r,users_role ur where r.id=ur.roleId and ur.userId = #{id}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions" ,javaType = java.util.List.class,many = @Many(select = "com.study.dao.PermissionDao.findByRoleId")),
    })
    public  List<Role> findAllByUserId(String id) throws Exception;


    @Select("select * from role")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions" ,javaType = java.util.List.class,many = @Many(select = "com.study.dao.PermissionDao.findByRoleId")),
    })
    public List<Role> findAllRole() throws Exception;

    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void save(Role role) throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    public List<Permission> findPermissionByRoleId(String roleId) throws Exception;

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(column = "id" ,property = "id",id = true),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions" ,javaType = java.util.List.class,many = @Many(select = "com.study.dao.PermissionDao.findByRoleId")),
    })
    public Role findById(String id) throws Exception;

    @Insert("insert into role_permission(permissionId,roleId) values (#{permissionId},#{roleId})")
    public void saveRoleAndPermission(@Param("roleId") String roleId,@Param("permissionId") String permissionId) throws Exception;
}
