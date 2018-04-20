


项目结构：
    
    核心框架：Springboot
    内嵌框架：
        SpringMVC
        Spring-Web
        Quartz-scheduler
        AOP
    数据库连接池：Druid
    数据库：Mysql，Redis
    模版引擎：Freemarker
    持久层框架：JPA，Mybatis混合支持
    集合框架：Guava
    日志框架：logback
    Java版本：1.8
    
插件：

    持久层插件：mybatis-generator-maven-plugin
    Maven插件：maven
    敏捷开发插件：lombok
    Restful访问插件：restTemplate
    JavaMail邮件支持
    
    
驱动：
    
    Redis驱动：Jedis
    JSON驱动：fastjson
    属性注入驱动：兼容基于YAML的属性自动注入
    
    
规范：
        
    Restful：支持
    阿里巴巴开发规范：兼容
    
    
测试：
    
    基于Swagger2构建的测试
    
运行时：
    
    拦截器链：HandlerInterceptor + WebMvcConfigurationSupport方式
    验证器：javax.validation.final
    Html转发：HandleHtmlResolver
    全局异常处理器：HandleExceptionResolver
    
    
文档：
    
    Markdown
    基于Swagger2构建的Restful接口文档

数据交互：

    支持基于JSON的交互
    支持基于XML的交互

描述：
    