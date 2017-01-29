/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.dbserver.server.impl;

import com.bootcwenao.dbserver.mapper.AccountInfoMapper;
import com.bootcwenao.dbserver.pojo.AccountInfo;
import com.bootcwenao.dbserver.server.AccountInfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cwenao
 * @version $Id AccountInfoServerImpl.java, v 0.1 2017-01-25 18:31 cwenao Exp $$
 */
@Service("accountInfoServerImpl")
public class AccountInfoServerImpl implements AccountInfoServer{

    @Autowired
    AccountInfoMapper accountInfoMapper;

    @Override
    public List<AccountInfo> selectByName(String accountName) {
        return accountInfoMapper.selectByName(accountName);
    }

}

