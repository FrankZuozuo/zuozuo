package com.simply.zuozuo.dao.repo;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.simply.zuozuo.entity.po.MemberTask;

import java.util.Date;
import java.util.List;

/**
 * @author Created by 谭健 on 2018/7/3 0003. 星期二. 14:59.
 * © All Rights Reserved.
 */
public interface MemberTaskRepo



    extends BaseRepo<MemberTask,Long>
{


    List<MemberTask> findByGmtExecuteBetweenAndStateAndDeletedIsFalse(Date gmtExecuteStart,Date gmtExecuteEnd,Integer state);
}
