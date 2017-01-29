package com.bootcwenao.dbserver.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 自动生成
 */
public class AccountInfo implements Serializable {
    /**
     * account_info.id
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private String id;

    /**
     * account_info.account_name (用户名)
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private String accountName;

    /**
     * account_info.nick_name (昵称)
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private String nickName;

    /**
     * account_info.mail (邮箱)
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private String mail;

    /**
     * account_info.m_tel (移动电话)
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private String mTel;

    /**
     * account_info.land_tel (固定电话)
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private String landTel;

    /**
     * account_info.is_vip
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private Integer isVip;

    /**
     * account_info.password (密码)
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private String password;

    /**
     * account_info.salt(盐值)
     * @author:
     *
     */
    private String salt;

    /**
     * account_info.head_image (头像)
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private String headImage;

    /**
     * account_info.back_image (背景图)
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private String backImage;

    /**
     * account_info.account_type (账户类型：)
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private Integer accountType;

    /**
     * account_info.source (注册来源：0 -- 网站注册； 1 -- 微信；2 -- qq；3--微博)
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private Integer source;

    /**
     * account_info.audit_status
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private Integer auditStatus;

    /**
     * account_info.create_time
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private Date createTime;

    /**
     * account_info.update_time
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private Date updateTime;

    /**
     * account_info.status
     * @author: cwenao
     * @time: 2016-10-31 10:10:15
     */
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getmTel() {
        return mTel;
    }

    public void setmTel(String mTel) {
        this.mTel = mTel;
    }

    public String getLandTel() {
        return landTel;
    }

    public void setLandTel(String landTel) {
        this.landTel = landTel;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for property <tt>salt</tt>.
     *
     * @return property value of salt
     */

    public String getSalt() {
        return salt;
    }

    /**
     * Setter method for property <tt>salt</tt>.
     *
     * @param salt value to be assigned to property salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getBackImage() {
        return backImage;
    }

    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}