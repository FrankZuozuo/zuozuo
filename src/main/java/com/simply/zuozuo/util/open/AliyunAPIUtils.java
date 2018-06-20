package com.simply.zuozuo.util.open;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.simply.zuozuo.config.plugin.AliyunAPIConfig;
import org.apache.http.NameValuePair;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Created by 谭健 on 2018/6/1 0001. 星期五. 15:41.
 * © All Rights Reserved.
 */
public class AliyunAPIUtils {


    public static Object get(AliyunAPIConfig.APP app, List<NameValuePair> nameValuePairs, Class<? extends Object> clazz, RestTemplate restTemplate) {
        StringBuilder builder = new StringBuilder(app.getUrl());
        builder.append("?");
        for (NameValuePair nameValuePair : nameValuePairs) {
            builder.append(nameValuePair.getName());
            builder.append("=");
            builder.append(nameValuePair.getValue());
        }
        System.out.println(builder.toString());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "APPCODE " + app.getAppCode());
        HttpEntity<Object> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<?> exchange = restTemplate.exchange(builder.toString(), HttpMethod.GET, httpEntity, clazz);
        return HttpStatus.OK.equals(exchange.getStatusCode()) ? exchange.getBody() : null;
    }
}
