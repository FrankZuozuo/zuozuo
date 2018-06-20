package com.simply.zuozuo.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author Created by 谭健 on 2018/4/13 0013. 星期五. 11:24.
 * © All Rights Reserved.
 *
 * 可以实现多个ApplicationListener
 */
@Slf4j
@Component
public class ApplicationListenerImpl implements ApplicationListener<ContextRefreshedEvent> {



    @Override
    public void onApplicationEvent(@Nullable ContextRefreshedEvent contextRefreshedEvent) {
        log.info("ApplicationListener ： [{}]","启动上下文刷新监听事件");

    }
}
