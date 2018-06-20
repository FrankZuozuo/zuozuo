package com.simply.zuozuo.dao.repo;

import com.simply.zuozuo.entity.po.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

/**
 * @author Created by 谭健 on 2018/4/4 0004. Wednesday. 14:50.
 * © All Rights Reserved.
 */

public interface UserRepo
        extends
        BaseRepo<User, Long>,
        JpaSpecificationExecutor<User> {

    User findByUsername(String username);
}
