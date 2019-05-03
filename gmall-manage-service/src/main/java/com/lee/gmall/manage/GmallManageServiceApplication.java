package com.lee.gmall.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lee.gmall.manage.mapper")
@ComponentScan("com.lee.gmall.util")
public class GmallManageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallManageServiceApplication.class, args);
    }

}
