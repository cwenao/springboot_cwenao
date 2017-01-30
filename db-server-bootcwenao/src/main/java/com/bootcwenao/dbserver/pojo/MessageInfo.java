/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.dbserver.pojo;

import org.springframework.data.annotation.Id;

/**
 * @author cwenao
 * @version $Id MessageInfo.java, v 0.1 2017-01-30 12:29 cwenao Exp $$
 */
public class MessageInfo {

    @Id
    private String id;

    private String title;

    private String msgType;

    private String msgInfo;

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
     * Getter method for property <tt>title</tt>.
     *
     * @return property value of title
     */

    public String getTitle() {
        return title;
    }

    /**
     * Setter method for property <tt>title</tt>.
     *
     * @param title value to be assigned to property title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter method for property <tt>msgType</tt>.
     *
     * @return property value of msgType
     */

    public String getMsgType() {
        return msgType;
    }

    /**
     * Setter method for property <tt>msgType</tt>.
     *
     * @param msgType value to be assigned to property msgType
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * Getter method for property <tt>msgInfo</tt>.
     *
     * @return property value of msgInfo
     */

    public String getMsgInfo() {
        return msgInfo;
    }

    /**
     * Setter method for property <tt>msgInfo</tt>.
     *
     * @param msgInfo value to be assigned to property msgInfo
     */
    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    @Override
    public String toString() {
        return "[ id ="+id+", title ="+title+", msgInfo="+msgInfo+" ]";
    }
}

