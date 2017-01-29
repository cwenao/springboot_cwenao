/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.feignserver.controller;

import com.bootcwenao.feignserver.servers.FeignServer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cwenao
 * @version $Id FeignController.java, v 0.1 2017-01-15 13:50 cwenao Exp $$
 */
@Controller
public class FeignController {
    @Autowired
    FeignServer feignServer;

    @Autowired
    KafkaTemplate kafkaTemplate;

    @ApiOperation(value = "/testFeign",notes = "测试Feign",httpMethod = "GET")
    @ApiParam(name = "content",value = "参数：content")
    @RequestMapping("/testFeign")
    @ResponseBody
    public void testFeign(String content) {
        String ribbonStr = feignServer.testRealRibbon(content);
        System.out.println(ribbonStr);
    }

    @RequestMapping("/testKafka")
    @ResponseBody
    public void testkafka(String message) {
        System.out.println(message);
        kafkaTemplate.send("bootcwenaoTopic", "bootcwnao", message);
    }

}