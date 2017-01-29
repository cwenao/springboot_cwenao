/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.discovery;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author cwenao
 * @version $Id DiscoveryBootcwenaoApplication.java, v 0.1 2017-01-12 9:56 cwenao Exp $$
 */
@EnableEurekaServer
@SpringBootApplication
public class DiscoveryBootcwenaoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DiscoveryBootcwenaoApplication.class).web(true).run(args);
    }
}

