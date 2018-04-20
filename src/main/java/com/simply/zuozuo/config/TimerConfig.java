package com.simply.zuozuo.config;

import com.simply.zuozuo.consts.DateTimePattern;
import com.simply.zuozuo.timer.RedisTimer;
import com.simply.zuozuo.util.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

/**
 * @author Created by 谭健 on 2018/3/30 0030. 星期五. 10:40.
 * © All Rights Reserved.
 */


@Component
/**
 * 启用定时器
 */
@EnableScheduling
@Slf4j
public class TimerConfig {


    @Scheduled(cron = "0 0/5 * * * *")
    public void redisTimer() throws Exception {
        RedisTimer.setTimeNow();
    }


    @Scheduled(fixedRate = 300 * 1000)
    public void logTimer() throws Exception {

        // 每100秒打印一次日志
        log.info("日志定时器心跳 : {}", DateTimeUtils.of(DateTimePattern.YYYY_MM_DD_HH_MM_SS));
    }


}
