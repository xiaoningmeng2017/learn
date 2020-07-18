package com.study.controller;

import com.study.domian.Permission;
import com.study.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAllPermission.do")
    public String findAllPermission(Model model) throws Exception{
        List<Permission> permissions = permissionService.findAllPermission();
        model.addAttribute("permissionList",permissions);
        return "permission-list";
    }

    @RequestMapping("/save.do")
    public String save(Permission permission,Model model) throws Exception{
        permissionService.save(permission);
        return "redirect:findAllPermission.do";
    }
}
