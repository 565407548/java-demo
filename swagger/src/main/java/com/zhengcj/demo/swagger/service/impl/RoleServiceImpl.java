package com.zhengcj.demo.swagger.service.impl;

import com.zhengcj.demo.mybatis.mapper.RoleMapper;
import com.zhengcj.demo.mybatis.pojo.Role;
import com.zhengcj.demo.swagger.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Role getRoleById(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }
}
