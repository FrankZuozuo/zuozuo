package com.simply.zuozuo.util;

import org.springframework.context.ApplicationContext;

/**
 * @author Created by 谭健 on 2018/4/13 0013. 星期五. 11:47.
 * © All Rights Reserved.
 */
public class ApplicationContextUtils {


    public static ApplicationContext applicationContext;

    /**
     * 通过名称获取bean
     */
    public static Object get(String name) {
        return applicationContext.getBean(name);
    }


    /**
     * 通过类型获取bean
     */
    public static Object get(Class<?> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 判断某个bean是不是存在
     */
    public static boolean has(String name) {
        return applicationContext.containsBean(name);
    }


}
