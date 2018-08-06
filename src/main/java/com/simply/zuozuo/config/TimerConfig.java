package com.simply.zuozuo.config;

import com.google.common.collect.Lists;
import com.simply.zuozuo.async.AsyncMethod;
import com.simply.zuozuo.consts.DateTimePattern;
import com.simply.zuozuo.dao.repo.MemberTaskRepo;
import com.simply.zuozuo.entity.po.MemberTask;
import com.simply.zuozuo.util.DateTimeUtils;
import com.simply.zuozuo.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
@Slf4j
public class TimerConfig {


    @Autowired
    private MemberTaskRepo memberTaskRepo;
    @Autowired
    private AsyncMethod asyncMethod;

    public static final long SECOND = 1000;
    public static final long MINUTE = SECOND * 60;
    public static final long HOUR = MINUTE * 60;
    public static final long DAY = HOUR * 24;
    public static final long MONTH = DAY * 30;
    public static final long YEAR = MONTH * 12;


//
//    @Scheduled(cron = "0 0/5 * * * *")
//    public void redisTimer() throws Exception {
//        log.info("启动redisTimer...");
//        RedisTimer.setTimeNow();
//    }

    /**
     * fixedRate  每多少时间执行一次，从上一个任务开始执行之后开始计时
     * fixedDelay  每多少时间执行一次，从上一个任务执行完成之后开始计时
     * <p>
     * initialDelay  +fixedRate  先等待 initialDelay 设置的时间，然后再按照fixedRate间隔持续执行
     * <p>
     * cron  cron 表达式， zone 用来指定 cron 表达式的时区
     */


    @Scheduled(fixedRate = 300 * SECOND)
    public void logTimer() throws Exception {

        log.info("日志定时器心跳 : {}", DateTimeUtils.of(DateTimePattern.YYYY_MM_DD_HH_MM_SS));
    }


//    @Scheduled(fixedRate = SECOND)
    public void randomTask() {

        List<MemberTask> list = Lists.newArrayList();
        int i1 = ThreadLocalRandom.current().nextInt(10);
        log.info("[{}] 产生了 [{}] 个任务",new SimpleDateFormat(DateTimePattern.YYYY_MM_DD_HH_MM_SS).format(new Date()),i1);
        for (int i = 0; i < i1; i++) {
            MemberTask memberTask = new MemberTask();
            memberTask
                    .setState(1)
                    .setContent(String.valueOf(ThreadLocalRandom.current().nextInt()))
                    .setSuccess(false)
                    .setName("任务 "+String.valueOf(ThreadLocalRandom.current().nextInt()))
                    .setType(1)
                    .setRemark("哈哈哈")
                    .setGmtExecute(DateUtils.next(ThreadLocalRandom.current().nextInt(20000), Calendar.SECOND, new Date()));
            list.add(memberTask);

        }

        memberTaskRepo.saveAll(list);

    }




    @Scheduled(fixedRate = 5 * SECOND)
    public void dispatchTask() {


        if (log.isDebugEnabled()){
            log.debug("每5秒去扫描任务库，对任务进行调度，然后发送到异步任务队列中进行消费...");
        }
        Date start = DateUtils.parse(DateUtils.currentTime(), DateTimePattern.YYYY_MM_DD_HH_MM_SS);
        Date end = DateUtils.next(5, Calendar.SECOND, start);
        List<MemberTask> list = memberTaskRepo.findByGmtExecuteBetweenAndStateAndDeletedIsFalse(start, end, 1);

        list.forEach(memberTask -> {
            log.info("{} 被发送到消费队列...", memberTask.getName());

            memberTask.setState(2);
            memberTaskRepo.saveAndFlush(memberTask);
            asyncMethod.consume(memberTask);
        });

    }

}
