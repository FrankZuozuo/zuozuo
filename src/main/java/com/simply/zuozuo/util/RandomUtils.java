package com.simply.zuozuo.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Created by 谭健 on 2018/3/30 0030. 星期五. 10:54.
 * © All Rights Reserved.
 *
 */
public class RandomUtils {




    public static int nextInt(){
        return ThreadLocalRandom.current().nextInt();
    }



}
