package com.simply.zuozuo.handle.interceptor;

import com.simply.zuozuo.entity.po.VisitInfo;
import com.simply.zuozuo.dao.repo.VisitInfoRepo;
import com.simply.zuozuo.util.ApplicationContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Created by 谭健 on 2018/3/30 0030. 星期五. 13:13.
 * © All Rights Reserved.
 */

@Slf4j
public class HandleInterceptorImpl implements HandlerInterceptor {



    private VisitInfoRepo visitInfoRepo() {
        return (VisitInfoRepo) ApplicationContextUtils.applicationContext.getBean("visitInfoRepo");
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 请求还没被处理
        //     log.info("HandleInterceptorImpl.preHandle");

        printAccessInformation(true, request);

        keepTracesOfAccess(true, request);

        // 开始
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        // 请求已经被处理
        //     log.info("HandleInterceptorImpl.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        // 整个请求结束
        //  log.info("HandleInterceptorImpl.afterCompletion");
    }


    /**
     * 是否保留用户的访问痕迹
     */
    private void keepTracesOfAccess(boolean keep, HttpServletRequest request) {
        if (keep) {
            VisitInfo visitInfo = new VisitInfo()
                    .setIp(request.getRemoteAddr())
                    .setLocation(request.getRequestURI())
                    .setUserId(0L)
                    .setMethod(HttpMethod.resolve(request.getMethod()));

            visitInfoRepo().save(visitInfo);
        }
    }


    /**
     * 是否打印用户的访问
     */
    private void printAccessInformation(boolean print, HttpServletRequest request) {
        log.info("[{}] : {}", request.getMethod(), request.getRequestURI());
    }
}
