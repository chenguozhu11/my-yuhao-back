package com.yuhao.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Locale;

@MapperScan("com.yuhao.core.mapper")
@SpringBootApplication
public class MyYuhaoBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyYuhaoBackApplication.class, args);
    }

}
