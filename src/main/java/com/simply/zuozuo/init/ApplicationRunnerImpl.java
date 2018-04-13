package com.simply.zuozuo.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Created by 谭健 on 2018/4/10 0010. 星期二. 15:48.
 * © All Rights Reserved.
 * <p>
 * ApplicationRunner
 * 该接口的方法会在服务启动之后被立即执行
 * 主要用来做一些初始化的工作
 */

@Component
@Slf4j
public class ApplicationRunnerImpl implements ApplicationRunner {

    /**
     * 会在服务启动完成后立即执行
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("Successful service startup!");
    }
}
