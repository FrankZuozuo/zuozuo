package com.simply.zuozuo.controller.open;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.simply.zuozuo.entity.po.MemberTask;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by 谭健 on 2018/7/16 0016. 星期一. 9:10.
 * © All Rights Reserved.
 */

@RestController
@RequestMapping("/open/task")
public class TaskController {





    @ApiOperation("创建一个任务")
    @PostMapping("/createTask")
    public void createTask(){


    }



}
