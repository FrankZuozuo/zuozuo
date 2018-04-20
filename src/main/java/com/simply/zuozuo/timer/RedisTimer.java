package com.simply.zuozuo.timer;


import com.simply.zuozuo.util.JedisSingleton;
import com.simply.zuozuo.util.Print;
import com.simply.zuozuo.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author Created by 谭健 on 2018/3/30 0030. 星期五. 10:40.
 * © All Rights Reserved.
 */


@Slf4j
public class RedisTimer {


    public static void setTimeNow() {


        Jedis jedis = JedisSingleton.getInstance();

        String nowTime = jedis.get("now_time");
        if (log.isInfoEnabled()) {
            log.info("Redis定时器心跳 : {}", nowTime);
        }

    }


}
