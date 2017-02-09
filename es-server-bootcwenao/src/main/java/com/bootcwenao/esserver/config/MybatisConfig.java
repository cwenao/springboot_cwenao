/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.esserver.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author cwenao
 * @version $Id MybatisConfig.java, v 0.1 2017-01-24 17:38 cwenao Exp $$
 */
@Configuration
@EnableTransactionManagement
@AutoConfigureAfter({DataConfig.class})
@MapperScan(basePackages = {"com.bootcwenao.esserver.mapper"})
public class MybatisConfig implements EnvironmentAware {


    @Autowired
    DataSource dataSource;

    private RelaxedPropertyResolver propertyResolver;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        try {
            ResourcePatternResolver resourcePatternResolver;
            resourcePatternResolver = new PathMatchingResourcePatternResolver();

            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
            bean.setDataSource(dataSource);
            bean.setTypeAliasesPackage(propertyResolver.getProperty("typeAliasesPackage"));
            bean.setMapperLocations(resourcePatternResolver.getResources(propertyResolver.getProperty("mapper-locations")));
            bean.setConfigLocation(new DefaultResourceLoader().getResource(propertyResolver.getProperty("configLocation")));

            return bean.getObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * Set the {@code Environment} that this object runs in.
     *
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment,"mybatis.");
    }
}
