package com.it.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.it.www.dao")
public class HrManageSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(HrManageSpringBootApplication.class, args);
    }
}
