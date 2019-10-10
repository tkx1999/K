package com.example.appinfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.appinfo.dao")
public class AppinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppinfoApplication.class, args);
    }

}
