package com.jiamy.service;

import com.jiamy.dto.User;
import com.jiamy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/9/26 15:28
 **/
@Component
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getById(String id){
        return userMapper.getById(id);
    }

    public User getByName(String name){
        return userMapper.getByName(name);
    }
}
