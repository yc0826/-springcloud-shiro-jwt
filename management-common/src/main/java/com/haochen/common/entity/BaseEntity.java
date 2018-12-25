package com.haochen.common.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * @author YangChao
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -4025917028919734919L;
    /**
     * 创建时间		db_column: crt_time */
    private java.util.Date crtTime;
    /**
     * 创建、更新时间戳
     */
    private Long timestamp = null;

    /**
     * 创建用户code		db_column: crt_user_code */
    private String crtUserCode;
    /**
     * 更新时间		db_column: upd_time */
    private java.util.Date updTime;
    /**
     * 更新用户code		db_column: upd_user_code */
    private String updUserCode;
    /**
     * 删除flag:{0:正常   1:已删除}		db_column: del_flg */
    private Boolean delFlg;
    /**
     * 版本号码		db_column: ver_num */
    private Integer verNum;
    /**
     * 更新条件map		 */
    private Map<String, Object> condition;



    public Map<String, Object> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }
    public java.util.Date getCrtTime() {
        return crtTime;
    }
    public void setCrtTime(java.util.Date crtTime) {
        this.crtTime = crtTime;
    }
    public String getCrtUserCode() {
        return crtUserCode;
    }
    public void setCrtUserCode(String crtUserCode) {
        this.crtUserCode = crtUserCode;
    }
    public java.util.Date getUpdTime() {
        return updTime;
    }
    public void setUpdTime(java.util.Date updTime) {
        this.updTime = updTime;
    }
    public String getUpdUserCode() {
        return updUserCode;
    }
    public void setUpdUserCode(String updUserCode) {
        this.updUserCode = updUserCode;
    }
    public Boolean getDelFlg() {
        return delFlg;
    }
    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
    public Integer getVerNum() {
        return verNum;
    }
    public void setVerNum(Integer verNum) {
        this.verNum = verNum;
    }

    public Long getTimestamp() {

        return System.currentTimeMillis();
        //return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }


}
