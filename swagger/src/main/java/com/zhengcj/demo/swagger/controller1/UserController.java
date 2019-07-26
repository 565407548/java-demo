package com.zhengcj.demo.swagger.controller1;

import com.zhengcj.demo.data.pojo.User;
import com.zhengcj.demo.swagger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public User getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
}
