package com.simply.zuozuo.util.annotation;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Created by 谭健 on 2018/5/9 0009. 星期三. 17:04.
 * © All Rights Reserved.
 */

@Slf4j
public class IsSuccessValid implements ConstraintValidator<IsSuccess,Object> {

    /**
     * 注解在校验的时候做初始化工作
     */
    @Override
    public void initialize(IsSuccess constraintAnnotation) {
        log.info("校验注解初始化");
    }


    /**
     * 注解的校验逻辑
     */
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        // 校验成功返回true，失败返回false
        // 返回false BindingResult会捕获这个错误


        return false;
    }
}
