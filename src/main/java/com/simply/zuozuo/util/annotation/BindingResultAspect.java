package com.simply.zuozuo.util.annotation;

import com.simply.zuozuo.exception.ParameterIllegalityException;
import com.simply.zuozuo.util.BindingResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.lang.reflect.Method;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

/**
 * @author Created by 谭健 on 2018/5/9 0009. 星期三. 10:43.
 * © All Rights Reserved.
 */

@Slf4j
@Aspect
@Component
public class BindingResultAspect {

    @Pointcut("@annotation(BindingResultHook)")
    public void bindingResult() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void putMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void deleteMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMapping() {
    }


    @Before("putMapping()")
    public void aspectPutMapping(JoinPoint joinPoint) throws ParameterIllegalityException {
        aspectParametersHandle(joinPoint);
    }

    @Before("deleteMapping()")
    public void aspectDeleteMapping(JoinPoint joinPoint) throws ParameterIllegalityException {
        aspectParametersHandle(joinPoint);
    }

    @Before("postMapping()")
    public void aspectPostMapping(JoinPoint joinPoint) throws ParameterIllegalityException {
        aspectParametersHandle(joinPoint);
    }

    @Before("getMapping()")
    public void aspectGetMapping(JoinPoint joinPoint) throws ParameterIllegalityException {
        aspectParametersHandle(joinPoint);
    }


    @Before("bindingResult()")
    public void aspectBindingResultHook(JoinPoint joinPoint) throws ParameterIllegalityException {
        aspectParameters(joinPoint);
    }



    private void aspectParametersHandle(JoinPoint joinPoint) throws ParameterIllegalityException {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof org.springframework.validation.BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;
                if (bindingResult.hasErrors()) {
                    BindingResultUtils.captureError(bindingResult);
                }
            }
        }
    }


    private void aspectParameters(JoinPoint joinPoint) throws ParameterIllegalityException {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        for (Object arg : args) {
            BindingResultHook annotation = method.getAnnotation(BindingResultHook.class);
            if (annotation.enabled() && arg instanceof org.springframework.validation.BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;
                if (bindingResult.hasErrors()) {
                    BindingResultUtils.captureError(bindingResult);
                }
            }
        }
    }
}
