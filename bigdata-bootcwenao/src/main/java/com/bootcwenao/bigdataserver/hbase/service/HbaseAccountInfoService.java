/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.bigdataserver.hbase.service;

import com.bootcwenao.bigdataserver.hbase.domain.pojo.UserInfo;

import java.util.List;

/**
 * @author cwenao
 * @version $Id HbaseAccountInfoService.java, v 0.1 2017-02-17 11:52 cwenao Exp $$
 */
public interface HbaseAccountInfoService {

    UserInfo findUserInfoByEntity(String table, String family, String rowKey, UserInfo userInfo);

    List<UserInfo> findAll(String tablename,String family);

}