package com.zhengcj.demo.swagger.service.impl;

import com.zhengcj.demo.mybatis.mapper.UserMapper;
import com.zhengcj.demo.mybatis.pojo.User;
import com.zhengcj.demo.mybatis.pojo.UserExample;
import com.zhengcj.demo.swagger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public List<User> getUserByName(String name) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        return userMapper.selectByExample(example);
    }
}
