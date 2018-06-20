package com.simply.zuozuo.controller.open;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import com.simply.zuozuo.common.ApiResponse;
import com.simply.zuozuo.entity.po.open.DomainIPPO;
import com.simply.zuozuo.dao.repo.open.DomainIPRepo;
import com.simply.zuozuo.util.PingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Created by 谭健 on 2018/4/23 0023. 星期一. 14:08.
 * © All Rights Reserved.
 */

@RequestMapping("/open/domain")
@Controller
public class DomainController {


    @Autowired
    private DomainIPRepo domainIPRepo;


    @GetMapping("/index")
    public String index() {
        return "open/domain";
    }


    @GetMapping("/getIPByHostName")
    @ResponseBody
    public ApiResponse getIPByHostName(DomainIPPO domainIPPO) {
        String ip = PingUtils.getIPByHostName(domainIPPO.getHostName(), 1000);
        domainIPPO.setIp(ip);
        domainIPRepo.save(domainIPPO);
        return ApiResponse.returnWith().success(ip);
    }
}
