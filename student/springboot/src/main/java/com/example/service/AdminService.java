package com.example.service;

import com.example.entity.Admin;
import com.example.mapper.AdminMapper;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.*;

@Service
public class AdminService {


    @Resource
    private AdminMapper adminMapper;

    /**
     * 登录
     */
    public Admin login(Admin admin) {
        Admin dbAdmin = adminMapper.selectByUsername(admin.getUsername());
        if (dbAdmin == null) {
            //没有用户
            throw new ClassCastException("账号或密码错误");
        }
        //比较密码
        if (!admin.getPassword().equals(dbAdmin.getPassword())) {
            throw new ClassCastException("账号或密码错误");
        }
        //登录成功
        return dbAdmin;
    }
}
