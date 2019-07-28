package com.zhengcj.demo.swagger.service;

import com.zhengcj.demo.mybatis.pojo.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer userId);

    List<User> getUserByName(String name);
}
