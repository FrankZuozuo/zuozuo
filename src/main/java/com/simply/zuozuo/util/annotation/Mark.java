package com.simply.zuozuo.util.annotation;

import java.lang.annotation.*;

/**
 * @author Created by 谭健 on 2018/4/11 0011. 星期三. 15:29.
 * © All Rights Reserved.
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(
        {ElementType.METHOD}
)
@Documented
//@Inherited
public @interface Mark {


    String value() default "";

}
