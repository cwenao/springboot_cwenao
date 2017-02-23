/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.esserver.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author cwenao
 * @version $Id DataConfig.java, v 0.1 2017-01-24 17:43 cwenao Exp $$
 */

@Configuration
@EnableTransactionManagement
public class DataConfig {
    Logger logger = LoggerFactory.getLogger(DataConfig.class);

    @Bean
    public ServletRegistrationBean druidServlet() {
        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    }

    @Bean(name = "dataSource",initMethod = "init", destroyMethod = "close")
    public DataSource druidDataSource(@Value("${druid.datasource.driverClassName}") String driver,
                                      @Value("${druid.datasource.url}") String url, @Value("${druid.datasource.username}") String username,
                                      @Value("${druid.datasource.password}") String password,
                                      @Value("${druid.datasource.initialSize}") Integer initialSize,
                                      @Value("${druid.datasource.minIdle}") Integer minIdle,
                                      @Value("${druid.datasource.maxActive}") Integer maxActive) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setValidationQuery("SELECT * FROM DUAL");
        druidDataSource.setPoolPreparedStatements(false);
        try {
            druidDataSource.setFilters("stat");
        } catch (SQLException e1) {
            logger.error("setFilters error", e1);
        }
        try {
            druidDataSource.setFilters("stat, wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer bean = new MapperScannerConfigurer();
        bean.setBasePackage("com.bootcwenao.esserver.mapper");
        return bean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}

