package com.simply.zuozuo.util;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */


/**
 * @author Created by 谭健 on 2018/4/23 0023. 星期一. 13:44.
 * © All Rights Reserved.
 */


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

public class PingUtils {


    /**
     * 通过域名获取这个域名所在的IP
     *
     * @param hostName 域名
     * @param timeout  超时
     */
    public static String getIPByHostName(String hostName, int timeout){
        try {
            InetAddress address = InetAddress.getByName(hostName);
            try {
                if (address.isReachable(timeout)) {
                    if (address.getHostAddress() == null || "null".equalsIgnoreCase(address.getHostAddress())){
                        return String.valueOf(address.getAddress());
                    }
                    return address.getHostAddress();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "连接超时";
    }


    public static void main(String[] args) {
        Print.echo(getIPByHostName("ittopic.shapiya.com", 2000));
    }

}

