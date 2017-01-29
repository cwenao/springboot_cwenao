/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.feignserver.servers.impl;

import com.bootcwenao.feignserver.servers.FeignServer;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author cwenao
 * @version $Id FeignServerFactoryImpl.java, v 0.1 2017-01-17 10:40 cwenao Exp $$
 */
@Component
public class FeignServerFactoryImpl implements FallbackFactory<FeignServer> {
    /**
     * Returns an instance of the fallback appropriate for the given cause
     *
     * @param cause corresponds to {@link AbstractCommand#getFailedExecutionException()}
     *              often, but not always an instance of {@link FeignException}.
     */
    public FeignServer create(Throwable cause) {

        return new FeignServer() {
            public String testRealRibbon(String content) {
                return content + ", it's fallback Factory with feign";
            }
        };
    }
}

