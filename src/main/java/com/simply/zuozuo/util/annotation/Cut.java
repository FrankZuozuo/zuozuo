package com.simply.zuozuo.util.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author Created by 谭健 on 2018/4/11 0011. 星期三. 16:23.
 * © All Rights Reserved.
 */
public interface Cut {


    default void baseCut(){}

    default Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {return proceedingJoinPoint.proceed();}

    default void before(JoinPoint joinPoint){}

    default void after(JoinPoint joinPoint){}

    default void afterThrowing(){}

    default void afterReturning(){}
}
