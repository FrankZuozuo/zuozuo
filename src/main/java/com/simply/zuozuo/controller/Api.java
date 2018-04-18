package com.simply.zuozuo.controller;

import com.simply.zuozuo.consts.enums.HttpStatusEnum;
import com.simply.zuozuo.consts.enums.MetaEnum;
import com.simply.zuozuo.util.Print;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author Created by 谭健 on 2018/4/16 0016. 星期一. 9:38.
 * © All Rights Reserved.
 */
@Data
@Accessors(chain = true)
public class Api {


    private Meta meta = new Meta();
    private Object data;
    private Date currentTimestemp;


    public Api success(Object data) {
        setMeta(HttpStatusEnum.OK);
        this.data = data;
        this.currentTimestemp = new Date(System.currentTimeMillis());
        return this;
    }


    public Api success(Object data, MetaEnum meta) {
        setMeta(meta);
        this.data = data;
        this.currentTimestemp = new Date(System.currentTimeMillis());
        return this;
    }


    public Api fail(MetaEnum meta) {
        setMeta(meta);
        this.currentTimestemp = new Date(System.currentTimeMillis());
        return this;
    }


    public Api fail(Object data) {
        setMeta(HttpStatusEnum.INTERNAL_SERVER_ERROR);
        this.data = data;
        this.currentTimestemp = new Date(System.currentTimeMillis());
        return this;
    }


    public static Api returnWith() {
        return new Api();
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
    private static class Meta implements MetaEnum {
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
