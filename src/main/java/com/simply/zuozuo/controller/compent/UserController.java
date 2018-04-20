package com.simply.zuozuo.controller.compent;

import com.simply.zuozuo.consts.enums.HttpStatusEnum;
import com.simply.zuozuo.controller.Api;
import com.simply.zuozuo.entity.po.User;
import com.simply.zuozuo.entity.validate.group.UserGroup;
import com.simply.zuozuo.mapper.UserMapper;
import com.simply.zuozuo.repo.UserRepo;
import com.simply.zuozuo.util.BindingResultUtils;
import com.simply.zuozuo.util.Print;
import com.simply.zuozuo.util.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Api add(@Valid User user, BindingResult bindingResult) {


        BindingResultUtils.captureError(bindingResult);

        user.setCode(UUIDUtils.randomUUIDWithoutRod());
        User user1 = userRepo.save(user);

        return Api.returnWith().success(user1);
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
    public Api namedQuery() {


        User user = userRepo.findByUsername("小明");


        return Api.returnWith().success(user);
    }
}
