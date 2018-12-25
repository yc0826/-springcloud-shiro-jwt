package com.haochen.provider.auth.entity;


import com.haochen.common.entity.BaseEntity;

import java.util.List;


/**
 * db_table: cfg_sys_reso
 * @author YangChao
 */
public class CfgSysResoEntity extends BaseEntity {
	private static final long serialVersionUID = 1277159171914781743L;

	//columns START
	/** 
	 * 系统基础系统资源id		db_column: cfg_sys_reso_id */
	private Integer cfgSysResoId;
	/** 
	 * 资源code		db_column: reso_code */
	private String resoCode;
	/** 
	 * parentResoCode		db_column: parent_reso_code */
	private String parentResoCode;
	/** 
	 * parentResoCodes		db_column: parent_reso_codes */
	private String parentResoCodes;
	/** 
	 * url		db_column: url */
	private String url;
	/** 
	 * 资源名称		db_column: reso_name */
	private String resoName;
	/** 
	 * 资源类型code:{cfg_gen：类型0004}		db_column: reso_type_code */
	private String resoTypeCode;
	/** 
	 * permission		db_column: permission */
	private String permission;
	/** 
	 * 资源平台code:{cfg_gen：类型0005}		db_column: reso_plat_code */
	private String resoPlatCode;
	/** 
	 * 快捷方式模块名		db_column: sc_type_code */
	private String scTypeCode;

	private List<CfgSysResoEntity> children;


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
	/** parentResoCode		db_column: parent_reso_code */
	public void setParentResoCode(String parentResoCode) {
		this.parentResoCode = parentResoCode;
	}
	/** parentResoCode		db_column: parent_reso_code */
	public String getParentResoCode() {
		return this.parentResoCode;
	}
	/** parentResoCodes		db_column: parent_reso_codes */
	public void setParentResoCodes(String parentResoCodes) {
		this.parentResoCodes = parentResoCodes;
	}
	/** parentResoCodes		db_column: parent_reso_codes */
	public String getParentResoCodes() {
		return this.parentResoCodes;
	}
	/** url		db_column: url */
	public void setUrl(String url) {
		this.url = url;
	}
	/** url		db_column: url */
	public String getUrl() {
		return this.url;
	}
	/** 资源名称		db_column: reso_name */
	public void setResoName(String resoName) {
		this.resoName = resoName;
	}
	/** 资源名称		db_column: reso_name */
	public String getResoName() {
		return this.resoName;
	}
	/** 资源类型code:{cfg_gen：类型0004}		db_column: reso_type_code */
	public void setResoTypeCode(String resoTypeCode) {
		this.resoTypeCode = resoTypeCode;
	}
	/** 资源类型code:{cfg_gen：类型0004}		db_column: reso_type_code */
	public String getResoTypeCode() {
		return this.resoTypeCode;
	}
	/** permission		db_column: permission */
	public void setPermission(String permission) {
		this.permission = permission;
	}
	/** permission		db_column: permission */
	public String getPermission() {
		return this.permission;
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

	public String makeSelfAsParentCodes() {
		return getParentResoCodes() + getResoCode() + "/";
	}


	public boolean isRootNode() {
		return "0".equals(parentResoCode);
	}
	//get set End

	@Override
	public String toString() {
		return "CfgSysResoEntity [" +
				"CfgSysResoId=" + getCfgSysResoId() + ", " +
				"ResoCode=" + getResoCode() + ", " +
				"ParentResoCode=" + getParentResoCode() + ", " +
				"ParentResoCodes=" + getParentResoCodes() + ", " +
				"Url=" + getUrl() + ", " +
				"ResoName=" + getResoName() + ", " +
				"ResoTypeCode=" + getResoTypeCode() + ", " +
				"Permission=" + getPermission() + ", " +
				"ResoPlatCode=" + getResoPlatCode() + ", " +
				"ScTypeCode=" + getScTypeCode() + ", " +
				"CrtTime=" + getCrtTime() + ", " +
				"CrtUserCode=" + getCrtUserCode() + ", " +
				"UpdTime=" + getUpdTime() + ", " +
				"UpdUserCode=" + getUpdUserCode() + ", " +
				"DelFlg=" + getDelFlg() + ", " +
				"VerNum=" + getVerNum() +
				"]";
	}

	public List<CfgSysResoEntity> getChildren() {
		return children;
	}

	public void setChildren(List<CfgSysResoEntity> children) {
		this.children = children;
	}


}


