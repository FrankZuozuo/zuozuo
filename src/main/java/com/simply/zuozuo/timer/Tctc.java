package com.simply.zuozuo.timer;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

/**
 * @author Created by 谭健 on 2018/7/18 0018. 星期三. 13:17.
 * © All Rights Reserved.
 */
public class Tctc {


    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        long x = 0;
        while (true){
            if (l+1000<= System.currentTimeMillis()) break;
            else x++;
        }
        System.out.println(x*2);
    }
}
