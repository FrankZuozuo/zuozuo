

package com.simply.zuozuo.controller.compent.filter;

import com.simply.zuozuo.entity.po.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

/**
 * @author Created by 谭健 on 2018/4/23 0023. 星期一. 11:43.
 * © All Rights Reserved.
 */

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class JPAUserFilter implements Specification<User> {

    private static final long serialVersionUID = -219303168122852185L;
    private User user;


    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        return criteriaBuilder.and(
                criteriaBuilder.like(root.get("username").as(String.class), "%" + user.getUsername() + "%"),
                criteriaBuilder.like(root.get("of").as(String.class), "%" + user.getOf() + "%")
        );
    }
}
