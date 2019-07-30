package com.zhengcj.demo.mybatis.pojo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class User implements Serializable {
    /**
     * user id
     */
    @ApiModelProperty(value = "user id")
    private Integer id;

    /**
     * user name
     */
    @ApiModelProperty(value = "user name")
    private String name;

    /**
     * user password
     */
    @ApiModelProperty(value = "user password")
    private String password;

    /**
     * user gender, 0: male, 1:female
     */
    @ApiModelProperty(value = "user gender, 0: male, 1:female")
    private Integer gender;

    /**
     * user role id
     */
    @ApiModelProperty(value = "user role id")
    private Integer roleId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", gender=").append(gender);
        sb.append(", roleId=").append(roleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}