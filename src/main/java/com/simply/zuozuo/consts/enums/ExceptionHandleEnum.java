package com.simply.zuozuo.consts.enums;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

/**
 * @author Created by 谭健 on 2018/4/18 0018. Wednesday. 11:58.
 * © All Rights Reserved.
 */
public enum ExceptionHandleEnum implements MetaEnum {


    UNKNOWN_EXCEPTION(90000, "Unknown exception", "预料之外的错误");


    private int code;
    private String reasonPhraseUS, reasonPhraseCN;

    ExceptionHandleEnum(int code, String reasonPhraseUS, String reasonPhraseCN) {
        this.code = code;
        this.reasonPhraseUS = reasonPhraseUS;
        this.reasonPhraseCN = reasonPhraseCN;
    }

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
