package com.simply.zuozuo.plugin.weixin;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.weixin4j.Configuration;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.http.OAuthToken;
import org.weixin4j.pay.JsApiTicket;
import org.weixin4j.pay.SignUtil;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadLocalRandom;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

/**
 * @author Created by 谭健 on 2018/5/24 0024. 星期四. 9:39.
 * © All Rights Reserved.
 */

@Data
@Slf4j
@Component
public class WeiXin {

    private static Weixin weixin;
    private static JsApiTicket jsApiTicket;
    private static OAuthToken oAuthToken;

    @PostConstruct
    public static Weixin init() {
        weixin = new Weixin();
        try {
            weixin.login(Configuration.getOAuthAppId(), Configuration.getOAuthSecret());
            log.info("微信登录成功");
        } catch (WeixinException e) {
            log.error("微信登录失败");
            e.printStackTrace();
            log.error(e.getMessage(), e);
            log.error("--------------------------------------");
        }
        return weixin;
    }


    public static JsApiTicket getJsApiTicket() throws Exception {
        if (jsApiTicket == null || jsApiTicket.isExprexpired()) {
            jsApiTicket = weixin.getJsApi_Ticket();
            return jsApiTicket;
        } else return jsApiTicket;
    }

    public static OAuthToken getOAuthToken() throws Exception {
        if (oAuthToken == null || weixin == null || oAuthToken.isExprexpired()) {
            oAuthToken = weixin.login(Configuration.getOAuthAppId(), Configuration.getOAuthSecret());
            return oAuthToken;
        } else return oAuthToken;
    }

    public static String getAccessToken()throws Exception{
        return getOAuthToken().getAccess_token();
    }


    /**
     * 微信JS-SDK初始化配置需要的参数
     * @param url 需要调用微信JS-SDK的页面绝对地址
     */
    public static Config getConfig(String url)throws Exception{
        Config config = new Config();
        config.setAppid(Configuration.getOAuthAppId());
        String timestamp = String.valueOf(System.currentTimeMillis()/1000);
        config.setTimestamp(timestamp);
        String nonceStr = String.valueOf(ThreadLocalRandom.current().nextInt(89999999)+10000000);
        config.setNonceStr(nonceStr);
        String signature = SignUtil.getSignature(getJsApiTicket().getTicket(),nonceStr,timestamp,url);
        config.setSignature(signature);
        config.setUrl(url);
        return config;
    }




    @Data
    public static class Config{

        private String appid;
        // 生成签名的时间戳
        private String timestamp;
        // 生成签名的随机串
        private String nonceStr;
        // 签名
        private String signature;
        private String url;
    }




}
