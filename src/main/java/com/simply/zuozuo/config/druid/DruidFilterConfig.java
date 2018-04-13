package com.simply.zuozuo.config.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author Created by 谭健 on 2018/4/8 0008. 星期日. 10:49.
 * © All Rights Reserved.
 */


@WebFilter(
        filterName = "druidWebStatFilter",
        urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"), //忽略此类型的资源
        }
)
public class DruidFilterConfig extends WebStatFilter{
}
