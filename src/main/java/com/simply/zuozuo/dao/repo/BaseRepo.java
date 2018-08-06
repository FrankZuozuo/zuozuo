package com.simply.zuozuo.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

/**
 * @author Created by 谭健 on 2018/4/4 0004. Wednesday. 10:31.
 * © All Rights Reserved.
 *
 * @NoRepositoryBean JPA在实例化的时候不会去实例化BaseRepo
 *
 */

@NoRepositoryBean
public interface BaseRepo<T, ID extends Serializable> extends JpaRepository<T, ID>,JpaSpecificationExecutor<T> {

}
