package com.haochen.consumer.auth.dto;

import java.io.Serializable;

/**
 * @author YangChao
 */
public class InterUserRollDto implements Serializable{
    private static final long serialVersionUID = 7480570848857295660L;

    private String userCode;

    private String mobile;

    private String name;

    private String subsyName;

    private String rollNames;

    private String rollCodes;

    private String subsyCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getSubsyName() {
        return subsyName;
    }

    public void setSubsyName(String subsyName) {
        this.subsyName = subsyName;
    }

    public String getRollNames() {
        return rollNames;
    }

    public void setRollNames(String rollNames) {
        this.rollNames = rollNames;
    }

    public String getRollCodes() {
        return rollCodes;
    }

    public void setRollCodes(String rollCodes) {
        this.rollCodes = rollCodes;
    }

    public String getSubsyCode() {
        return subsyCode;
    }

    public void setSubsyCode(String subsyCode) {
        this.subsyCode = subsyCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
