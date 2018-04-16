package com.simply.zuozuo.consts.enums;

/**
 * @author Created by 谭健 on 2018/4/16 0016. 星期一. 9:32.
 * © All Rights Reserved.
 */
public enum  UserMetaEnum implements MetaEnum{

    PASSWORD_ERROR(1000,"Password error","密码错误")

    ;



    private int code;
    private String reasonPhraseUS,reasonPhraseCN;

    UserMetaEnum(int code, String reasonPhraseUS, String reasonPhraseCN) {
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
