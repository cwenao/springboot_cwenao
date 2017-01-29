/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.feignserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author cwenao
 * @version $Id FeignServerApplication.java, v 0.1 2017-01-15 13:32 cwenao Exp $$
 */
@SpringBootApplication(scanBasePackages={"com.bootcwenao.feignserver"})
@EnableDiscoveryClient
@EnableFeignClients
public class FeignServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FeignServerApplication.class).web(true).run(args);
    }
}

