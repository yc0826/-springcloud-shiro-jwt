package com.haochen.provider.auth.entity;

import com.haochen.common.entity.BaseEntity;


/**
 * db_table: cfg_sys_reso
 * @author YangChao
 */
public class CfgSysResoEntity extends BaseEntity {
	
	//columns START
	/** 
	 * 系统基础系统资源id		db_column: cfg_sys_reso_id */
	private Integer cfgSysResoId;
	/** 
	 * 资源code		db_column: reso_code */
	private String resoCode;
	/** 
	 * 资源名称		db_column: reso_name */
	private String resoName;
	/** 
	 * path		db_column: path */
	private String path;
	/** 
	 * 父资源code		db_column: parent_reso_code */
	private String parentResoCode;
	/** 
	 * 权限字符串		db_column: permission */
	private String permission;
	/** 
	 * 路径		db_column: component_path */
	private String componentPath;
	/** 
	 * 资源类型code:{cfg_gen：类型0004}		db_column: reso_type_code */
	private String resoTypeCode;
	/** 
	 * 资源平台code:{cfg_gen：类型0005}		db_column: reso_plat_code */
	private String resoPlatCode;
	/** 
	 * 快捷方式模块名		db_column: sc_type_code */
	private String scTypeCode;
	//columns END

	
	
	//get set START
	/** 系统基础系统资源id		db_column: cfg_sys_reso_id */
	public void setCfgSysResoId(Integer cfgSysResoId) {
		this.cfgSysResoId = cfgSysResoId;
	}
	/** 系统基础系统资源id		db_column: cfg_sys_reso_id */
	public Integer getCfgSysResoId() {
		return this.cfgSysResoId;
	}
	/** 资源code		db_column: reso_code */
	public void setResoCode(String resoCode) {
		this.resoCode = resoCode;
	}
	/** 资源code		db_column: reso_code */
	public String getResoCode() {
		return this.resoCode;
	}
	/** 资源名称		db_column: reso_name */
	public void setResoName(String resoName) {
		this.resoName = resoName;
	}
	/** 资源名称		db_column: reso_name */
	public String getResoName() {
		return this.resoName;
	}
	/** path		db_column: path */
	public void setPath(String path) {
		this.path = path;
	}
	/** path		db_column: path */
	public String getPath() {
		return this.path;
	}
	/** 父资源code		db_column: parent_reso_code */
	public void setParentResoCode(String parentResoCode) {
		this.parentResoCode = parentResoCode;
	}
	/** 父资源code		db_column: parent_reso_code */
	public String getParentResoCode() {
		return this.parentResoCode;
	}
	/** 权限字符串		db_column: permission */
	public void setPermission(String permission) {
		this.permission = permission;
	}
	/** 权限字符串		db_column: permission */
	public String getPermission() {
		return this.permission;
	}
	/** 路径		db_column: component_path */
	public void setComponentPath(String componentPath) {
		this.componentPath = componentPath;
	}
	/** 路径		db_column: component_path */
	public String getComponentPath() {
		return this.componentPath;
	}
	/** 资源类型code:{cfg_gen：类型0004}		db_column: reso_type_code */
	public void setResoTypeCode(String resoTypeCode) {
		this.resoTypeCode = resoTypeCode;
	}
	/** 资源类型code:{cfg_gen：类型0004}		db_column: reso_type_code */
	public String getResoTypeCode() {
		return this.resoTypeCode;
	}
	/** 资源平台code:{cfg_gen：类型0005}		db_column: reso_plat_code */
	public void setResoPlatCode(String resoPlatCode) {
		this.resoPlatCode = resoPlatCode;
	}
	/** 资源平台code:{cfg_gen：类型0005}		db_column: reso_plat_code */
	public String getResoPlatCode() {
		return this.resoPlatCode;
	}
	/** 快捷方式模块名		db_column: sc_type_code */
	public void setScTypeCode(String scTypeCode) {
		this.scTypeCode = scTypeCode;
	}
	/** 快捷方式模块名		db_column: sc_type_code */
	public String getScTypeCode() {
		return this.scTypeCode;
	}
	//get set End

    @Override
    public String toString() {
    return "CfgSysResoEntity ["
    + "CfgSysResoId=" + getCfgSysResoId() + ", " 
        + "ResoCode=" + getResoCode() + ", " 
        + "ResoName=" + getResoName() + ", " 
        + "Path=" + getPath() + ", " 
        + "ParentResoCode=" + getParentResoCode() + ", " 
        + "Permission=" + getPermission() + ", " 
        + "ComponentPath=" + getComponentPath() + ", " 
        + "ResoTypeCode=" + getResoTypeCode() + ", " 
        + "ResoPlatCode=" + getResoPlatCode() + ", " 
        + "ScTypeCode=" + getScTypeCode() + ", " 
        + "CrtTime=" + getCrtTime() + ", " 
        + "CrtUserCode=" + getCrtUserCode() + ", " 
        + "UpdTime=" + getUpdTime() + ", " 
        + "UpdUserCode=" + getUpdUserCode() + ", " 
        + "DelFlg=" + getDelFlg() + ", " 
        + "VerNum=" + getVerNum()
     + "]";
    }
	
}


