package com.simply.zuozuo.controller.compent;

import com.simply.zuozuo.entity.User;
import com.simply.zuozuo.mapper.UserMapper;
import com.simply.zuozuo.repo.UserRepo;
import com.simply.zuozuo.util.Print;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
    public String add(@Valid User user, BindingResult bindingResult) {

        log.info("has error ? {}", bindingResult.hasErrors());


        // 如果有捕获到参数不合法
        if (bindingResult.hasErrors()) {


            // 得到全部不合法的字段
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            // 遍历不合法字段
            fieldErrors.forEach(
                    fieldError -> {
                        // 获取不合法的字段名和不合法原因
                        log.info("error field is : {} ,message is : {}", fieldError.getField(), fieldError.getDefaultMessage());
                    }
            );

        }


        return user.toString();
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
    public String namedQuery(){

        userRepo.findAllByAge(1).forEach(
                user -> {
                    Print.echo(user.toString());
                }
        );

        return "3";
    }
}
