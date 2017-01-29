/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.ribbonserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author cwenao
 * @version $Id RibbonServerApplication.java, v 0.1 2017-01-14 16:50 cwenao Exp $$
 */
@SpringBootApplication(scanBasePackages = {"com.bootcwenao.ribbonserver"})
@EnableDiscoveryClient
@EnableCircuitBreaker
public class RibbonServerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate () {

        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
        //TODO there can do some for request

        return restTemplate;

    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(RibbonServerApplication.class).web(true).run(args);
    }
}

