package com.simply.zuozuo.entity.po.open;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Created by 谭健 on 2018/4/23 0023. 星期一. 15:12.
 * © All Rights Reserved.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Slf4j
@Entity
@Table(name = "open_domain_ip")
@DynamicInsert
@DynamicUpdate
public class DomainIPPO implements Serializable{

    private static final long serialVersionUID = -8346951436508656751L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkId;
    private Date gmtCreate;
    private Date gmtModify;
    private String hostName;
    private String ip;
    private String tel;
    private String email;
    private String qq;
}
