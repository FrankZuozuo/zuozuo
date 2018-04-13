package com.simply.zuozuo.controller.compent;

import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by 谭健 on 2018/4/13 0013. 星期五. 9:30.
 * © All Rights Reserved.
 */


/**
 * 用在类上，说明类的用途
 */
@Api(tags = {"swagger2控制器"})
@RequestMapping("/swagger2")
@RestController
public class Swagger2Controller {


    /**
     * 用在方法上，说明方法的用途
     */
    @ApiOperation(value = "get方法", notes = "get用的")
    /**
     * 用在方法上，说明参数的用途
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s", value = "入参", required = true, defaultValue = "ok")
    })
    /**
     * 用在方法上，说明响应的方式
     */
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功", response = Exception.class),
            @ApiResponse(code = 404, message = "请求路径错误", response = Exception.class)
    })
    @GetMapping("/get")
    public String get(String s) {

        return s;
    }


    @PostMapping("/post")
    public SwaggerClass post(){
        return new SwaggerClass().setName("文档").setSize(5000).setDescribe("自动生成的文档");
    }


    /**
     * 用在响应类上，说明响应类
     */
    @ApiModel(description = "返回的响应类")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    public class SwaggerClass{

        @ApiModelProperty(value = "名称")
        private String name;
        @ApiModelProperty(value = "大小")
        private int size;
        @ApiModelProperty(value = "描述")
        private String describe;

    }
}
