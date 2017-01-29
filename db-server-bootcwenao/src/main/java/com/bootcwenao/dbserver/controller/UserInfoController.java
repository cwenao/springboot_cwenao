/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.dbserver.controller;

import com.bootcwenao.dbserver.handler.validator.AbstractCacheSupport;
import com.bootcwenao.dbserver.pojo.AccountInfo;
import com.bootcwenao.dbserver.server.AccountInfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author cwenao
 * @version $Id UserInfoController.java, v 0.1 2017-01-25 18:35 cwenao Exp $$
 */
@Controller
public class UserInfoController extends AbstractCacheSupport {

    @Autowired
    AccountInfoServer accountInfoServerImpl;

    @Autowired
    CacheManager cacheManager;

    private final static String TEST_REDIS = "test_redis";

    @RequestMapping("/accountInfo")
    public String accountInfo(String name, ModelMap modelMap) {
        Cache cache = cacheManager.getCache(TEST_REDIS);
        putCache(cache,"test_aa","111111");
        List<AccountInfo> accountInfoList = accountInfoServerImpl.selectByName(name);
        modelMap.addAttribute("accountList", accountInfoList);
        System.out.println(getFromCache(cache,"test_aa"));
        return "userinfo/accountInfo";

    }

}

