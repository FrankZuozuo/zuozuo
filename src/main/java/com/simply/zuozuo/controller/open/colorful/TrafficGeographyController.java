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
import com.simply.zuozuo.entity.jo.ReverseCoordinateJO;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import static com.simply.zuozuo.util.open.AliyunAPIUtils.*;

import java.util.List;

/**
 * @author Created by 谭健 on 2018/6/1 0001. 星期五. 14:00.
 * © All Rights Reserved.
 * <p>
 * 交通地理
 */


@RestController
@RequestMapping("/open")
@Slf4j
public class TrafficGeographyController {

    private RestTemplate restTemplate;

    @Autowired
    public TrafficGeographyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    // ip 定位
    @GetMapping("/ipPositioning")
    public ApiResponse ipPositioning(@RequestParam(defaultValue = "115.195.157.219") String ip) {
        List<NameValuePair> nameValuePairs = Lists.newArrayList();
        nameValuePairs.add(new BasicNameValuePair("ip", ip));
        IpPositioningJO o = (IpPositioningJO) get(AliyunAPIConfig.APP.IP_POSITIONING, nameValuePairs,IpPositioningJO.class,restTemplate);
        return ApiResponse.returnWith().success(o);
    }


    // 经纬度逆向编码
    @GetMapping("/reverseCoordinate")
    public ApiResponse reverseCoordinate(@RequestParam(defaultValue = "116.48976000793644,39.984900765873") String location) {
        List<NameValuePair> nameValuePairs = Lists.newArrayList();
        nameValuePairs.add(new BasicNameValuePair("location", location));
        ReverseCoordinateJO o = (ReverseCoordinateJO) get(AliyunAPIConfig.APP.REVERSE_COORDINATE, nameValuePairs,ReverseCoordinateJO.class,restTemplate);
        return ApiResponse.returnWith().success(o);
    }



}
