package com.simply.zuozuo.config;


import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author Created by 谭健 on 2018/4/12 0012. 星期四. 9:31.
 * © All Rights Reserved.
 */


@Configuration
@EnableSwagger2
public class Swagger2Config {


    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(getApis())
                .paths(PathSelectors.any())
                .build();
    }


    /**
     * 指定哪些包的接口暴露给Swagger2
     */
    private Predicate<RequestHandler> getApis() {
        return RequestHandlerSelectors.basePackage("com.simply.zuozuo.controller");
    }

    /**
     * 指定构建的文档的基本信息
     */
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Restful Api of zuozuo")
                .contact(getContact())
                .description("基于Swagger2构建的Restful Api文档")
                .termsOfServiceUrl("https://localhost:8081/zuozuo/swagger-ui.html")
                .version("1.0.0")
                .license("© All Rights Reserved . 2018 - 2018 . Fine Me in GitHub .")
                .licenseUrl("https://github.com/FrankZuozuo")
                .build();
    }

    /**
     * 指定构建该API的作者信息
     */
    private Contact getContact() {
        return new Contact("Online zuozuo", "https://blog.csdn.net/qq_15071263", "m15197447018@gmail.com");
    }


}
