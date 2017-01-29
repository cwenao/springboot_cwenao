/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.hystrixdashboard;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cwenao
 * @version $Id HystrixdashboardApplication.java, v 0.1 2017-01-13 13:32 cwenao Exp $$
 */
@SpringBootApplication
@EnableEurekaClient
@Controller
public class HystrixdashboardApplication {
    @RequestMapping("/")
    public String hystrixDashboard() {
        return "forward:/hystrix";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixdashboardApplication.class).web(true).run(args);
    }
}

