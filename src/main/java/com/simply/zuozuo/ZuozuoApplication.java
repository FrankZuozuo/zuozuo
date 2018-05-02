

package com.simply.zuozuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;





/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

@SpringBootApplication

/**
 * 启动 ServletComponent 扫描
 */
@ServletComponentScan

@EnableAspectJAutoProxy

@EnableWebMvc

@EnableAsync
public class ZuozuoApplication {



    public static void main(String[] args) {
        SpringApplication.run(ZuozuoApplication.class, args);
    }


}
