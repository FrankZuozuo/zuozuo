package com.simply.zuozuo.timer;

import com.simply.zuozuo.consts.DateTimePattern;
import com.simply.zuozuo.util.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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


    @Scheduled(cron = "0 0/1 * * * *")
    public void redisTimer() throws Exception {

        if (log.isInfoEnabled()) {
            log.info("class : {} run start.", TimerConfig.class);
        }
        RedisTimer.setTimeNow();

    }


    @Scheduled(fixedRate = 100 * 1000)
    public void logTimer() throws Exception {

        // 每100秒打印一次日志
        log.info("now is : {}", DateTimeUtils.of(DateTimePattern.YYYY_MM_DD_HH_MM_SS));
    }


}
