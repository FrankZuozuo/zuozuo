package com.simply.zuozuo.util;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeansException;

import static org.springframework.beans.BeanUtils.copyProperties;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

/**
 * @author Created by 谭健 on 2018/3/23 0023. 星期五. 14:43.
 * © All Rights Reserved.
 */
public class CopyPropertiesUtils {



    // 浅拷贝

    public static void doCopy(Object source, Object target) throws BeansException {
        copyProperties(source, target);
    }

    public static void doCopy(Object source, Object target, Class<?> editable) throws BeansException {
        copyProperties(source, target, editable);
    }

    public static void doCopy(Object source, Object target, String... ignoreProperties) throws BeansException {
        copyProperties(source, target, ignoreProperties);
    }





}
