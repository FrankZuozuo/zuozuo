package com.simply.zuozuo.config;

import com.simply.zuozuo.handle.interceptor.HandleInterceptorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

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
public class WebMvcConfig extends WebMvcConfigurationSupport {


    /**
     * 转码
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
        // 这里必须加上加载默认转换器，不然bug玩死人
        addDefaultHttpMessageConverters(converters);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 加载拦截器
        InterceptorRegistration interceptor = registry.addInterceptor(new HandleInterceptorImpl());
        // 设置拦截器拦截路径
        interceptor.addPathPatterns("/**");
        // 设置拦截器不拦截的路径
        interceptor.excludePathPatterns("/open/**");

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
