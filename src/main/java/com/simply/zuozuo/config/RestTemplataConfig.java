package com.simply.zuozuo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Created by 谭健 on 2018/4/2 0002. Monday. 16:37.
 * © All Rights Reserved.
 */

@Configuration
public class RestTemplataConfig {


    /**
     * 使用spring的RestTemplate进行restful访问
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        // 使用JDK的实现构建http访问
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        // 读取超时：单位毫秒
        factory.setReadTimeout(5000);
        // 连接超时：单位毫秒
        factory.setConnectTimeout(5000);
        return factory;
    }


}
