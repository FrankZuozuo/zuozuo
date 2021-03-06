
package com.simply.zuozuo.dao.repo;

import com.simply.zuozuo.entity.po.Customer;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

/**
 * @author Created by 谭健 on 2018/4/3 0003. Tuesday. 14:56.
 * © All Rights Reserved.
 */


@Transactional(rollbackFor = {Exception.class})
public interface CustomerRepo extends BaseRepo<Customer, Long> {


    @Nullable
    List<Customer> findByFirstName(@Nullable String firstName);
}
