package com.zhengcj.demo.swagger.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.zhengcj.demo.data.mapper")
public class MyBatisConfig {
}
