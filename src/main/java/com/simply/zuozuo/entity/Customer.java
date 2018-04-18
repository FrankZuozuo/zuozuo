package com.simply.zuozuo.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Created by 谭健 on 2018/4/3 0003. Tuesday. 14:48.
 * © All Rights Reserved.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements Serializable{


    private static final long serialVersionUID = -1525831146306099583L;
    @Id
    @GeneratedValue
    private Long id;


    private String firstName;

    private String lastName;



}
