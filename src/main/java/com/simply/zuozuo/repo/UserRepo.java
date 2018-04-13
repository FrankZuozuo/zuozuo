package com.simply.zuozuo.repo;

import com.simply.zuozuo.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Created by 谭健 on 2018/4/4 0004. Wednesday. 14:50.
 * © All Rights Reserved.
 */

public interface UserRepo extends BaseRepo<User,Long>{

    List<User> findAllByAge(Integer age);
}
