/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.esserver.service.impl;


import com.bootcwenao.esserver.mapper.ElasticAccountInfoRepository;
import com.bootcwenao.esserver.pojo.AccountInfo;
import com.bootcwenao.esserver.service.ESAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cwenao
 * @version $Id ESAccountInfoServiceImpl.java, v 0.1 2017-02-06 10:38 cwenao Exp $$
 */
@Service("esAccountInfoServiceImpl")
public class ESAccountInfoServiceImpl implements ESAccountInfoService {

    @Autowired
    private ElasticAccountInfoRepository elasticAccountInfoRepository;

    public AccountInfo queryAccountInfoById(String id) {
        return elasticAccountInfoRepository.findOne(id);
    }

    @Override
    public AccountInfo queryAccountInfoByName(String accountName) {
        return elasticAccountInfoRepository.findByAccountName(accountName);
    }
}

