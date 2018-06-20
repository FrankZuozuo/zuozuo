package com.simply.zuozuo.controller.compent;

import com.simply.zuozuo.async.AsyncMethod;
import com.simply.zuozuo.consts.enums.HttpStatusEnum;
import com.simply.zuozuo.common.ApiResponse;
import com.simply.zuozuo.controller.compent.filter.JPAUserFilter;
import com.simply.zuozuo.entity.po.User;
import com.simply.zuozuo.dao.mapper.UserMapper;
import com.simply.zuozuo.dao.repo.UserRepo;
import com.simply.zuozuo.util.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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


    private UserMapper userMapper;
    private UserRepo userRepo;
    private AsyncMethod asyncMethod;

    @Autowired
    public UserController(UserMapper userMapper, UserRepo userRepo, AsyncMethod asyncMethod) {
        this.userMapper = userMapper;
        this.userRepo = userRepo;
        this.asyncMethod = asyncMethod;
    }

    @PostMapping("/filter")
    public ApiResponse filter(User user) {


        List<User> all = userRepo.findAll(new JPAUserFilter(user));


        return ApiResponse.returnWith().success(all);
    }


    @PostMapping(value = "/add")
    /**
     * @Valid 指定需要验证的参数
     */
    public ApiResponse add(@Valid User user, BindingResult bindingResult) {


        user.setCode(UUIDUtils.randomUUIDWithoutRod());
        User user1 = userRepo.save(user);

        return ApiResponse.returnWith().success(user1);
    }


    @RequestMapping(value = "/test2", method = {RequestMethod.GET, RequestMethod.DELETE})
    public ApiResponse test1() {
        int x = 5 / 0;
        return ApiResponse.returnWith().fail(HttpStatusEnum.MOVED_PERMANENTLY);
    }

    @RequestMapping(value = "/test", method = {RequestMethod.POST, RequestMethod.DELETE})
    public ApiResponse test() {
        return ApiResponse.returnWith().fail(HttpStatusEnum.MOVED_PERMANENTLY);
    }

    @GetMapping("/all")
    public String all() {
        List<User> users = userMapper.selectAll();


        asyncMethod.run();
        users.forEach(
                user -> {
                    log.info(user.toString());
                }
        );


        log.info("a haha haha ");

        return "2";
    }


    @GetMapping("/namedQuery")
    public ApiResponse namedQuery() {


        User user = userRepo.findByUsername("小明");


        return ApiResponse.returnWith().success(user);
    }
}
