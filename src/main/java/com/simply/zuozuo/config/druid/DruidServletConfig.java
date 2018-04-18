package com.simply.zuozuo.config.druid;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author Created by 谭健 on 2018/4/8 0008. 星期日. 10:43.
 * © All Rights Reserved.
 */



@WebServlet(
        name = "druidServlet",
        urlPatterns = {
                "/druid/*"
        },
        initParams = {
                @WebInitParam(name = "allow",value = ""), // 配置IP白名单
                @WebInitParam(name = "deny",value = ""), // 配置IP黑名单
                @WebInitParam(name = "loginUsername",value = "root"), // 配置登录名
                @WebInitParam(name = "loginPassword",value = "root"), // 配置登录密码
                @WebInitParam(name = "resetEnable",value = "false") // 是否允许Druid重置
        }
)
public class DruidServletConfig extends StatViewServlet{

        private static final long serialVersionUID = 2971905851511493311L;
}

