/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.ribbonserver.controller;

import com.bootcwenao.ribbonserver.servers.RibbonBootcwenaoServer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cwenao
 * @version $Id RibbonRealVontroller.java, v 0.1 2017-01-15 11:33 cwenao Exp $$
 */
@RestController
public class RibbonRealVontroller {
    @Autowired
    private RibbonBootcwenaoServer ribbonBootcwenaoServerImpl;

    @RequestMapping("/testRealRibbon")
    public String testRealRibbon(String content) {
        String resultStr = ribbonBootcwenaoServerImpl.testRibbon(content);
        System.out.println(resultStr);
        return resultStr;
    }

}

