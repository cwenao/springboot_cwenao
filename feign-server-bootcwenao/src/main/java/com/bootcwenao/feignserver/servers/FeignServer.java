/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.feignserver.servers;

import com.bootcwenao.feignserver.servers.impl.FeignServerFactoryImpl;
import com.bootcwenao.feignserver.servers.impl.FeignServerImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cwenao
 * @version $Id FeignServer.java, v 0.1 2017-01-15 13:51 cwenao Exp $$
 */
@FeignClient(value = "ribbonserver" , fallbackFactory = FeignServerFactoryImpl.class )
public interface FeignServer {

    @RequestMapping(value ="/testRealRibbon",method= RequestMethod.GET)
    String testRealRibbon(@RequestParam("content") String content);

}