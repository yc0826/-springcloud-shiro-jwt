package com.haochen.provider.auth.dto;

import java.io.Serializable;

/**
 * @author YangChao
 */
public class SubsyComboDto implements Serializable {

    private static final long serialVersionUID = -1532658466719029488L;
    private String subsyCode;

    private String subsyName;

    private String subsyType;

    private String auditStatusCode;

    private String subsyActivFlg;

    private String subsyOpenFlg;

    public String getSubsyCode() {
        return subsyCode;
    }

    public void setSubsyCode(String subsyCode) {
        this.subsyCode = subsyCode;
    }

    public String getSubsyName() {
        return subsyName;
    }

    public void setSubsyName(String subsyName) {
        this.subsyName = subsyName;
    }

    public String getSubsyType() {
        return subsyType;
    }

    public void setSubsyType(String subsyType) {
        this.subsyType = subsyType;
    }

    public String getAuditStatusCode() {
        return auditStatusCode;
    }

    public void setAuditStatusCode(String auditStatusCode) {
        this.auditStatusCode = auditStatusCode;
    }

    public String getSubsyActivFlg() {
        return subsyActivFlg;
    }

    public void setSubsyActivFlg(String subsyActivFlg) {
        this.subsyActivFlg = subsyActivFlg;
    }

    public String getSubsyOpenFlg() {
        return subsyOpenFlg;
    }

    public void setSubsyOpenFlg(String subsyOpenFlg) {
        this.subsyOpenFlg = subsyOpenFlg;
    }
}
