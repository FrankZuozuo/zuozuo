package com.simply.zuozuo.util;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */


/*

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.regexp.RE;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.core.Response;
import java.io.BufferedInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


*/
/**
 * @author Created by 谭健 on 2018/7/9 0009. 星期一. 9:18.
 * © All Rights Reserved.
 * <p>
 * <p>
 * <p>
 * 对接 青庭公司 第二代短信接口
 */


/*
public class QTSmsUtils {


    // 短信平台登录名
    private static final String USERNAME = "349";
    // 短信平台登录密码
    private static final String USER_PASSWORD = "ZLm4722l";
    // AES加密算法的key
    private static final String PASSWORD = "kw4ihPxp5WCpXuD3";
    // 短信接口url
    private static final String SMS_SEND_URL = "http://apis.hzfacaiyu.com/sms/openCard/";
    private static final String TEST_SMS_SEND_URL = "http://apis.hzfacaiyu.com/sms/";



    public static void sendSms(String content, String phones) {
        String tradeNo = tradeNo();
        String etnumber = "";
        sendSms(tradeNo, USERNAME, USER_PASSWORD, phones, content, etnumber);
    }


    private static void sendSms(String tradeNo, String username, String userPassword, String phones, String content, String etnumber) {
        String sign = getSign(tradeNo, username, userPassword, phones, content, etnumber);
        sendSms(tradeNo, username, userPassword, phones, content, etnumber, sign);
    }


    private static void sendSms(String tradeNo, String username, String userPassword, String phones, String content, String etnumber, String sign) {
        userPassword = doMD5(userPassword);
        Map<String, String> parameterMap = Maps.newHashMap();
        parameterMap.put("tradeNo", tradeNo);
        parameterMap.put("userName", username);
        parameterMap.put("userPassword", userPassword);
        parameterMap.put("phones", phones);
        parameterMap.put("content", content);
        parameterMap.put("etnumber", etnumber);
        parameterMap.put("sign", sign);
        parameterMap.keySet().forEach(s -> {
            System.out.println("请求参数： " + s + ":" + parameterMap.get(s));
        });
        doPost(parameterMap);
    }




    private static WebClient createClient(){
        WebClient webClient = WebClient.create(SMS_SEND_URL);
        webClient.type("application/json;charset=UTF-8");
        return webClient;
    }

    private static void doPost(Map<String, String> parameterMap){
        WebClient webClient = createClient();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String body = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parameterMap);
            Response response = webClient.post(body);
            JSON.toJSONString(response);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    private static void doPost(String url, Map<String, String> data) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        StringBuilder builder = new StringBuilder();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> valuePairs = Lists.newArrayList();
        if (null != data) {
            for (String key : data.keySet()) {
                valuePairs.add(new BasicNameValuePair(key, data.get(key)));
            }
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(valuePairs));
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            BufferedInputStream bis = new BufferedInputStream(httpEntity.getContent());
            byte[] buffer;
            while (0 < bis.read(buffer = new byte[128])) {
                builder.append(new String(buffer, "utf-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpPost.releaseConnection();
        }
        System.out.println(builder.toString());
    }


    private static String tradeNo() {
        String dateTimeStr = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        int random = ThreadLocalRandom.current().nextInt(899) + 100;
        return dateTimeStr + random;
    }

    private static String getTradeNo() {
        String tradeNo;
        int valid = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())) % 4;
        String dateTimeStr = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String version = "10";
        int random = ThreadLocalRandom.current().nextInt(8999) + 1000;
        tradeNo = valid + dateTimeStr + version + random;
        return tradeNo;
    }

    private static String doMD5(String source) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            byte[] digest = md.digest();
            int i;
            StringBuilder builder = new StringBuilder("");
            for (byte aDigest : digest) {
                i = aDigest;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    builder.append("0");
                }
                builder.append(Integer.toHexString(i));
            }
            result = builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }


    private static String getSign(String tradeNo, String username, String userPassword, String phones, String content, String etnumber) {
        Map<String, Object> parameterMap = Maps.newHashMap();
        parameterMap.put("tradeNo", tradeNo);
        parameterMap.put("username", username);
        parameterMap.put("userPassword", userPassword);
        parameterMap.put("phones", phones);
        parameterMap.put("content", content);
        parameterMap.put("etnumber", etnumber);
        String jsonContent = JSON.toJSONString(parameterMap);
        return encrypt(jsonContent, PASSWORD);
    }

    private static String encrypt(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = content.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keySpec = new SecretKeySpec(password.getBytes(), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(password.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return parseByte2HexStr(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String parseByte2HexStr(byte buf[]) {
        StringBuilder builder = new StringBuilder("");
        for (byte aBuf : buf) {
            String hex = Integer.toHexString(aBuf & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            builder.append(hex.toUpperCase());
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        sendSms("你好。", "15197447018");
    }


}

*/