package com.simply.zuozuo.async;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.simply.zuozuo.dao.repo.MemberTaskRepo;
import com.simply.zuozuo.entity.po.MemberTask;
import com.simply.zuozuo.plugin.mail.TaskMail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Created by 谭健 on 2018/5/2 0002. 星期三. 13:23.
 * © All Rights Reserved.
 *
 * 异步方法
 */
@Component
@Slf4j
public class AsyncMethod {


    @Autowired
    private MemberTaskRepo memberTaskRepo;


    @Autowired
    private MailSender mailSender;


    @Async
    public void run(){


        try {
            log.info("执行异步操作");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("async method");
    }







    @Async
    public void consume(MemberTask memberTask){

        try {
            System.out.println(memberTask.toString());


            if (memberTask.getType().equals(1)){

                TaskMail taskMail = JSON.parseObject(memberTask.getContent(),TaskMail.class);
                SimpleMailMessage msg = new SimpleMailMessage();
                msg.setTo(taskMail.getTo());
                msg.setSubject(taskMail.getSubject());
                msg.setText(taskMail.getContent());
                msg.setFrom("m15197447018@163.com");
                mailSender.send(msg);
            }




            log.info("任务被消费...");
            memberTask.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            log.info("任务消费失败...");
            memberTask.setSuccess(false);
        }

        memberTaskRepo.saveAndFlush(memberTask);
    }

}
