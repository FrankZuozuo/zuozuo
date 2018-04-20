package com.simply.zuozuo.handle.shiro;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @author Created by 谭健 on 2018/4/19 0019. Thursday. 16:50.
 * © All Rights Reserved.
 */
public class HandleCredentialsMatcherResolver extends SimpleCredentialsMatcher{


    /**
     * 凭证匹配器，验证密码是否合法
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo info) {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 用户打的密码
        String inPassword = new String(token.getPassword());
        // 数据库的密码
        String dbPassword = (String) info.getCredentials();
        return equals(inPassword,dbPassword);
    }
}
