package com.simply.zuozuo.entity.ao;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Created by 谭健 on 2018/4/19 0019. Thursday. 12:44.
 * © All Rights Reserved.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Author {



    private String name,sex,englishName;

    private Integer age;

    private List<String> email,phone,website,blog,qq,weichat;



}
