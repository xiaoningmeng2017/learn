package com.study.controller;

import com.study.domian.Permission;
import com.study.domian.Role;
import com.study.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAllRole.do")
    public String findAllRole(Model model) throws Exception{
        List<Role> roles = roleService.findAllRole();
        model.addAttribute("roleList",roles);
        return "role-list";
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{
        roleService.save(role);
        return "redirect:findAllRole.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public String findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId, Model model) throws Exception{
        Role role = roleService.findById(roleId);
        List<Permission> permissions = roleService.findPermissionByRoleId(roleId);
        model.addAttribute("role",role);
        model.addAttribute("permissionList",permissions);
        return "role-permission-add";
    }

    @RequestMapping("/saveRoleAndPermission.do")
    public String saveRoleAndPermission(@RequestParam(name = "roleId",required = true) String roleId,@RequestParam(name = "ids",required = true) String[] permissionIds)throws Exception{
        roleService.saveRoleAndPermission(roleId,permissionIds);
        return "redirect:findAllRole.do";
    }

    @RequestMapping("/findById.do")
    public String findById(@RequestParam(name = "id",required = true) String id, Model model) throws Exception{
        Role role = roleService.findById(id);
        model.addAttribute("role",role);
        return "role-show";
    }
}
