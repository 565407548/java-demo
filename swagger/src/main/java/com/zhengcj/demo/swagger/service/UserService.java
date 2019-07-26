package com.zhengcj.demo.swagger.service;

import com.zhengcj.demo.data.pojo.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer userId);

    List<User> getUserByName(String name);
}
