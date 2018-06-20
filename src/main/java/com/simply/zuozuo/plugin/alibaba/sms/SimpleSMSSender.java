package com.simply.zuozuo.plugin.alibaba.sms;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.simply.zuozuo.config.plugin.AliyunSMSConfig;
import com.simply.zuozuo.util.ApplicationContextUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Created by 谭健 on 2018/5/31 0031. 星期四. 13:05.
 * © All Rights Reserved.
 */
@Component
@Slf4j
public class SimpleSMSSender {


    // 自动注册短信服务的配置
    @Autowired
    private AliyunSMSConfig smsConfig;


    public static SMS newSMS(){
        return new SMS();
    }


    // 一个短信实体
    @Data
    public static class SMS {
        private String phoneNumbers;
        private String templateParam;
        private String outId;
        private String templateCode;

    }

    @Data
    public static class Result {

        private SendSmsResponse sendSmsResponse;
//        private QuerySendDetailsResponse querySendDetailsResponse;
        private SMS sms;
//        private Query query;
    }


    // 如果希望使用静态方法调用的形式发送可以加入下面2个方法进行发送
    // 如果希望使用@Autowired 自动注册的方式可以不加下面2个方法
    public static Result send(SMS sms) {
        SimpleSMSSender simpleSMSSender = (SimpleSMSSender) ApplicationContextUtils.get("simpleSMSSender");
        return simpleSMSSender.sendSms(sms);
    }

    public static QuerySendDetailsResponse query(Query query) {
        SimpleSMSSender simpleSMSSender = (SimpleSMSSender) ApplicationContextUtils.get("simpleSMSSender");
        return simpleSMSSender.querySendDetails(query);
    }

    /**
     * 发送短信
     *
     *
     * 发送验证码类的短信时，每个号码每分钟最多发送一次，每个小时最多发送5次。
     * 其它类短信频控请参考阿里云
     *
     * @param sms 短信
     */
    public Result sendSms(SMS sms) {
        IAcsClient acsClient = getClient();
        SendSmsRequest request = getRequest(sms);
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
            log.error("发送短信发生错误。错误代码是 [{}]，错误消息是 [{}]，错误请求ID是 [{}]，错误Msg是 [{}]，错误类型是 [{}]", e.getErrCode(), e.getMessage(), e.getRequestId(), e.getErrMsg(), e.getErrorType());
            e.printStackTrace();
        }


//        由于响应不及时，不能在这里构建查询，直接查询，smsSendDetailDTOs 会获取到null，可以考虑异步方法 线程睡眠5秒再查询，结果保存数据库进行持久化
//        // 构建查询
//        Query query = new Query();
//        query.setBizId(sendSmsResponse.getBizId());
//        query.setCurrentPage(1L);
//        query.setPageSize(10L);
//        query.setPhoneNumber(sms.getPhoneNumbers());
//        query.setSendDate(new Date());
//        // 查询发送结果
//        QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(query);

        Result result = new Result();
        result.setSendSmsResponse(sendSmsResponse);
//        result.setQuerySendDetailsResponse(querySendDetailsResponse);
//        result.setQuery(query);
        result.setSms(sms);
        return result;
    }

    public static Query newQuery(){
        return new Query();
    }


    // 构建一个查询器
    @Data
    public static class Query {

        /** 业务ID */
        private String bizId;
        private String phoneNumber;
        private Date sendDate;
        private Long pageSize;
        private Long currentPage;

    }

    /**
     * 查询短信发送结果
     *
     * @param query 查询条件
     */
    public QuerySendDetailsResponse querySendDetails(Query query) {
        IAcsClient acsClient = getClient();
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        request.setPhoneNumber(query.getPhoneNumber());
        request.setBizId(query.getBizId());
        SimpleDateFormat ft = new SimpleDateFormat(smsConfig.getDateFormat());
        request.setSendDate(ft.format(query.getSendDate()));
        request.setPageSize(query.getPageSize());
        request.setCurrentPage(query.getCurrentPage());
        QuerySendDetailsResponse querySendDetailsResponse = null;
        try {
            querySendDetailsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return querySendDetailsResponse;
    }


    // 获取短信请求
    private SendSmsRequest getRequest(SMS sms) {
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(sms.getPhoneNumbers());
        request.setSignName(smsConfig.getSignName());
        request.setTemplateCode(sms.getTemplateCode());
        request.setTemplateParam(sms.getTemplateParam());
        request.setOutId(sms.getOutId());
        return request;
    }


    // 获取短信发送服务机
    private IAcsClient getClient() {
        IClientProfile profile = DefaultProfile.getProfile(smsConfig.getRegionId(), smsConfig.getAccessKeyId(), smsConfig.getAccessKeySecret());
        try {
            DefaultProfile.addEndpoint(smsConfig.getEndpointName(), smsConfig.getRegionId(), smsConfig.getProduct(), smsConfig.getDomain());
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return new DefaultAcsClient(profile);
    }
}
