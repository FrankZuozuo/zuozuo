package com.simply.zuozuo.handle;

import com.simply.zuozuo.consts.enums.CustomMetaEnum;
import com.simply.zuozuo.consts.enums.ExceptionHandleEnum;
import com.simply.zuozuo.consts.enums.HttpStatusEnum;
import com.simply.zuozuo.consts.enums.UserMetaEnum;
import com.simply.zuozuo.controller.Api;
import com.simply.zuozuo.exception.ParameterIllegalityException;
import com.simply.zuozuo.util.stringconn.StringConn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Created by 谭健 on 2018/4/16 0016. 星期一. 10:13.
 * © All Rights Reserved.
 */

@ControllerAdvice
@Slf4j
public class HandleExceptionResolver {


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Api resolveException(HttpServletRequest request, HttpRequestMethodNotSupportedException e) {
        String[] supportedMethods = ((HttpRequestMethodNotSupportedException) e).getSupportedMethods();
        StringBuffer buffer = new StringBuffer(30);
        String methods;
        if (supportedMethods != null) {
            for (String method : supportedMethods) {
                buffer.append(method).append(",");
            }
        }
        methods = buffer.toString().substring(0, buffer.length() - 1);
        CustomMetaEnum customResult = new CustomMetaEnum(90002, e.getMessage(), StringConn.of("请使用 [", methods, "] 发起请求"));
        log.error("请求方式不被支持 ： {}", e.getMessage());
        return Api.returnWith().fail(customResult);
    }


    @ExceptionHandler(ParameterIllegalityException.class)
    @ResponseBody
    public Api resolveException(HttpServletRequest request, ParameterIllegalityException e) {
        CustomMetaEnum customResult = new CustomMetaEnum(90001, "Parameter illegality", e.getMessage());
        log.error("参数不合法 ： \n{}", e.getMessage());
        return Api.returnWith().fail(customResult);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Api resolveException(HttpServletRequest request, Exception e) {
        return Api.returnWith().fail(ExceptionHandleEnum.UNKNOWN_EXCEPTION);
    }
}
