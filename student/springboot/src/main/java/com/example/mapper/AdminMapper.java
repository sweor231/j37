package com.example.mapper;

import com.example.entity.Admin;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;


public interface AdminMapper {
    @Select("select * from admin where username = #{username}")
    Admin selectByUsername(String username);
}
