package com.simply.zuozuo.exception;

import lombok.NoArgsConstructor;

/**
 * @author Created by 谭健 on 2018/4/16 0016. 星期一. 9:57.
 * © All Rights Reserved.
 *
 * 当捕获到参数不合法时抛出，由全局异常处理器返回
 */
@NoArgsConstructor
public class ParameterIllegalityException extends RuntimeException{


    public ParameterIllegalityException(String message) {
        super(message);
    }

    public ParameterIllegalityException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterIllegalityException(Throwable cause) {
        super(cause);
    }

    protected ParameterIllegalityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
