package com.simply.zuozuo.util.annotation;

import com.simply.zuozuo.entity.po.User;
import com.simply.zuozuo.util.Print;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author Created by 谭健 on 2018/4/11 0011. 星期三. 15:32.
 * © All Rights Reserved.
 */


@Component
@Aspect
@Slf4j
public class MarkAspect implements Cut {


    @Pointcut("@annotation(Mark)")
    @Override
    public void baseCut() {
    }


    /**
     * 如果around定义了并且before/after也同时定义了
     * around 就会只执行一次
     */
    @Around("baseCut()")
    @Override
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        log.info(" ------------------- 环绕");

        // proceed 是方法执行之后的返回值
        // 我们甚至可以通过返回其它的值改变返回值
        // 比如返回null会导致被切入的方法返回null
        Object proceed = proceedingJoinPoint.proceed();

        ((List<User>) proceed).forEach(Print::echo);

        return proceed;
    }

    @Before("baseCut()")
    @Override
    public void before(JoinPoint joinPoint) {




        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();


        // 比如，切入某个类，给这个类扣个屎盆子
        log.info("我给 {} 扣个屎盆子",method);

        Mark mark = method.getAnnotation(Mark.class);

        log.info("method name is : {}", method.getName());

        log.info("方法执行 ： {}", mark.value());
        log.info("----------- before");


    }


    @After("baseCut()")
    @Override
    public void after(JoinPoint joinPoint) {

        log.info("----------- after");

    }


    @AfterThrowing("baseCut()")
    @Override
    public void afterThrowing() {

        log.info(" --------AfterThrowing");
    }


    @AfterReturning("baseCut()")
    @Override
    public void afterReturning() {

        log.info("-----afterReturning");
    }
}
