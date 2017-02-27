/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.bigdataserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

/**
 * @author cwenao
 * @version $Id BigDataApplication.java, v 0.1 2017-02-21 22:38 cwenao Exp $$
 */
@SpringBootApplication
@EnableDiscoveryClient
@ImportResource(locations = {"classpath:/config/hbase-spring.xml"})
public class BigDataApplication {
    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "D:\\\\dev_evn\\\\hadoop-2.7.3");
        SpringApplication.run(BigDataApplication.class, args);
    }
}

