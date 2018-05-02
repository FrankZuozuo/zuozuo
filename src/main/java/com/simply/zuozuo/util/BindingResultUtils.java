package com.simply.zuozuo.util;

import com.simply.zuozuo.consts.enums.CustomMetaData;
import com.simply.zuozuo.controller.Api;
import com.simply.zuozuo.exception.ParameterIllegalityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * @author Created by 谭健 on 2018/4/16 0016. 星期一. 10:00.
 * © All Rights Reserved.
 */

@Slf4j
public class BindingResultUtils {





    public static Api captureError(BindingResult bindingResult) {

        StringBuffer error = new StringBuffer(50);
        error.append(" ");
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(
                fieldError -> {
                    error
                            .append("error field is : [")
                            .append(fieldError.getField())
                            .append("] ,message is : ")
                            .append(fieldError.getDefaultMessage())
                            .append("\n ");
                }
        );
        return Api.returnWith().fail(new CustomMetaData(499, "由于存在非法参数，服务器拒绝响应。", error.toString()));

    }
}
