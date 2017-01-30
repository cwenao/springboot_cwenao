/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.dbserver.server;

import com.bootcwenao.dbserver.pojo.MessageInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author cwenao
 * @version $Id MsgInfoRepository.java, v 0.1 2017-01-30 12:33 cwenao Exp $$
 */
public interface MsgInfoRepository extends MongoRepository<MessageInfo,String> {

    MessageInfo queryMsgInfoByTitle(String title);
}