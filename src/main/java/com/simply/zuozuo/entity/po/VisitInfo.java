package com.simply.zuozuo.entity.po;

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
import org.springframework.http.HttpMethod;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Created by 谭健 on 2018/4/20 0020. Friday. 8:56.
 * © All Rights Reserved.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Slf4j
@Entity
@Table(name = "visit_info")
@DynamicInsert
@DynamicUpdate
public class VisitInfo implements Serializable{


    private static final long serialVersionUID = 6906097418517275871L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;

    private Date gmtModify;
    private Date gmtCreate;


    private String ip;
    private String location;
    private Long userId;

    @Enumerated(EnumType.STRING)
    private HttpMethod method;

}
