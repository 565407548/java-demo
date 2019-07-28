package com.zhengcj.demo.swagger.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.zhengcj.demo.mybatis.mapper")
public class MyBatisConfig {
}
