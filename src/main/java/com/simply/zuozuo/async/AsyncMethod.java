package com.simply.zuozuo.async;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Created by 谭健 on 2018/5/2 0002. 星期三. 13:23.
 * © All Rights Reserved.
 */
@Component
@Slf4j
public class AsyncMethod {



    @Async
    public void run(){


        try {
            log.info("执行异步操作");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("async method");
    }


}
