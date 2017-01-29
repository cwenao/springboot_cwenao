/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.ribbonserver.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @author cwenao
 * @version $Id RibbonController.java, v 0.1 2017-01-15 10:46 cwenao Exp $$
 */
@Controller
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;

    private final static String serverURI = "http://ribbonserver/";
    @RequestMapping("/test")
    @HystrixCommand(fallbackMethod = "testError")
    public String testRibbon(String content, ModelMap modelMap) {

        System.out.println(content);
        String resultStr = restTemplate.getForEntity(serverURI+"testRealRibbon?content="+content,String.class).getBody();

        modelMap.addAttribute("result",resultStr);

        return "index";
    }

    public String testError() {
        return "404";
    }
}

