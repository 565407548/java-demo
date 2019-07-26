package com.zhengcj.demo.swagger.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LoginRequest {
    @Length(min=3,message = "min length of name is 3")
    @ApiModelProperty(notes = "user's name",example = "zhengcj")
    private String name;
    @Length(min=2,message = "min length of password is 2")
    @ApiModelProperty(notes = "user's password",example = "123")
    private String password;
}
