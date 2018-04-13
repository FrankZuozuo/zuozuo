package com.simply.zuozuo.controller.compent;

import com.simply.zuozuo.entity.Customer;
import com.simply.zuozuo.repo.CustomerRepo;
import com.simply.zuozuo.util.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by 谭健 on 2018/4/3 0003. Tuesday. 14:58.
 * © All Rights Reserved.
 */


@RequestMapping("/customer")
@RestController
public class CustomerController {


    @Autowired
    private CustomerRepo customer;


    @GetMapping("/all")
    public String all() {

        Iterable<Customer> all = customer.findAll();
        all.forEach(
                customer1 -> {
                    Print.echo(customer1.toString());
                }
        );

        return "1";
    }


    @GetMapping("/findByFirstName")
    public String findByFirstName() {

        customer.findByFirstName("onlinezuozuo")
                .forEach(
                        customer1 -> {
                            Print.echo(customer1.toString());
                        }
                );

        return "2";
    }
}
