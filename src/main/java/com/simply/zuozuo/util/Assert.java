package com.simply.zuozuo.util;


import com.simply.zuozuo.exception.ParameterIllegalityException;

import java.util.List;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

/**
 * @author Created by 谭健 on 2018/5/23 0023. 星期三. 9:27.
 * © All Rights Reserved.
 */
public class Assert {





    public static void notEmpty(Object obj, String msg) {
        if (obj == null) throw new ParameterIllegalityException(msg);
        if (obj instanceof List && ((List) obj).size() == 0) throw new ParameterIllegalityException(msg);
        if (obj instanceof String && ((String) obj).length() == 0) throw new ParameterIllegalityException(msg);
    }

    public static void notTrue(Boolean bool, String msg) {
        if (bool) throw new ParameterIllegalityException(msg);
    }

    public static void isTrue(Boolean bool, String msg) {
        if (!bool) throw new ParameterIllegalityException(msg);
    }

    public static void isFalse(Boolean bool, String msg) {
        if (bool) throw new ParameterIllegalityException(msg);
    }

    public static void notNull(Object obj, String msg) {
        if (obj == null) throw new ParameterIllegalityException(msg);
    }

}
