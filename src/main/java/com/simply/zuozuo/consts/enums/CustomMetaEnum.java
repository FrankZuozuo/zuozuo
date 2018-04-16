package com.simply.zuozuo.consts.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Created by 谭健 on 2018/4/16 0016. 星期一. 11:48.
 * © All Rights Reserved.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CustomMetaEnum implements MetaEnum{



    private int code;
    private String reasonPhraseUS,reasonPhraseCN;

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
