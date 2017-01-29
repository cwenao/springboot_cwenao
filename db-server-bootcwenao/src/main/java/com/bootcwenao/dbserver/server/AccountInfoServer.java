/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.dbserver.server;

import com.bootcwenao.dbserver.pojo.AccountInfo;

import java.util.List;

/**
 * @author cwenao
 * @version $Id AccountInfoServer.java, v 0.1 2017-01-25 17:44 cwenao Exp $$
 */
public interface AccountInfoServer {
    List<AccountInfo> selectByName(String accountName);
}