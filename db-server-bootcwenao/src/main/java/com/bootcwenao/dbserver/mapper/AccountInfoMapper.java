package com.bootcwenao.dbserver.mapper;


import com.bootcwenao.dbserver.pojo.AccountInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("accountInfoMapper")
public interface AccountInfoMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @author: lying
     * @time: 2016-10-31 10:10:15
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @author: lying
     * @time: 2016-10-31 10:10:15
     */
    int insert(AccountInfo record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @author: lying
     * @time: 2016-10-31 10:10:15
     */
    int insertSelective(AccountInfo record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @author: lying
     * @time: 2016-10-31 10:10:15
     */
    AccountInfo selectByPrimaryKey(String id);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @author: lying
     * @time: 2016-10-31 10:10:15
     */
    int updateByPrimaryKeySelective(AccountInfo record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @author: lying
     * @time: 2016-10-31 10:10:15
     */
    int updateByPrimaryKey(AccountInfo record);

    List<AccountInfo> selectByName(String accountName);
}