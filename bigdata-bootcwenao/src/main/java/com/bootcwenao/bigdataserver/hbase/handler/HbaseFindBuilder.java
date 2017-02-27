/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.bigdataserver.hbase.handler;

import com.bootcwenao.bigdataserver.utils.HumpNameOrMethodUtils;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 按qualifier返回结果
 * @author cwenao
 * @version $Id HbaseFindBuilder.java, v 0.1 2017-02-20 16:05 cwenao Exp $$
 */
public class HbaseFindBuilder<T> {

    private String family;

    private Result result;

    private String qualifier;

    private Map<String, PropertyDescriptor> fieldsMap;

    private Set<String> propertiesSet;

    private Set<String> qualifierSet;

    private BeanWrapper beanWrapper;

    private T tBean;

    /**
     * 按family查询
     * @param family
     * @param result
     * @param tclazz
     */
    public HbaseFindBuilder(String family, Result result, Class<T> tclazz) {

        this.family = family;
        this.result = result;
        fieldsMap = new HashMap();
        propertiesSet = new HashSet<>();

        reflectBean(tclazz);

    }

    /**
     * return the result by qulifier
     * @param qualifier
     * @return
     */
    public HbaseFindBuilder build(String qualifier) {

        return this.build(qualifier,"");
    }

    /**
     * by multiple qualifier
     * @param qualifiers
     * @return
     */
    public HbaseFindBuilder build(String... qualifiers) {

        if (qualifiers == null || qualifiers.length == 0) {
            return this;
        }
        PropertyDescriptor p = null;
        byte[] qualifierByte = null;

        for (String qualifier : qualifiers) {
            if (StringUtils.isEmpty(qualifier)) {
                continue;
            }
            p = fieldsMap.get(qualifier.trim());
            qualifierByte = result.getValue(family.getBytes(), HumpNameOrMethodUtils.humpEntityForVar(qualifier).getBytes());
            if (qualifierByte != null && qualifierByte.length > 0) {
                beanWrapper.setPropertyValue(p.getName(),Bytes.toString(qualifierByte));
                propertiesSet.add(p.getName());
            }
        }

        return this;
    }

    /**
     * by map
     * @param map
     * @return
     */
    public HbaseFindBuilder build(Map<String,String> map) {

        if (map == null || map.size() <= 0) {
            return this;
        }

        PropertyDescriptor p = null;
        byte[] qualifierByte = null;

        for (String value : map.values()) {
            if (StringUtils.isEmpty(value)) {
                continue;
            }

            p = fieldsMap.get(value.trim());
            qualifierByte = result.getValue(family.getBytes(), HumpNameOrMethodUtils.humpEntityForVar(value).getBytes());

            if (qualifierByte != null && qualifierByte.length > 0) {
                beanWrapper.setPropertyValue(p.getName(), Bytes.toString(qualifierByte));
                propertiesSet.add(p.getName());
            }
        }

        return this;
    }

    private void reflectBean(Class<T> tclazz) {

        tBean = BeanUtils.instantiate(tclazz);

        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(tclazz);

        for (PropertyDescriptor p : propertyDescriptors) {
            if (p.getWriteMethod() != null) {
                this.fieldsMap.put(p.getName(), p);
            }
        }

        beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(tBean);
    }

    public T fetch() {
        if (!CollectionUtils.isEmpty(propertiesSet)) {
            return this.tBean;
        }
        return null;
    }

}

