

package com.simply.zuozuo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;





/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

@SpringBootApplication
// 开启ServletComponent 扫描
@ServletComponentScan
// 开启AsoectJ 支持的AOP
@EnableAspectJAutoProxy
// 开启webMvc
@EnableWebMvc
// 开启异步支持
@EnableAsync
// 开启mybatis mapper接口扫描
@MapperScan(basePackages = {"com.simply.zuozuo.dao.mapper"})
// 开启定时器
@EnableScheduling
public class ZuozuoApplication {



    public static void main(String[] args) {
        SpringApplication.run(ZuozuoApplication.class, args);
    }


}
