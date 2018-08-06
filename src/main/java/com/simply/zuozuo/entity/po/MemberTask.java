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

import javax.persistence.*;
import java.util.Date;

/**
 * @author Created by 谭健 on 2018/7/3 0003. 星期二. 14:55.
 * © All Rights Reserved.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Slf4j
@Entity
@Table(name = "member_task")
@DynamicInsert
@DynamicUpdate



public class MemberTask {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;
    private Date gmtCreate;
    private Date gmtModified;
    private String remark;
    private Integer sort;
    private Boolean deleted;

    private String name;
    private Date gmtExecute;
    private Integer state;
    private String content;
    private Integer type;
    private Boolean success;



}
