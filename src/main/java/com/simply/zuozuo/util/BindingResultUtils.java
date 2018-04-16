package com.simply.zuozuo.util;

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


    public static void captureError(BindingResult bindingResult) throws RuntimeException {

        // 如果有捕获到参数不合法
        if (bindingResult.hasErrors()) {
            StringBuffer buffer = new StringBuffer(50);
            buffer.append(" ");
            // 得到全部不合法的字段
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            // 遍历不合法字段
            fieldErrors.forEach(
                    fieldError -> {
                        buffer
                                .append("error field is : [")
                                .append(fieldError.getField())
                                .append("] ,message is : ")
                                .append(fieldError.getDefaultMessage())
                                .append("\n ");
                    }
            );

            throw new ParameterIllegalityException(buffer.toString());
        }
    }
}
