package com.simply.zuozuo.util.annotation;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.simply.zuozuo.util.CrtUserUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Created by 谭健 on 2018/7/17 0017. 星期二. 10:37.
 * © All Rights Reserved.
 *
 *
 * 有些日子需要打印，但是又比较容易忘记写，容易导致大部分地方写了日志，但是仍然有不少遗漏
 * 并且每次编写日志，是一件繁琐而且枯燥的事情，通过切入文档，可以得到与文档描述完全相同的日志输出
 *
 */
@Slf4j
@Aspect
@Component
public class ApiLogAspect {




    @Before("@annotation(io.swagger.annotations.ApiOperation)")
    public void logBeforeMethodRun(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        log.info("[{}] 进入方法 [{}.{}]-[{}] ...",CrtUserUtils.getUser().getUsername(),method.getDeclaringClass(),method.getName(),apiOperation.value());
    }

    @After("@annotation(io.swagger.annotations.ApiOperation)")
    public void logAfterMethodRun(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        log.info("[{}] 结束方法 [{}.{}]-[{}] ...",CrtUserUtils.getUser().getUsername(),method.getDeclaringClass(),method.getName(),apiOperation.value());
    }
}
