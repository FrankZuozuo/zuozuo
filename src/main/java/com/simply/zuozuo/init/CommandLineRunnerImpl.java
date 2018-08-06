package com.simply.zuozuo.init;

import com.simply.zuozuo.util.JedisSingleton;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Created by 谭健 on 2018/4/10 0010. 星期二. 15:53.
 * © All Rights Reserved.
 *
 * CommandLineRunner跟ApplicationRunner一样的功能
 */
@Component
@Slf4j
public class CommandLineRunnerImpl implements CommandLineRunner{

    /**
     * 会在服务启动完成后立即执行
     */
    @Override
    public void run(String... args) throws Exception {

        log.info("向Redis 注册服务启动时间...");
        Long startTime = System.nanoTime();
        JedisSingleton.getInstance().set("Service startup time", String.valueOf(startTime));
        log.info("向Redis 注册服务启动时间完成，注册值是 [{}]...",startTime);
    }
}
