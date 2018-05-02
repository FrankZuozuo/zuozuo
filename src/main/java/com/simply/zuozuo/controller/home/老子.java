package com.simply.zuozuo.controller.home;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Created by 谭健 on 2018/4/11 0011. 星期三. 9:49.
 * © All Rights Reserved.
 */
public class 老子 {


    public static String 字符串去掉空格(String string){

       return   string.trim();

    }

    public static void 打印输出(String string){

        System.out.println(string);

    }

    public static int inc(int temp) {
        if (temp > 0) {
            return temp * 2 ;
        }
        return -1 ;
    }




    public static void main(String[] args) {


        for (int i = 0; i < 50; i++) {


            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int[] ints = new int[700000000];
        }



        int num = 2147483647 ;
        long temp = num + 2L ;
        System.out.println(num) ;

        try {
            throw new 吗的异常("爆错了，老逼");
        } catch (老子.吗的异常 吗的异常) {
            吗的异常.printStackTrace();
        }

    }

    public static class 吗的异常 extends Exception{

        吗的异常(String msg){
            super(msg);
        }

    }
}
