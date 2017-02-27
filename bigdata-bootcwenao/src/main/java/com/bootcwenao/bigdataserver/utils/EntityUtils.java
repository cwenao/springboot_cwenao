/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.bigdataserver.utils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cwenao
 * @version $Id EntityUtils.java, v 0.1 2017-02-19 23:42 cwenao Exp $$
 */
public abstract class EntityUtils<T,KEY extends Serializable>{

    /**
     * 删除Map中value为空值
     * @param map
     * @return
     */
    public static Map removeEmptyForValues(Map<String, Object> map) {

        if (map == null) {
            return null;
        }

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() == null || entry.equals("")) {
                map.remove(entry.getKey());
            }
        }

        return map;
    }

    /**
     * 删除map中key和value出现空的时候
     * @param map
     * @return
     */
    public static Map removeEmptyForMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }

        for (Map.Entry<String, Object> entry : map.entrySet()) {

            if (entry.getKey() == null || entry.getKey().equals("")) {
                map.remove(entry.getKey());
                continue;
            }

            if (entry.getValue() == null || entry.equals("")) {
                map.remove(entry.getKey());
            }
        }

        return map;
    }

    /**
     * 将包含family-entity 转换为family-map
     * @param map
     * @return
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static Map transformEntity2Map(Map<String, Object> map) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        if (map == null || map.size() < 1) {
            return null;
        }

        Map<String, Map<String, Object>> entity2Map = new HashMap<>();

        for (Map.Entry<String, Object> entry : map.entrySet()) {

            entity2Map.put(entry.getKey(), transformEntity(entry.getValue()));
        }

        return entity2Map;
    }

    /**
     * 将对象转换为Map
     * @param obj
     * @return
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static Map<String,Object> transformEntity(Object obj) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field[] fields = obj.getClass().getDeclaredFields();
        Map<String, Object> tMap = new HashMap<>();

        for (Field field : fields) {

            field.setAccessible(true);
            String name = field.getName().replaceFirst(field.getName().substring(0, 1),field.getName().substring(0, 1).toUpperCase());

            Method method = obj.getClass().getMethod("get" + name);
            tMap.put(field.getName(), method.invoke(obj));

        }
        return tMap;
    }
}

