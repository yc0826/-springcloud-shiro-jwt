package com.haochen.consumer.auth.entity;

import com.haochen.common.entity.BaseEntity;


/**
 * db_table: mst_inter_user_roll
 * @author YangChao
 */
public class MstInterUserRollEntity extends BaseEntity {
    private static final long serialVersionUID = 8493003706464602345L;

    //columns START
    /**
     * 业务基础内部用户角色id		db_column: mst_inter_user_roll_id
     */
    private Integer mstInterUserRollId;
    /**
     * 内部用户code		db_column: inter_user_code
     */
    private String interUserCode;
    /**
     * 会所code		db_column: subsy_code
     */
    private String subsyCode;

    private String subsyCodes;

    private String subsyCodeNames;
    /**
     * 角色code		db_column: roll_code
     */
    private String rollCodes;

    private String userName;

    private String rollNames;
    //columns END


    //get set START

    /**
     * 业务基础内部用户角色id		db_column: mst_inter_user_roll_id
     */
    public void setMstInterUserRollId(Integer mstInterUserRollId) {
        this.mstInterUserRollId = mstInterUserRollId;
    }

    /**
     * 业务基础内部用户角色id		db_column: mst_inter_user_roll_id
     */
    public Integer getMstInterUserRollId() {
        return this.mstInterUserRollId;
    }

    /**
     * 内部用户code		db_column: inter_user_code
     */
    public void setInterUserCode(String interUserCode) {
        this.interUserCode = interUserCode;
    }

    /**
     * 内部用户code		db_column: inter_user_code
     */
    public String getInterUserCode() {
        return this.interUserCode;
    }

    public String getSubsyCode() {
        return subsyCode;
    }

    public void setSubsyCode(String subsyCode) {
        this.subsyCode = subsyCode;
    }

    public String getRollCodes() {
        return rollCodes;
    }

    public void setRollCodes(String rollCodes) {
        this.rollCodes = rollCodes;
    }

    public String getRollNames() {
        return rollNames;
    }

    public void setRollNames(String rollNames) {
        this.rollNames = rollNames;
    }

    public String getSubsyCodes() {
        return subsyCodes;
    }

    public void setSubsyCodes(String subsyCodes) {
        this.subsyCodes = subsyCodes;
    }

    public String getSubsyCodeNames() {
        return subsyCodeNames;
    }

    public void setSubsyCodeNames(String subsyCodeNames) {
        this.subsyCodeNames = subsyCodeNames;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    //get set End


}


