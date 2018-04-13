package com.simply.zuozuo.config;

import com.simply.zuozuo.consts.IDEWarnType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.PostConstruct;

/**
 * @author Created by 谭健 on 2018/3/30 0030. 星期五. 13:57.
 * © All Rights Reserved.
 */

@Slf4j
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties
@SuppressWarnings(IDEWarnType.ALL)
public class FreeMarkerConfig {


    @Autowired
    private freemarker.template.Configuration configuration;
    @Autowired
    private FreeMarkerConfigurer configurer;
    @Autowired
    private FreeMarkerViewResolver viewResolver;


    private InternalResourceViewResolver resourceViewResolver;

    private String ctx;


    // Spring 初始化的时候加载配置
    @PostConstruct
    public void setConfigure() throws Exception {


        log.info("ctx is : {}", ctx);

        // 加载html的资源路径
        configuration.setSharedVariable("ctx", ctx);

        viewResolver.setOrder(0);

    }

}
