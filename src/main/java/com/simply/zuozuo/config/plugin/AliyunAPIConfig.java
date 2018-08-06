package com.simply.zuozuo.config.plugin;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import lombok.Getter;

/**
 * @author Created by 谭健 on 2018/6/1 0001. 星期五. 14:19.
 * © All Rights Reserved.
 *
 *
 * 阿里云 api 的配置， 可以接入阿里云第三方的 api
 */
public class AliyunAPIConfig {


    @Getter
    public enum APP{

        IP_POSITIONING("http://iploc.market.alicloudapi.com/v3/ip","640ba56f81d34342816e173e59fc8020"),
        REVERSE_COORDINATE("https://regeo.market.alicloudapi.com/v3/geocode/regeo","640ba56f81d34342816e173e59fc8020")
        ;

        private String url;
        private String appCode;

        APP(String url, String appCode) {
            this.url = url;
            this.appCode = appCode;
        }
    }
}
