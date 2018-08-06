package com.simply.zuozuo.util.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author Created by 谭健 on 2018/4/10 0010. 星期二. 17:07.
 * © All Rights Reserved.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleMailUtils {


    private MailSender mailSender;

    private SimpleMailMessage simpleMailMessage;


    public static void main(String[] args) {

        SimpleMailUtils utils = new SimpleMailUtils();
        utils.test();

    }

    private void test()throws MailException{

        SimpleMailMessage msg = new SimpleMailMessage(simpleMailMessage);

        msg.setTo("347969164@qq.com");
        msg.setText("66666666");

        this.mailSender.send(msg);
    }
}
