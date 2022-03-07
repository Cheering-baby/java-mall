package com.example.javamall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication()
@MapperScan("com.example.javamall.dao")
public class JavaMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaMallApplication.class, args);
    }

}
