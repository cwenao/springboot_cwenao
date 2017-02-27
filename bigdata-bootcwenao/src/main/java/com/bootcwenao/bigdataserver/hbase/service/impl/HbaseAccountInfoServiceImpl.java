/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.bigdataserver.hbase.service.impl;

import com.bootcwenao.bigdataserver.hbase.domain.pojo.UserInfo;
import com.bootcwenao.bigdataserver.hbase.mapper.HbaseAccountInfoMapper;
import com.bootcwenao.bigdataserver.hbase.service.HbaseAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cwenao
 * @version $Id HbaseAccountInfoServiceImpl.java, v 0.1 2017-02-21 21:09 cwenao Exp $$
 */
@Service("hbaseAccountInfoServiceImpl")
public class HbaseAccountInfoServiceImpl implements HbaseAccountInfoService {

    @Autowired
    HbaseAccountInfoMapper hbaseAccountInfoMapper;
    @Override
    public UserInfo findUserInfoByEntity(String table, String family, String rowKey, UserInfo userInfo) {
        return hbaseAccountInfoMapper.findUserInfoByEntity(table,family,rowKey,userInfo);
    }

    @Override
    public List<UserInfo> findAll(String tablename,String family) {
        return hbaseAccountInfoMapper.findAll(tablename,family);
    }
}

