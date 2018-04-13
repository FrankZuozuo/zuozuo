package com.simply.zuozuo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Created by 谭健 on 2018/3/30 0030. 星期五. 13:20.
 * © All Rights Reserved.
 * <p>
 * <p>
 * 在SpringBoot2.0及Spring 5.0 WebMvcConfigurerAdapter已经被弃用
 * <p>
 * 新的实现方式
 * 1.继承WebMvcConfigurationSupport
 * 2.实现WebMvcConfigurer接口
 */

@Configuration
public class InterceptorChainLoader extends WebMvcConfigurationSupport {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(new HandleInterceptorImpl());
         super.addInterceptors(registry);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 载入html的资源
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        // 载入swagger2的资源
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}
