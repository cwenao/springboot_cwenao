/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.bigdataserver.hbase.controller;

import com.bootcwenao.bigdataserver.hbase.domain.pojo.UserInfo;
import com.bootcwenao.bigdataserver.hbase.service.HbaseAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author cwenao
 * @version $Id HbaseAccountController.java, v 0.1 2017-02-21 22:20 cwenao Exp $$
 */
@Controller
public class HbaseAccountController {

    private final static String TABLE_NAME = "user";

    private final static String FAMILY_INFO = "info";

    @Autowired
    private HbaseAccountInfoService hbaseAccountInfoServiceImpl;
    @RequestMapping(value = "/bigdata/find")
    public String findUserInfoByName(String name, ModelMap modelMap) {
        UserInfo userInfo = hbaseAccountInfoServiceImpl.findUserInfoByEntity(TABLE_NAME, FAMILY_INFO,
                "1", new UserInfo());

        modelMap.addAttribute("userInfo", userInfo);

        return "hbase/hbasetest";

        /*List<UserInfo> list = hbaseAccountInfoServiceImpl.findAll(TABLE_NAME, FAMILY_INFO);*/

    }
}

