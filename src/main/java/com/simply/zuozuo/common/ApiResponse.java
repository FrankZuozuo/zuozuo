package com.simply.zuozuo.common;

import com.simply.zuozuo.consts.enums.HttpStatusEnum;
import com.simply.zuozuo.consts.enums.MetaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

/**
 * @author Created by 谭健 on 2018/4/16 0016. 星期一. 9:38.
 * © All Rights Reserved.
 *
 * 一个作为API 返回的对象
 */
@Data
@Accessors(chain = true)
public class ApiResponse {


    private Meta meta = new Meta();
    private Object data;
    private Date currentTimestamp;


    public ApiResponse success(Object data) {
        setMeta(HttpStatusEnum.OK);
        this.data = data;
        this.currentTimestamp = new Date(System.currentTimeMillis());
        return this;
    }


    public ApiResponse success(Object data, MetaEnum meta) {
        setMeta(meta);
        this.data = data;
        this.currentTimestamp = new Date(System.currentTimeMillis());
        return this;
    }


    public ApiResponse fail(MetaEnum meta) {
        setMeta(meta);
        this.currentTimestamp = new Date(System.currentTimeMillis());
        return this;
    }


    public ApiResponse fail(Object data) {
        setMeta(HttpStatusEnum.INTERNAL_SERVER_ERROR);
        this.data = data;
        this.currentTimestamp = new Date(System.currentTimeMillis());
        return this;
    }


    public static ApiResponse returnWith() {
        return new ApiResponse();
    }


    private void setMeta(MetaEnum meta) {
        this.meta.code = meta.code();
        this.meta.reasonPhraseCN = meta.reasonPhraseCN();
        this.meta.reasonPhraseUS = meta.reasonPhraseUS();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class Meta implements MetaEnum {
        private int code;
        private String reasonPhraseUS, reasonPhraseCN;

        @Override
        public int code() {
            return code;
        }

        @Override
        public String reasonPhraseUS() {
            return reasonPhraseUS;
        }

        @Override
        public String reasonPhraseCN() {
            return reasonPhraseCN;
        }
    }
}
