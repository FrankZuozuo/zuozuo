package com.simply.zuozuo.plugin.mail;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import lombok.Data;

/**
 * @author Created by 谭健 on 2018/7/16 0016. 星期一. 9:48.
 * © All Rights Reserved.
 */

@Data
public class TaskMail {



    // 邮件主题
    private String subject;
    // 邮件正文
    private String content;
    // 邮件接收人
    private String to;
}
