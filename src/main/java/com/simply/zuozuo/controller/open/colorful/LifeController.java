package com.simply.zuozuo.controller.open.colorful;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.google.common.collect.Lists;
import com.simply.zuozuo.common.ApiResponse;
import com.simply.zuozuo.config.plugin.AliyunAPIConfig;
import com.simply.zuozuo.entity.jo.IpPositioningJO;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.simply.zuozuo.util.open.AliyunAPIUtils.*;
/**
 * @author Created by 谭健 on 2018/6/1 0001. 星期五. 15:40.
 * © All Rights Reserved.
 */

@RestController
@RequestMapping("/open")
@Slf4j
public class LifeController {

    @Autowired
    private RestTemplate restTemplate;






}
