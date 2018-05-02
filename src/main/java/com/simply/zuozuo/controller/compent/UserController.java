package com.simply.zuozuo.controller.compent;

import com.google.common.collect.Lists;
import com.simply.zuozuo.async.AsyncMethod;
import com.simply.zuozuo.consts.enums.HttpStatusEnum;
import com.simply.zuozuo.controller.Api;
import com.simply.zuozuo.controller.compent.filter.JPAUserFilter;
import com.simply.zuozuo.entity.po.User;
import com.simply.zuozuo.entity.validate.group.UserGroup;
import com.simply.zuozuo.mapper.UserMapper;
import com.simply.zuozuo.repo.UserRepo;
import com.simply.zuozuo.util.BindingResultUtils;
import com.simply.zuozuo.util.Print;
import com.simply.zuozuo.util.UUIDUtils;
import freemarker.template.utility.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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


    @Autowired
    private AsyncMethod asyncMethod;

    @PostMapping("/filter")
    public Api filter(User user) {


        List<User> all = userRepo.findAll(new JPAUserFilter(user));


        return Api.returnWith().success(all);
    }


    @PostMapping(value = "/add")
    /**
     * @Valid 指定需要验证的参数
     */
    public Api add(@Valid User user, BindingResult bindingResult) {


        if (bindingResult.hasErrors()){
            return BindingResultUtils.captureError(bindingResult);
        }

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
    public Api namedQuery() {


        User user = userRepo.findByUsername("小明");


        return Api.returnWith().success(user);
    }
}
