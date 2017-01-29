/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.dbserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author cwenao
 * @version $Id DbServerApplication.java, v 0.1 2017-01-22 16:12 cwenao Exp $$
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DbServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DbServerApplication.class).web(true).run(args);
    }
}

