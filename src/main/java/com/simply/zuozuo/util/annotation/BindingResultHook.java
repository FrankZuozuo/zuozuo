package com.simply.zuozuo.util.annotation;

import java.lang.annotation.*;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

/**
 * @author Created by 谭健 on 2018/5/9 0009. 星期三. 10:47.
 * © All Rights Reserved.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(
        {ElementType.METHOD}
)
@Documented
public @interface BindingResultHook {

    boolean enabled() default true;
}
