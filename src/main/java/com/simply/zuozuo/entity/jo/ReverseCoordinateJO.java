package com.simply.zuozuo.entity.jo;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.simply.zuozuo.util.JedisSingleton;
import lombok.Data;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * @author Created by 谭健 on 2018/6/1 0001. 星期五. 15:12.
 * © All Rights Reserved.
 */
@Data
public class ReverseCoordinateJO {



    private Integer status;
    private String info;
    private String infocode;
    private Map regeocode;

    public static void main(String[] args) {

        Jedis jedis = new Jedis("39.106.120.126",6379);
        jedis.set("name", "123");
    }


//    @Data
//    public static class Regeocode{
//
//        private String formatted_address;
//        private AddressComponent addressComponent;
//    }
//
//    @Data
//    public static class AddressComponent{
//        private String country;
//        private String province;
//        private Object[] city;
//        private String citycode;
//        private String district;
//        private String adcode;
//        private String township;
//        private String towncode;
//        private Neighborhood neighborhood;
//        private Neighborhood building;
//        private StreetNumber streetNumber;
//        private List<Address> businessAreas;
//    }
//
//    @Data
//    public static class Neighborhood{
//        private String name;
//        private String type;
//    }
//
//    @Data
//    public static class StreetNumber{
//        private String street;
//        private String number;
//        private String location;
//        private String direction;
//        private String distance;
//
//    }
//
//
//    @Data
//    public static class Address{
//        private String location;
//        private String name;
//        private String id;
//    }
}
