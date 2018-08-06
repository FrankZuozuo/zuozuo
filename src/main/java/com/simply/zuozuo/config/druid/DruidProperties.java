package com.simply.zuozuo.config.druid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Created by 谭健 on 2018/4/8 0008. 星期日. 11,12.
 * © All Rights Reserved.
 *
 *
 * druid 的 配置项，用来在项目中自动注入
 */

@Slf4j
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "druid")
public class DruidProperties {


    private String
            jdbcUrl,
            username,
            password,
            validationQuery,
            driverClassName;

    private Integer
            initialSize,
            maxActive,
            minIdle,
            maxWait,
            maxOpenPreparedStatements;

    private boolean
            poolPreparedStatements,
            testOnBorrow,
            testOnReturn,
            testWhileIdle;


}
