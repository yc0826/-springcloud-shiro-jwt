package com.haochen.provider.auth.entity;

import com.haochen.common.entity.BaseEntity;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;


/**
 * db_table: mst_roll_base
 * @author YangChao
 */
public class MstRollBaseEntity extends BaseEntity {
    private static final long serialVersionUID = -3470424544106972195L;

    //columns START
    /**
     * 业务基础角色基本id		db_column: mst_roll_base_id
     */
    private Integer mstRollBaseId;
    /**
     * 角色code		db_column: roll_code
     */
    private String rollCode;
    /**
     * 角色名称		db_column: roll_name
     */
    private String rollName;
    /**
     * 角色描述		db_column: roll_desc
     */
    private String rollDesc;
    /**
     * 角色权限		db_column: roll_permis
     */
    private String rollPermis;
    //columns END

    private String resoCodes;

    private Set<String> resoCodeList;

    private Set<CfgSysResoEntity> cfgSysResoEntitySet;

    private String resoNames;

    //get set START

    /**
     * 业务基础角色基本id		db_column: mst_roll_base_id
     */
    public void setMstRollBaseId(Integer mstRollBaseId) {
        this.mstRollBaseId = mstRollBaseId;
    }

    /**
     * 业务基础角色基本id		db_column: mst_roll_base_id
     */
    public Integer getMstRollBaseId() {
        return this.mstRollBaseId;
    }

    /**
     * 角色code		db_column: roll_code
     */
    public void setRollCode(String rollCode) {
        this.rollCode = rollCode;
    }

    /**
     * 角色code		db_column: roll_code
     */
    public String getRollCode() {
        return this.rollCode;
    }

    /**
     * 角色名称		db_column: roll_name
     */
    public void setRollName(String rollName) {
        this.rollName = rollName;
    }

    /**
     * 角色名称		db_column: roll_name
     */
    public String getRollName() {
        return this.rollName;
    }

    /**
     * 角色描述		db_column: roll_desc
     */
    public void setRollDesc(String rollDesc) {
        this.rollDesc = rollDesc;
    }

    /**
     * 角色描述		db_column: roll_desc
     */
    public String getRollDesc() {
        return this.rollDesc;
    }

    /**
     * 角色权限		db_column: roll_permis
     */
    public void setRollPermis(String rollPermis) {
        this.rollPermis = rollPermis;
    }

    /**
     * 角色权限		db_column: roll_permis
     */
    public String getRollPermis() {
        return this.rollPermis;
    }
    //get set End

    @Override
    public String toString() {
        return "MstRollBaseEntity [" +
                "MstRollBaseId=" + getMstRollBaseId() + ", " +
                "RollCode=" + getRollCode() + ", " +
                "RollName=" + getRollName() + ", " +
                "RollDesc=" + getRollDesc() + ", " +
                "RollPermis=" + getRollPermis() + ", " +
                "CrtTime=" + getCrtTime() + ", " +
                "CrtUserCode=" + getCrtUserCode() + ", " +
                "UpdTime=" + getUpdTime() + ", " +
                "UpdUserCode=" + getUpdUserCode() + ", " +
                "DelFlg=" + getDelFlg() + ", " +
                "VerNum=" + getVerNum() +
                "]";
    }

    public String getResoCodes() {
        return resoCodes;
    }

    public void setResoCodes(String resoCodes) {
        this.resoCodes = resoCodes;
    }

    public Set<String> getResoCodeList() {
        resoCodeList = new HashSet<>();
        if (resoCodes != null) {
            String[] strings = resoCodes.split(",");
            for (String str : strings) {
                if (!"".equals(str)) {
                    resoCodeList.add(str);
                }
            }
        }
        return resoCodeList;
    }


    public void setCfgSysResoEntitySet(Set<CfgSysResoEntity> cfgSysResoEntitySet) {
        this.cfgSysResoEntitySet = cfgSysResoEntitySet;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (CfgSysResoEntity cfgSysResoEntity : cfgSysResoEntitySet) {
            i++;
            if (i < cfgSysResoEntitySet.size()) {
                sb.append(cfgSysResoEntity.getResoCode()).append(",");
            } else {
                sb.append(cfgSysResoEntity.getResoCode());
            }
        }
        setResoCodes(sb.toString());
    }

    public String getResoNames() {
        if (!CollectionUtils.isEmpty(cfgSysResoEntitySet)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (CfgSysResoEntity cfgSysResoEntity : cfgSysResoEntitySet) {
                i++;
                if (i == cfgSysResoEntitySet.size()) {
                    sb.append(cfgSysResoEntity.getResoName());
                } else {
                    sb.append(cfgSysResoEntity.getResoName()).append(",");
                }


            }
            return sb.toString();
        }
        return resoNames;
    }

    public void setResoNames(String resoNames) {
        this.resoNames = resoNames;
    }
}


