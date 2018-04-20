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
 * @author Created by 谭健 on 2018/4/19 0019. Thursday. 12:00.
 * © All Rights Reserved.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class App {

    private String name, version, describe;

    private List<String> projectFramework, plugin, drive, specification, test, runtime, doc, dataInteraction;

    private Author author;
}
