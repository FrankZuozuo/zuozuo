
package com.simply.zuozuo.repo;

import com.simply.zuozuo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Created by 谭健 on 2018/4/3 0003. Tuesday. 14:56.
 * © All Rights Reserved.
 */


@Transactional(rollbackFor = {Exception.class})
public interface CustomerRepo extends BaseRepo<Customer, Long> {


    @Nullable
    List<Customer> findByFirstName(@Nullable String firstName);
}
