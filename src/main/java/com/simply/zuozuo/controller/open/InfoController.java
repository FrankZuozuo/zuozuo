package com.simply.zuozuo.controller.open;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.google.common.collect.Lists;
import com.simply.zuozuo.controller.Api;
import com.simply.zuozuo.entity.ao.App;
import com.simply.zuozuo.entity.ao.Author;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by 谭健 on 2018/4/19 0019. Thursday. 11:56.
 * © All Rights Reserved.
 */

@RequestMapping("/open/info")
@RestController
public class InfoController {


    @GetMapping("/app")
    public Api app() {

        Author author = new Author() {{
            setName("谭健")
                    .setAge(24)
                    .setSex("男")
                    .setEnglishName("Online zuozuo")
                    .setBlog(Lists.newArrayList("https://blog.csdn.net/qq_15071263"))
                    .setEmail(Lists.newArrayList("m15197447018@163.com","m15197447018@gmail.com","347969164@qq.com"))
                    .setPhone(Lists.newArrayList("15197447018"))
                    .setWebsite(Lists.newArrayList("www.wretchant.com"))
                    .setWeichat(Lists.newArrayList("tja6288"))
                    .setQq(Lists.newArrayList("347969164"));
        }};

        App app = new App() {{
            setName("zuozuo")
                    .setAuthor(author)
                    .setVersion("1.0.0")
                    .setDescribe("A Springboot Project")
                    .setProjectFramework(Lists.newArrayList("Springboot", "SpringMVC", "Spring-Web", "Quartz-scheduler", "AOP", "Druid", "Mysql", "Jedis", "Freemarker", "JPA", "Mybatis", "Guava", "logback", "validation"))
                    .setPlugin(Lists.newArrayList("mybatis-generator-maven-plugin", "maven", "lombok", "restTemplate", "JavaMail"))
                    .setDrive(Lists.newArrayList("Jedis", "fastjson", "YAML"))
                    .setSpecification(Lists.newArrayList("Restful", "阿里巴巴开发规范"))
                    .setTest(Lists.newArrayList("Swagger2"))
                    .setRuntime(Lists.newArrayList("HandlerInterceptor", "HandleHtmlResolver", "HandleExceptionResolver", "InterceptorChainLoader"))
                    .setDoc(Lists.newArrayList("Markdown", "基于Swagger2构建的Restful接口文档"))
                    .setDataInteraction(Lists.newArrayList("json", "xml"));
        }};


        return Api.returnWith().success(app);
    }
}
