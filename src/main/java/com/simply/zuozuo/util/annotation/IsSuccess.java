package com.simply.zuozuo.util.annotation;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * @author Created by 谭健 on 2018/5/9 0009. 星期三. 17:03.
 * © All Rights Reserved.
 *
 * 自定义spring的校验注解
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(
        {ElementType.FIELD}
)
@Documented
/**
 * 指定让谁来执行该注解的校验逻辑
 */
@Constraint(validatedBy = IsSuccessValid.class)
public @interface IsSuccess {

    String value() default "success";
}
