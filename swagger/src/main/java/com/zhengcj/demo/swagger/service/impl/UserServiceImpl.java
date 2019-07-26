package com.zhengcj.demo.swagger.service.impl;

import com.zhengcj.demo.data.mapper.UserMapper;
import com.zhengcj.demo.data.pojo.User;
import com.zhengcj.demo.swagger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }
}
