package com.simply.zuozuo.util;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.simply.zuozuo.entity.po.User;
import org.apache.shiro.SecurityUtils;

/**
 * @author Created by 谭健 on 2018/7/17 0017. 星期二. 11:04.
 * © All Rights Reserved.
 */
public class CrtUserUtils {


    public static User getUser(){
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return user == null ? new User().setUsername("游客"):user;
    }

}
