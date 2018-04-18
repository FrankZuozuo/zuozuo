package com.simply.zuozuo.controller.compent;

import com.simply.zuozuo.consts.enums.HttpStatusEnum;
import com.simply.zuozuo.controller.Api;
import com.simply.zuozuo.entity.User;
import com.simply.zuozuo.entity.validate.group.UserGroup;
import com.simply.zuozuo.mapper.UserMapper;
import com.simply.zuozuo.repo.UserRepo;
import com.simply.zuozuo.util.BindingResultUtils;
import com.simply.zuozuo.util.Print;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Created by 谭健 on 2018/4/2 0002. Monday. 17:16.
 * © All Rights Reserved.
 */


@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepo userRepo;

    @PostMapping(value = "/add")
    /**
     * @Valid 指定需要验证的参数
     */
    public String add(@Validated({UserGroup.class}) User user, BindingResult bindingResult) {


        BindingResultUtils.captureError(bindingResult);

        return user.toString();
    }


    @RequestMapping(value = "/test2", method = {RequestMethod.GET, RequestMethod.DELETE})
    public Api test1() {
        int x = 5 / 0;
        return Api.returnWith().fail(HttpStatusEnum.MOVED_PERMANENTLY);
    }

    @RequestMapping(value = "/test", method = {RequestMethod.POST, RequestMethod.DELETE})
    public Api test() {
        return Api.returnWith().fail(HttpStatusEnum.MOVED_PERMANENTLY);
    }

    @GetMapping("/all")
    public String all() {
        List<User> users = userMapper.selectAll();

        users.forEach(
                user -> {
                    log.info(user.toString());
                }
        );

        return "2";
    }


    @GetMapping("/namedQuery")
    public String namedQuery() {

        userRepo.findAllByAge(1).forEach(
                user -> {
                    Print.echo(user.toString());
                }
        );

        return "3";
    }
}
