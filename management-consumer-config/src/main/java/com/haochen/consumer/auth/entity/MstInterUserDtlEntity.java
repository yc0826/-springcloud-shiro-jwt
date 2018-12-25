package com.haochen.consumer.auth.entity;


import com.haochen.common.entity.BaseEntity;

/**
 * db_table: mst_inter_user_dtl
 * @author YangChao
 */
public class MstInterUserDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 5237260549339057627L;


	//columns START
	/** 
	 * 业务基础内部用户详细id		db_column: mst_inter_user_dtl_id */
	private Integer mstInterUserDtlId;
	/** 
	 * 内部用户code		db_column: inter_user_code */
	private String interUserCode;
	/** 
	 * 用户姓氏		db_column: user_last_name */
	private String userLastName;
	/** 
	 * 用户名字		db_column: user_first_name */
	private String userFirstName;
	/** 
	 * 用户昵称		db_column: user_nk_name */
	private String userNkName;
	/** 
	 * 用户签名		db_column: user_sign */
	private String userSign;
	/** 
	 * 用户生日		db_column: user_dob */
	private Integer userDob;
	/** 
	 * 性别flag:{0：女；1：男}		db_column: gder_flg */
	private Boolean gderFlg;
	/** 
	 * 所在省code		db_column: loct_prov_code */
	private String loctProvCode;
	/** 
	 * 所在市code		db_column: loct_city_code */
	private String loctCityCode;
	/** 
	 * 所在地址		db_column: loct_addr */
	private String loctAddr;
	/** 
	 * 邮政编号		db_column: post_no */
	private String postNo;

	private String birthday;
	//columns END

	
	
	//get set START
	/** 业务基础内部用户详细id		db_column: mst_inter_user_dtl_id */
	public void setMstInterUserDtlId(Integer mstInterUserDtlId) {
		this.mstInterUserDtlId = mstInterUserDtlId;
	}
	/** 业务基础内部用户详细id		db_column: mst_inter_user_dtl_id */
	public Integer getMstInterUserDtlId() {
		return this.mstInterUserDtlId;
	}
	/** 内部用户code		db_column: inter_user_code */
	public void setInterUserCode(String interUserCode) {
		this.interUserCode = interUserCode;
	}
	/** 内部用户code		db_column: inter_user_code */
	public String getInterUserCode() {
		return this.interUserCode;
	}
	/** 用户姓氏		db_column: user_last_name */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	/** 用户姓氏		db_column: user_last_name */
	public String getUserLastName() {
		return this.userLastName;
	}
	/** 用户名字		db_column: user_first_name */
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	/** 用户名字		db_column: user_first_name */
	public String getUserFirstName() {
		return this.userFirstName;
	}
	/** 用户昵称		db_column: user_nk_name */
	public void setUserNkName(String userNkName) {
		this.userNkName = userNkName;
	}
	/** 用户昵称		db_column: user_nk_name */
	public String getUserNkName() {
		return this.userNkName;
	}
	/** 用户签名		db_column: user_sign */
	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}
	/** 用户签名		db_column: user_sign */
	public String getUserSign() {
		return this.userSign;
	}
	/** 用户生日		db_column: user_dob */
	public void setUserDob(Integer userDob) {
		this.userDob = userDob;
	}
	/** 用户生日		db_column: user_dob */
	public Integer getUserDob() {
		return this.userDob;
	}
	/** 性别flag:{0：女；1：男}		db_column: gder_flg */
	public void setGderFlg(Boolean gderFlg) {
		this.gderFlg = gderFlg;
	}
	/** 性别flag:{0：女；1：男}		db_column: gder_flg */
	public Boolean getGderFlg() {
		return this.gderFlg;
	}
	/** 所在省code		db_column: loct_prov_code */
	public void setLoctProvCode(String loctProvCode) {
		this.loctProvCode = loctProvCode;
	}
	/** 所在省code		db_column: loct_prov_code */
	public String getLoctProvCode() {
		return this.loctProvCode;
	}
	/** 所在市code		db_column: loct_city_code */
	public void setLoctCityCode(String loctCityCode) {
		this.loctCityCode = loctCityCode;
	}
	/** 所在市code		db_column: loct_city_code */
	public String getLoctCityCode() {
		return this.loctCityCode;
	}
	/** 所在地址		db_column: loct_addr */
	public void setLoctAddr(String loctAddr) {
		this.loctAddr = loctAddr;
	}
	/** 所在地址		db_column: loct_addr */
	public String getLoctAddr() {
		return this.loctAddr;
	}
	/** 邮政编号		db_column: post_no */
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	/** 邮政编号		db_column: post_no */
	public String getPostNo() {
		return this.postNo;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

//get set End

	@Override
	public String toString() {
		return "MstInterUserDtlEntity [" +
				"MstInterUserDtlId=" + getMstInterUserDtlId() + ", " +
				"InterUserCode=" + getInterUserCode() + ", " +
				"UserLastName=" + getUserLastName() + ", " +
				"UserFirstName=" + getUserFirstName() + ", " +
				"UserNkName=" + getUserNkName() + ", " +
				"UserSign=" + getUserSign() + ", " +
				"UserDob=" + getUserDob() + ", " +
				"GderFlg=" + getGderFlg() + ", " +
				"LoctProvCode=" + getLoctProvCode() + ", " +
				"LoctCityCode=" + getLoctCityCode() + ", " +
				"LoctAddr=" + getLoctAddr() + ", " +
				"PostNo=" + getPostNo() + ", " +
				"CrtTime=" + getCrtTime() + ", " +
				"CrtUserCode=" + getCrtUserCode() + ", " +
				"UpdTime=" + getUpdTime() + ", " +
				"UpdUserCode=" + getUpdUserCode() + ", " +
				"DelFlg=" + getDelFlg() + ", " +
				"VerNum=" + getVerNum() +
				"]";
	}
	
}


