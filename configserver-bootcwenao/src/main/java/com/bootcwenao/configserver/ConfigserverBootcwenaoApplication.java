/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.configserver;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author cwenao
 * @version $Id ConfigserverBootcwenaoApplication.java, v 0.1 2017-01-12 14:21 cwenao Exp $$
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigServer
public class ConfigserverBootcwenaoApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigserverBootcwenaoApplication.class).web(true).run(args);
    }

}

