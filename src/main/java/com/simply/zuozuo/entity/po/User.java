package com.simply.zuozuo.entity.po;

import com.simply.zuozuo.entity.validate.group.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Slf4j
@Entity
@Table(name = "user")
@DynamicInsert
@DynamicUpdate
public class User implements Serializable{


    private static final long serialVersionUID = -6176713780188413811L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModify;


    @NotBlank
    private String username;



    private String code;

    private String password;


    /**
     * 指定姓名的长度，最小2，最大30
     */
    @Size(min = 2,max = 30)
    private String name;

    /**
     *
     * 指定这个值的范围，最大不能超过150，最小不能小于18
     */
    @Max(150)
    @Min(18)
    private Integer age;

    /**
     * 符合Email的正则
     */
    @Email
    private String email;

    /**
     * 非空验证并且忽略空格
     * "  "也会被认为是不合法的
     */
    @NotBlank(groups = {UserGroup.class})
    private String note;

    /**
     * 非空验证
     * 不能是null，size不能是0
     * Collection 长度不能是0
     */
    @NotEmpty
    private String of;

    /**
     * 不为空验证
     */
    @NotNull
    private String phone;;

    /**
     * 正则表达式验证
     */
    @Size(max = 18,min = 15)
    @Pattern(regexp = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$")
    private String idCard;

    /**
     * 验证字符串是不是指定精度的数字
     * integer 整数部分精度
     * fraction 小数部分精度
     */
    @Digits(integer = 10,fraction = 2)
    private BigDecimal money;

}