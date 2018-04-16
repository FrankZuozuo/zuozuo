package com.simply.zuozuo.handle;

import com.simply.zuozuo.consts.enums.CustomMetaEnum;
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


    // 可以对不同的异常做不同的处理
    @ExceptionHandler(Exception.class)
    // 返回对象
    @ResponseBody
    public Api resolveException(HttpServletRequest request, Exception e) {


        if (e instanceof HttpRequestMethodNotSupportedException) {
            String[] supportedMethods = ((HttpRequestMethodNotSupportedException) e).getSupportedMethods();
            StringBuffer buffer = new StringBuffer(30);
            String methods;
            if (supportedMethods != null){
                for (String method : supportedMethods) {
                    buffer.append(method).append(",");
                }
            }
            methods = buffer.toString().substring(0, buffer.length() - 1);
            CustomMetaEnum customResult = new CustomMetaEnum(90002, e.getMessage(), StringConn.of("请使用 [",methods,"] 发起请求"));
            log.error("请求方式不被支持 ： {}", e.getMessage());
            return Api.returnWith().fail(customResult);
        } else if (e instanceof ParameterIllegalityException) {
            CustomMetaEnum customResult = new CustomMetaEnum(90001, "Parameter illegality", e.getMessage());
            log.error("参数不合法 ： \n{}", e.getMessage());
            return Api.returnWith().fail(customResult);
        }
        return Api.returnWith().fail(new CustomMetaEnum(90000, "Unknown exception", "预料之外的错误"));

    }
}
