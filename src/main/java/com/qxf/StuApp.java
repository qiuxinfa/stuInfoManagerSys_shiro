package com.qxf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Auther: qiuxinfa
 * @Date: 2019/10/11
 * @Description: com.qxf
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.qxf.mapper")
public class StuApp {
    public static void main(String[] args) {
        SpringApplication.run(StuApp.class,args);
    }
}
