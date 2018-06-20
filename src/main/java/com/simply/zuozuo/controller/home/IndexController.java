package com.simply.zuozuo.controller.home;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.simply.zuozuo.entity.po.User;
import com.simply.zuozuo.dao.mapper.UserMapper;
import com.simply.zuozuo.plugin.alibaba.sms.SimpleSMSSender;
import com.simply.zuozuo.util.Print;
import com.simply.zuozuo.util.annotation.Mark;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Created by 谭健 on 2018/3/30 0030. 星期五. 11:19.
 * © All Rights Reserved.
 */

@Slf4j
@Controller
public class IndexController {


    private JavaMailSender mailSender;
    private UserMapper userMapper;
    private MailProperties mailProperties;

    @Autowired
    private SimpleSMSSender simpleSMSSender;

    @Autowired
    public IndexController(JavaMailSender mailSender, UserMapper userMapper, MailProperties mailProperties) {
        this.mailSender = mailSender;
        this.userMapper = userMapper;
        this.mailProperties = mailProperties;
    }


    @GetMapping("/sms")
    @ResponseBody
    public String sms()   {
        SimpleSMSSender.SMS sms = SimpleSMSSender.newSMS();
        sms.setPhoneNumbers("15197447018");
        sms.setTemplateParam("{\"code\":\"123456\"}");
        sms.setTemplateCode("SMS_136166452");
        SimpleSMSSender.Result result = SimpleSMSSender.send(sms);
        return JSON.toJSONString(result);
    }


    @GetMapping("/sms/auto")
    @ResponseBody
    public String smsAuto()  {
        SimpleSMSSender.SMS sms = SimpleSMSSender.newSMS();
        sms.setPhoneNumbers("13526401709");
        sms.setTemplateParam("{\"code\":\"123456\"}");
        sms.setTemplateCode("SMS_136166452");
        SimpleSMSSender.Result result = simpleSMSSender.sendSms(sms);
        return JSON.toJSONString(result);
    }


    @GetMapping("/mail")
    @ResponseBody
    public String mail() throws MailException {

        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("m15197447018@163.com");
//        message.setTo("347969164@qq.com");
//        message.setSubject("Springboot - JavaMail");
//        message.setText("Springboot - JavaMail 发送的测试邮件");
//        mailSender.send(message);
        return "阿瑟大";
    }


    @Data
    public static class Para {

        @NotNull
        @Size(min = 5)
        private String name;
    }

    @ApiOperation(value = "获取全部的用户")
    @GetMapping("/users")
    @ResponseBody
    @Mark("获取全部的用户")
    public List<User> users(@Valid Para para, BindingResult bindingResult) {

        System.out.println(para.toString());

        System.out.println(bindingResult.hasErrors());

        Lists.newArrayList(1, 2, 3, 4, 5).forEach(Print::echo);


        return userMapper.selectAll();
    }


    @GetMapping(value = "/404")
    public String _404() {
        return "404";
    }


    @RequestMapping("/index")
    public String index() {


        return "index";
    }


    @GetMapping("/")
    public ModelAndView html() {

        ModelAndView mv = new ModelAndView("/test");
        List<User> users = userMapper.selectAll();
        users.forEach(
                user -> {
                    Print.echo(user.toString());
                }
        );


        mv.addObject("user", users.get(0));


        log.info(mailProperties.toString());

        return mv;
    }
}
