package com.simply.zuozuo.config;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.google.common.collect.Maps;

import com.simply.zuozuo.handle.shiro.HandleAdviceFilter;
import com.simply.zuozuo.handle.shiro.HandleCredentialsMatcherResolver;
import com.simply.zuozuo.handle.shiro.HandleShiroAuthResolver;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Map;

/**
 * @author Created by 谭健 on 2018/4/19 0019. Thursday. 13:56.
 * © All Rights Reserved.
 */

@Configuration
public class ShiroConfig {


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

        factoryBean.setSecurityManager(securityManager());
        //拦截器.
        Map<String, String> filterChainDefinitionMap = Maps.newLinkedHashMapWithExpectedSize(10);
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");


        // swagger2的页面
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/v2/api-docs/**", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");

        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "anon");

        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);


        //未授权界面;
        factoryBean.setUnauthorizedUrl("/403");
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        factoryBean.setLoginUrl("/403");
        // 登录成功后要跳转的链接
        factoryBean.setSuccessUrl("/index");
        // 注册自定义的过滤器
        Map<String,Filter> filterMap = Maps.newLinkedHashMap();
//        filterMap.put("handleAdviceFilter", handleAdviceFilter());
        factoryBean.setFilters(filterMap);
        return factoryBean;

    }


    /**
     * 配置事务管理器
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    /**
     * 配置的自定义的权限登录器
     */
    @Bean
    public HandleShiroAuthResolver shiroRealm() {
        HandleShiroAuthResolver realm = new HandleShiroAuthResolver();
        realm.setCredentialsMatcher(credentialsMatcherResolver());
        return realm;
    }


    @Bean
    public HandleAdviceFilter handleAdviceFilter(){
        return new HandleAdviceFilter();
    }




    @Bean
    public HandleCredentialsMatcherResolver credentialsMatcherResolver() {
        return new HandleCredentialsMatcherResolver();
    }


    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager());
        return advisor;
    }


}
