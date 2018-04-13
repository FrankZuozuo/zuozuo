package com.simply.zuozuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication

/**
 * 启动 ServletComponent 扫描
 */
@ServletComponentScan

@EnableAspectJAutoProxy

@EnableWebMvc
public class ZuozuoApplication {

// test git


    public static void main(String[] args) {
        SpringApplication.run(ZuozuoApplication.class, args);
    }


}
