package com.simply.zuozuo.handle.shiro;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.alibaba.fastjson.JSON;
import com.simply.zuozuo.common.ApiResponse;
import com.simply.zuozuo.consts.enums.HttpStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.AdviceFilter;
import sun.rmi.runtime.Log;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Created by 谭健 on 2018/6/11 0011. 星期一. 12:39.
 * © All Rights Reserved.
 */

@Slf4j
public class HandleAdviceFilter extends AdviceFilter {


    private boolean isAjaxRequest(HttpServletRequest request) {
        String XRequestedWith = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equalsIgnoreCase(XRequestedWith);
    }


    private boolean isLoginRequest() {
        // TODO 进行登录验证
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Object attribute = session.getAttribute("");
        if (attribute == null) {
            return false;
        }
        return true;
    }


    /**
     * shiro 自己的拦截器， 跟 HandlerInterceptor 是一个差不多的东西
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

        return true;


        // 如果前后端分离，通过ajax 通信
        // 需要对ajax 进行不同的处理，因为ajax 不能接受重定向返回的值

//
//        if (isAjaxRequest((HttpServletRequest) request)) {
//            if (isLoginRequest()) {
//                return true;
//            }
//            log.info("Ajax 请求没有登录或者授权。");
//            // 返回
//            response.setCharacterEncoding("utf-8");
//            response.setContentType("application/json");
//            response.getWriter().println(JSON.toJSONString(ApiResponse.returnWith().fail(HttpStatusEnum.UNAUTHORIZED)));
//        }
//        return false;
    }
}
