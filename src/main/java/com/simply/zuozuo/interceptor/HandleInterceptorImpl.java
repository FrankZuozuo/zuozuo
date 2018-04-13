package com.simply.zuozuo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Created by 谭健 on 2018/3/30 0030. 星期五. 13:13.
 * © All Rights Reserved.
 */

@Slf4j
public class HandleInterceptorImpl implements HandlerInterceptor{



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 请求还没被处理
        log.info("HandleInterceptorImpl.preHandle");


        // 开始
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        // 请求已经被处理
        log.info("HandleInterceptorImpl.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        // 整个请求结束
        log.info("HandleInterceptorImpl.afterCompletion");
    }
}
