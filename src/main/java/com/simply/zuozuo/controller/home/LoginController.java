package com.simply.zuozuo.controller.home;

import com.simply.zuozuo.common.ApiResponse;
import com.simply.zuozuo.entity.po.User;
import com.simply.zuozuo.dao.repo.UserRepo;
import com.simply.zuozuo.util.Print;
import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Created by 谭健 on 2018/4/19 0019. Thursday. 14:22.
 * © All Rights Reserved.
 */


@Controller
@Slf4j
public class LoginController {


    private UserRepo userRepo;

    @Autowired
    public LoginController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public String login(String password, String username) {

        Print.echo("到登录接口了");

        // 获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        // currentUser是匿名的，我们必须确保这个用户已经登录过一次了，那么我们看这个用户是否已经被认证过了
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);

            // 记住我
            token.setRememberMe(true);


            User user = new User();
            try {
                currentUser.login(token);
                user = userRepo.findByUsername(username);

                log.info("currentUser is : [{}] logged successfully", currentUser.getPrincipal());
                // 下面是一些shiro可能抛出的异常
            } catch (IncorrectCredentialsException e) {

                // IncorrectCredentialsException - 密码不对
                // UnknownAccountException - 用户名不存在导致
                // LockedAccountException - 签名被锁定不允许登录了
                // AuthenticationException - 意料之外的异常
                e.printStackTrace();
            }

            // 在web环境下，Session是基于httpSession的
            Session currentUserSession = currentUser.getSession();
            currentUserSession.setAttribute("key", "value");
            // 缓存用户信息到session,可以创建更为复杂的 session user类保存用户的常用信息
            currentUserSession.setAttribute("user", user);
        }


        return "login success";
    }


    @GetMapping("/getUser")
    @ResponseBody
    public ApiResponse getUser() {
        Subject currentUser = SecurityUtils.getSubject();
        return ApiResponse.returnWith().success(currentUser.getSession().getAttribute("user"));
    }


//
//    @PostMapping("/logout")
//    public Api logout(){
//
//        Subject currentUser = SecurityUtils.getSubject();
//
//
//        return Api.returnWith().success(currentUser);
//    }

}
