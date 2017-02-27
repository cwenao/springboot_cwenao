/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.bigdataserver.hbase.mapper.impl;

import com.bootcwenao.bigdataserver.hbase.domain.pojo.UserInfo;
import com.bootcwenao.bigdataserver.hbase.handler.HbaseFindBuilder;
import com.bootcwenao.bigdataserver.hbase.mapper.HbaseAccountInfoMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cwenao
 * @version $Id HbaseAccountInfoMapperImpl.java, v 0.1 2017-02-21 21:14 cwenao Exp $$
 */
@Repository("hbaseAccountInfoMapperImpl")
public class HbaseAccountInfoMapperImpl implements HbaseAccountInfoMapper {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    public UserInfo findUserInfoByEntity(String table, String family, String rowKey, UserInfo userInfo) {

        return (UserInfo) hbaseTemplate.get(table, rowKey, family,
                (result, rowNum) -> new HbaseFindBuilder<>(family, result, userInfo.getClass()).build("userName","age","id").fetch());
    }

    @Override
    public List<UserInfo> findAll(String tablename, String family) {

        byte[] cf_info = family.getBytes();

        byte[] age_info = Bytes.toBytes("age");
        byte[] id_info = Bytes.toBytes("id");
        byte[] username_info = Bytes.toBytes("userName");

        return hbaseTemplate.find(tablename, family, new RowMapper<UserInfo>() {
            @Override
            public UserInfo mapRow(Result result, int rowNum) throws Exception {

                UserInfo  u = new UserInfo();

                u.setId(Bytes.toString(result.getValue(cf_info,id_info)));
                u.setUserName(Bytes.toString(result.getValue(cf_info,username_info)));
                u.setAge(Bytes.toInt(result.getValue(cf_info,age_info)));

                return u;
            }
        });
    }
}

