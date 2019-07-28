package com.zhengcj.demo.swagger.controller1;

import com.zhengcj.demo.mybatis.pojo.User;
import com.zhengcj.demo.swagger.pojo.LoginRequest;
import com.zhengcj.demo.swagger.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "User Controller", description = "用户控制器，相关用户接口服务")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "根据 userId, 获取用户信息")
    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public User getUser(@ApiParam(defaultValue = "1") @PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @ApiOperation(value = "login demo")
    @PostMapping(value = "login")
    @ResponseBody
    public String login(@Valid @RequestBody LoginRequest loginRequest) {
        List<User> list = userService.getUserByName(loginRequest.getName());
        if (list == null || list.size() == 0) {
            return "user not exist";
        } else if (list.size() != 1) {
            return "system error, multi user";
        } else {
            if (loginRequest.getPassword().equals(list.get(0).getPassword())) {
                return "login success";
            } else {
                return "login fail, password error!";
            }
        }
    }
}
