/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.bigdataserver.hbase.domain.pojo;

/**
 * @author cwenao
 * @version $Id UserInfo.java, v 0.1 2017-02-21 15:27 cwenao Exp $$
 */
public class UserInfo {

    private String id;

    private String userName;

    private Integer age;


    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */

    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>userName</tt>.
     *
     * @return property value of userName
     */

    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for property <tt>userName</tt>.
     *
     * @param userName value to be assigned to property userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter method for property <tt>age</tt>.
     *
     * @return property value of age
     */

    public Integer getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     *
     * @param age value to be assigned to property age
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}

