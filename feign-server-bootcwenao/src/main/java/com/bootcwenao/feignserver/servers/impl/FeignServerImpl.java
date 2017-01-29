/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.feignserver.servers.impl;

import com.bootcwenao.feignserver.servers.FeignServer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cwenao
 * @version $Id FeignServerImpl.java, v 0.1 2017-01-17 9:24 cwenao Exp $$
 */
@Component
public class FeignServerImpl implements FeignServer {

    public String testRealRibbon(@RequestParam("content") String content) {
        return content + ", it's fallback with feign";
    }
}

