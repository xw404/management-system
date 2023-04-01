package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Admin;
import com.example.springboot.mapper.AdminMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 小吴
 * @Date 2023/03/22 16:37
 * @Version 1.0
 * 实现管理员登录校验
 */
@RestController
@RequestMapping(value = "/user")
public class loginController {
    @Resource
    private AdminMapper adminMapper;

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getAdminUser,admin.getAdminUser());
        wrapper.eq(Admin::getAdminPassword,admin.getAdminPassword());
        Admin res = adminMapper.selectOne(wrapper);
        if(res == null){
            return Result.error("500","管理员用户或密码不存在");
        }
        return Result.success();
    }

    /**
     * 管理员注册
     * @param admin
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody Admin admin){
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getAdminUser,admin.getAdminUser());
        Admin res = adminMapper.selectOne(wrapper);
        if(res != null){
            return Result.error("500","此用户已经存在");
        }
        //设置默认密码
        if(admin.getAdminPassword()==null){
            admin.setAdminPassword("123");
        }
        adminMapper.insert(admin);
        return Result.success();
    }
}
