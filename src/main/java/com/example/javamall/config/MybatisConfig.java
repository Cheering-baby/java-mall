package com.example.javamall.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.example.javamall.mbg.mapper")
public class MybatisConfig {

}
