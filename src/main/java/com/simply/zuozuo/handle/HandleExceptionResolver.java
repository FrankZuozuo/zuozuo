package com.simply.zuozuo.handle;

import com.simply.zuozuo.consts.enums.CustomMetaData;
import com.simply.zuozuo.consts.enums.ExceptionHandleEnum;
import com.simply.zuozuo.common.ApiResponse;
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
    public ApiResponse resolveException(HttpServletRequest request, HttpRequestMethodNotSupportedException e) {
        String[] supportedMethods = e.getSupportedMethods();
        StringBuilder buffer = new StringBuilder(30);
        String methods;
        if (supportedMethods != null) {
            for (String method : supportedMethods) {
                buffer.append(method).append(",");
            }
        }
        methods = buffer.toString().substring(0, buffer.length() - 1);
        CustomMetaData customResult = new CustomMetaData(90002, e.getMessage(), StringConn.of("请使用 [", methods, "] 发起请求"));
        log.error("请求方式不被支持 ： {}", e.getMessage());
        return ApiResponse.returnWith().fail(customResult);
    }


    @ExceptionHandler(ParameterIllegalityException.class)
    @ResponseBody
    public ApiResponse resolveException(HttpServletRequest request, ParameterIllegalityException e) {
        CustomMetaData customResult = new CustomMetaData(90001, "Parameter illegality", e.getMessage());
        log.error("参数不合法 ： \n{}", e.getMessage());
        return ApiResponse.returnWith().fail(customResult);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResponse resolveException(HttpServletRequest request, Exception e) {
        log.error("Exception is : {}", e.getClass().getName());
        e.printStackTrace();
        return ApiResponse.returnWith().fail(ExceptionHandleEnum.UNKNOWN_EXCEPTION);
    }
}
