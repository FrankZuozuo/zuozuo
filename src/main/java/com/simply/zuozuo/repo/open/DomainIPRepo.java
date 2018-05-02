package com.simply.zuozuo.repo.open;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.simply.zuozuo.entity.po.open.DomainIPPO;
import com.simply.zuozuo.repo.BaseRepo;

/**
 * @author Created by 谭健 on 2018/4/23 0023. 星期一. 15:11.
 * © All Rights Reserved.
 */
public interface DomainIPRepo

        extends
        BaseRepo<DomainIPPO, Long> {


    DomainIPPO findByHostName(String hostName);
    DomainIPPO findFirstByHostName(String hostName);


}
