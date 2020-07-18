package com.study.controller;

import com.study.domian.Role;
import com.study.domian.UserInfo;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUser.do")
    public String findAllUser(Model model)throws Exception{
        List<UserInfo> userInfos = userService.findAllUser();
        model.addAttribute("userList",userInfos);
        return "user-list";
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception{
        userService.save(userInfo);
        return "redirect:findAllUser.do";
    }

    @RequestMapping("findById.do")
    public String findById(String id,Model model) throws Exception{
        UserInfo userInfo = userService.findById(id);
        model.addAttribute("user",userInfo);
        return "user-show";
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public String findUserByIdAndAllRole(@RequestParam(name = "id" ,required = true) String userId , Model model) throws Exception{
        UserInfo userInfo = userService.findById(userId);
        List<Role> roles = userService.findRoleByUserId(userId);
        model.addAttribute("user",userInfo);
        model.addAttribute("roleList",roles);
        return "user-role-add";
    }

    @RequestMapping("/saveUserAndRole.do")
    public String saveUserAndRole(@RequestParam(name = "userId" ,required = true) String userId,@RequestParam(name = "ids",required = true) String[] RoleIds,Model model) throws Exception{
        userService.saveUserAndRole(userId,RoleIds);
        return "redirect:findAllUser.do";
    }
}
