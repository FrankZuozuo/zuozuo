package com.simply.zuozuo.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author Created by 谭健 on 2018/4/8 0008. 星期日. 11:36.
 * © All Rights Reserved.
 */
public class DruidConfig {


    @Autowired
    private DruidProperties druidProperties;


    @Bean
    @Primary
    public DataSource dataSource() {
        DruidDataSource db = new DruidDataSource();
        db.setUrl(druidProperties.getJdbcUrl());
        db.setUsername(druidProperties.getUsername());
        db.setPassword(druidProperties.getPassword());
        db.setValidationQuery(druidProperties.getValidationQuery());
        db.setDriverClassName(druidProperties.getDriverClassName());

        db.setInitialSize(druidProperties.getInitialSize());
        db.setMaxActive(druidProperties.getMaxActive());
        db.setMinIdle(druidProperties.getMinIdle());
        db.setMaxWait(druidProperties.getMaxWait());
        db.setMaxOpenPreparedStatements(druidProperties.getMaxOpenPreparedStatements());
        db.setPoolPreparedStatements(druidProperties.isPoolPreparedStatements());
        db.setTestOnBorrow(druidProperties.isTestOnBorrow());
        db.setTestOnReturn(druidProperties.isTestOnReturn());
        db.setTestWhileIdle(druidProperties.isTestWhileIdle());
        return db;
    }
}
