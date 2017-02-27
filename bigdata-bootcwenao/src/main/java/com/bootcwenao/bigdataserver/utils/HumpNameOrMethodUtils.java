/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.bigdataserver.utils;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Transform the entity attribute hbase column attribute
 * @author cwenao
 * @version $Id HumpNameOrMethodUtils.java, v 0.1 2017-02-20 16:27 cwenao Exp $$
 */
public class HumpNameOrMethodUtils {

    private final static String SEPARATOR_UNDER_SCORE = "_";

    /**
     * 用驼峰命名法 将参数转换为Entity属性
     * @param var
     * @return
     */
    public static String humpVarForEntity(String var) {

        if (StringUtils.isEmpty(var)) {
            return "";
        }

        StringBuffer varBf = new StringBuffer();

        var = var.replaceFirst(var.substring(0,1),var.substring(0,1).toLowerCase(Locale.US));

        if (var.indexOf(SEPARATOR_UNDER_SCORE) > 0) {

            String[] underStr = var.split(SEPARATOR_UNDER_SCORE);

            for(int i =0; i<underStr.length;i++) {

                if (i == 0) {
                    varBf.append(underStr[i]);
                } else {
                    varBf.append(str2LowerCase(underStr[i]));
                }
            }
        }

        return varBf.toString();
    }

    /**
     * 用驼峰命名法 将Entity属性转换为参数
     * @param var
     * @return
     */
    public static String humpEntityForVar(String var) {

        if (StringUtils.isEmpty(var)) {
            return "";
        }

        StringBuffer varBf = new StringBuffer();

        char[] varChar = var.toCharArray();

        int i = 0;
        for(char c : varChar) {

            if (i==0) {
                varBf.append(String.valueOf(c));
            } else {
                if (compareToLowerCase(String.valueOf(c))) {
                    varBf.append("_" + String.valueOf(c).toLowerCase());
                } else {
                    varBf.append(String.valueOf(c));
                }
            }
            i++;
        }

        return varBf.toString();
    }


    /**
     * 将首位字符转换为大写
     * @param str
     * @return
     */
    private static String str2LowerCase(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        return str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
    }

    /**
     * 是否大写字母
     * @param source
     * @return
     */
    private static Boolean compareToLowerCase(String source) {

        if (StringUtils.isEmpty(source)) {
            return false;
        }

        if (!source.equals(source.toLowerCase(Locale.US))) {
            return true;
        }
        return false;
    }
}

