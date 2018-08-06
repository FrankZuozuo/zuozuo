package com.simply.zuozuo.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

/**
 * @author Created by 谭健 on 2018/3/26 0026. 星期一. 14:53.
 * © All Rights Reserved.
 */

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JedisSingleton {


    private static Jedis jedis = null;

    private static class InsideSingleton {


        private static Jedis initJedis() {
            Jedis jedis = new Jedis();
           // jedis.auth("");
            return jedis;
        }

        private static Jedis jedisSingleton = initJedis();
    }

    public static Jedis getInstance() {
        if (jedis == null) {
            jedis = InsideSingleton.jedisSingleton;
        }
        return jedis;
    }

    public Object readResolve() {
        return jedis;
    }


}
