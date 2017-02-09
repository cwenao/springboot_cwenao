/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.esserver.controller;

import com.bootcwenao.esserver.pojo.AccountInfo;
import com.bootcwenao.esserver.service.ESAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.channels.FileChannel;

/**
 * @author cwenao
 * @version $Id ESController.java, v 0.1 2017-02-06 10:44 cwenao Exp $$
 */
@Controller
public class ESController {

    @Autowired
    private ESAccountInfoService esAccountInfoServiceImpl;

    @RequestMapping("/esAccountInfo")
    public String queryAccountInfo(String id, ModelMap modelMap){

        AccountInfo accountInfo = esAccountInfoServiceImpl.queryAccountInfoById(id);
        modelMap.addAttribute("esAccountInfo",accountInfo);
        modelMap.addAttribute("test_elastic","Test the elasticsearch");


        return "accountInfo";

    }

    @RequestMapping("/esAccountInfoName")
    public String queryAccountInfoByAccountName(String accountName, ModelMap modelMap){

        AccountInfo accountInfo = esAccountInfoServiceImpl.queryAccountInfoByName(accountName);
        modelMap.addAttribute("esAccountInfo",accountInfo);
        modelMap.addAttribute("test_elastic","Test the elasticsearch");

        return "accountInfo";

    }
}

