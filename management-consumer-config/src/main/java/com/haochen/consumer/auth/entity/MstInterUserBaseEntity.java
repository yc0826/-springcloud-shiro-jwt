package com.haochen.consumer.auth.entity;

import com.haochen.common.entity.BaseEntity;


/**
 * db_table: mst_inter_user_base
 * @author YangChao
 */
public class MstInterUserBaseEntity extends BaseEntity {
	private static final long serialVersionUID = -1567417215149506522L;

	//columns START
	/** 
	 * 业务基础内部用户基本id		db_column: mst_inter_user_base_id */
	private Integer mstInterUserBaseId;
	/** 
	 * 内部用户code		db_column: inter_user_code */
	private String interUserCode;
	/** 
	 * 用户名称		db_column: user_name */
	private String userName;
	/** 
	 * 盐		db_column: salt */
	private String salt;
	/** 
	 * 用户密码		db_column: user_pwd */
	private String userPwd;
	/** 
	 * 手机号码		db_column: mob_num */
	private String mobNum;
	/** 
	 * 邮件		db_column: eml */
	private String eml;
	/** 
	 * 头像url		db_column: avtr_url */
	private String avtrUrl;
	/** 
	 * 岗位code		db_column: postn_code */
	private String postnCode;
	/** 
	 * web管理系统链接flag:{0：不可链接web管理系统；1：可以链接管理系统}		db_column: web_aces_flg */
	private Boolean webAcesFlg;
	/** 
	 * app链接flag:{0：不可链接app；1：可以链接app}		db_column: app_aces_flg */
	private Boolean appAcesFlg;
	/** 
	 * 用户手机设备号		db_column: device_Id */
	private String deviceId;

	private String subsyCodes;

	private String subsyNames;

	private String avtrImgCode;

	private MstInterUserDtlEntity mstInterUserDtlEntity;

	private Boolean authorizedFlg;

	//columns END

	
	
	//get set START
	/** 业务基础内部用户基本id		db_column: mst_inter_user_base_id */
	public void setMstInterUserBaseId(Integer mstInterUserBaseId) {
		this.mstInterUserBaseId = mstInterUserBaseId;
	}
	/** 业务基础内部用户基本id		db_column: mst_inter_user_base_id */
	public Integer getMstInterUserBaseId() {
		return this.mstInterUserBaseId;
	}
	/** 内部用户code		db_column: inter_user_code */
	public void setInterUserCode(String interUserCode) {
		this.interUserCode = interUserCode;
	}
	/** 内部用户code		db_column: inter_user_code */
	public String getInterUserCode() {
		return this.interUserCode;
	}
	/** 用户名称		db_column: user_name */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/** 用户名称		db_column: user_name */
	public String getUserName() {
		return this.userName;
	}
	/** 盐		db_column: salt */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/** 盐		db_column: salt */
	public String getSalt() {
		return this.salt;
	}
	/** 用户密码		db_column: user_pwd */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	/** 用户密码		db_column: user_pwd */
	public String getUserPwd() {
		return this.userPwd;
	}
	/** 手机号码		db_column: mob_num */
	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}
	/** 手机号码		db_column: mob_num */
	public String getMobNum() {
		return this.mobNum;
	}
	/** 邮件		db_column: eml */
	public void setEml(String eml) {
		this.eml = eml;
	}
	/** 邮件		db_column: eml */
	public String getEml() {
		return this.eml;
	}
	/** 头像url		db_column: avtr_url */
	public void setAvtrUrl(String avtrUrl) {
		this.avtrUrl = avtrUrl;
	}
	/** 头像url		db_column: avtr_url */
	public String getAvtrUrl() {
		return this.avtrUrl;
	}
	/** 岗位code		db_column: postn_code */
	public void setPostnCode(String postnCode) {
		this.postnCode = postnCode;
	}
	/** 岗位code		db_column: postn_code */
	public String getPostnCode() {
		return this.postnCode;
	}
	/** web管理系统链接flag:{0：不可链接web管理系统；1：可以链接管理系统}		db_column: web_aces_flg */
	public void setWebAcesFlg(Boolean webAcesFlg) {
		this.webAcesFlg = webAcesFlg;
	}
	/** web管理系统链接flag:{0：不可链接web管理系统；1：可以链接管理系统}		db_column: web_aces_flg */
	public Boolean getWebAcesFlg() {
		return this.webAcesFlg;
	}
	/** app链接flag:{0：不可链接app；1：可以链接app}		db_column: app_aces_flg */
	public void setAppAcesFlg(Boolean appAcesFlg) {
		this.appAcesFlg = appAcesFlg;
	}
	/** app链接flag:{0：不可链接app；1：可以链接app}		db_column: app_aces_flg */
	public Boolean getAppAcesFlg() {
		return this.appAcesFlg;
	}
	/** 用户手机设备号		db_column: device_Id */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/** 用户手机设备号		db_column: device_Id */
	public String getDeviceId() {
		return this.deviceId;
	}
	public String getCredentialsSalt() {
		return userName + salt;
	}
	//get set End

	public String getSubsyCodes() {
		return subsyCodes;
	}

	public void setSubsyCodes(String subsyCodes) {
		this.subsyCodes = subsyCodes;
	}

	public String getSubsyNames() {
		return subsyNames;
	}

	public void setSubsyNames(String subsyNames) {
		this.subsyNames = subsyNames;
	}

	public MstInterUserDtlEntity getMstInterUserDtlEntity() {
		return mstInterUserDtlEntity;
	}

	public void setMstInterUserDtlEntity(MstInterUserDtlEntity mstInterUserDtlEntity) {
		this.mstInterUserDtlEntity = mstInterUserDtlEntity;
	}

	public String getAvtrImgCode() {
		return avtrImgCode;
	}

	public void setAvtrImgCode(String avtrImgCode) {
		this.avtrImgCode = avtrImgCode;
	}

	public Boolean getAuthorizedFlg() {
		return authorizedFlg;
	}

	public void setAuthorizedFlg(Boolean authorizedFlg) {
		this.authorizedFlg = authorizedFlg;
	}
}


