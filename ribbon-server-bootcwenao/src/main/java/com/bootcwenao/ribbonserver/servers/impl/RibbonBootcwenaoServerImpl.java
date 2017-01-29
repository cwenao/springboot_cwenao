/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.ribbonserver.servers.impl;

import com.bootcwenao.ribbonserver.servers.RibbonBootcwenaoServer;
import org.springframework.stereotype.Service;

/**
 * @author cwenao
 * @version $Id RibbonBootcwenaoServerImpl.java, v 0.1 2017-01-15 10:42 cwenao Exp $$
 */

@Service("ribbonBootcwenaoServerImpl")
public class RibbonBootcwenaoServerImpl implements RibbonBootcwenaoServer{
    public String testRibbon(String content) {
        return content + " for Spring Boot";
    }
}

