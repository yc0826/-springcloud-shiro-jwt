package com.haochen.provider.auth.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author YangChao
 */
public class InterUserDto implements Serializable{
    private static final long serialVersionUID = 4639745074958054960L;

    private String interUserCode;

    private String name;

    private String userName;

    private String mobile;

    private String sex;

    private Boolean appAcesFlg;

    private String subsyNames;

    private Date updTime;

    private Date crtTime;

    private String timeStr;

    private Integer gderFlg;

    private String subsyCode;

    public String getInterUserCode() {
        return interUserCode;
    }

    public void setInterUserCode(String interUserCode) {
        this.interUserCode = interUserCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Boolean getAppAcesFlg() {
        return appAcesFlg;
    }

    public void setAppAcesFlg(Boolean appAcesFlg) {
        this.appAcesFlg = appAcesFlg;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getSubsyNames() {
        return subsyNames;
    }

    public void setSubsyNames(String subsyNames) {
        this.subsyNames = subsyNames;
    }

    public Integer getGderFlg() {
        return gderFlg;
    }

    public void setGderFlg(Integer gderFlg) {
        this.gderFlg = gderFlg;
    }

    public String getSubsyCode() {
        return subsyCode;
    }

    public void setSubsyCode(String subsyCode) {
        this.subsyCode = subsyCode;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }
}
