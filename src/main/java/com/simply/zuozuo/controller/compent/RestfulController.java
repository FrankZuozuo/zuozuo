package com.simply.zuozuo.controller.compent;

import com.simply.zuozuo.util.Print;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Created by 谭健 on 2018/4/2 0002. Monday. 16:02.
 * © All Rights Reserved.
 */

@RequestMapping("/restful")
@RestController
public class RestfulController {


    /**
     * 自动注入RestTemplate用以执行restful访问
     */
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/get")
    public int get(@RequestParam(name = "x", defaultValue = "0") int x) {


        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);

        Print.echo(quote.toString());

        return x;

    }


    @Data
    @NoArgsConstructor
    public static class Quote {

        private String type;
        private Value value;
    }


    @Data
    @NoArgsConstructor
    public static class Value {

        private String quote;
        private Long id;
    }


}
