package com.example.javamall.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@MapperScan("com.example.javamall.mbg.mapper")
public class MybatisConfig {

}
