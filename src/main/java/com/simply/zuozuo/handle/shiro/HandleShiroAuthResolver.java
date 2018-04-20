package com.simply.zuozuo.handle.shiro;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.simply.zuozuo.entity.po.User;
import com.simply.zuozuo.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Created by 谭健 on 2018/4/19 0019. Thursday. 14:10.
 * © All Rights Reserved.
 */
@Slf4j
public class HandleShiroAuthResolver extends AuthorizingRealm {


    @Autowired
    private UserRepo userRepo;

    /**
     * 权限配置方法，授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return new SimpleAuthorizationInfo();
    }


    /**
     * 认证，登录
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();

        if (username != null){
            User user = userRepo.findByUsername(username);
            String password = user.getPassword();

            // salt : 每个用户都有自己的salt
            ByteSource salt = ByteSource.Util.bytes(user.getCode());
            return new SimpleAuthenticationInfo(username, password, salt, this.getClass().getName());
        }

        return null;

    }


}
