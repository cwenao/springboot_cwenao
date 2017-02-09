/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.esserver.service;

import com.bootcwenao.esserver.pojo.AccountInfo;

/**
 * @author cwenao
 * @version $Id ESAccountInfoService.java, v 0.1 2017-02-06 10:36 cwenao Exp $$
 */
public interface ESAccountInfoService {

    AccountInfo queryAccountInfoById(String id);

    AccountInfo queryAccountInfoByName(String accountName);
}