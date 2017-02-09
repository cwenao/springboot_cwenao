/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.esserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author cwenao
 * @version $Id EsServerApplication.java, v 0.1 2017-02-04 16:29 cwenao Exp $$
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ESServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ESServerApplication.class, args);
    }

}

