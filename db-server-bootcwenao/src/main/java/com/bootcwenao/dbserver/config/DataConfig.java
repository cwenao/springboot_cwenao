/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.dbserver.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author cwenao
 * @version $Id DataConfig.java, v 0.1 2017-01-24 17:43 cwenao Exp $$
 */

@Configuration
@EnableTransactionManagement
public class DataConfig {

    @Bean(name="dataSource")
    @ConfigurationProperties(prefix = "druid.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("config.message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}

