package com.haochen.consumer.auth.entity;


import com.haochen.common.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;


/**
 * db_table: mst_subsy_base
 * @author YangChao
 */
public class MstSubsyBaseEntity extends BaseEntity {
	private static final long serialVersionUID = 3314841265134222018L;

	//columns START
	/** 
	 * 业务基础会所基本id		db_column: mst_subsy_base_id */
	private Integer mstSubsyBaseId;
	/**
	 * 会所code		db_column: subsy_code */
	private String subsyCode;
	/**
	 * 会所名称		db_column: subsy_name */
	private String subsyName;
	/**
	 * 会所显示名称		db_column: subsy_disp_name */
	private String subsyDispName;
	/**
	 * 所在省code		db_column: loct_prov_code */
	private String loctProvCode;
	/**
	 * 所在市code		db_column: loct_city_code */
	private String loctCityCode;
	/**
	 * 所在市code		db_column: loct_area_code */
	private String loctAreaCode;
	/**
	 * 会所地址		db_column: subsy_addr */
	private String subsyAddr;
	/**
	 * 所在经度		db_column: loct_lon */
	private Double loctLon;
	/**
	 * 所在纬度		db_column: loct_lat */
	private Double loctLat;
	/**
	 * 电话号码		db_column: phone_num */
	private String phoneNum;
	/**
	 * 手机号码		db_column: mob_num */
	private String mobNum;
	/**
	 * 邮政编号		db_column: post_no */
	private String postNo;
	/**
	 * 会所描述		db_column: subsy_desc */
	private String subsyDesc;
	/**
	 * 营业时间描述		db_column: busi_time_desc */
	private String busiTimeDesc;
	/**
	 * 品牌code:{cfg_gen：类型0003}		db_column: brand_code */
	private String brandCode;
	/**
	 * 品牌类型code 0089		db_column: subsy_brand_type */
	private String subsyBrandType;
	/**
	 * bannerurl		db_column: banr_url */
	private String banrUrl;
	/**
	 * 会所审核状态code:{cfg_gen: 类型0066}		db_column: audit_status_code */
	private String auditStatusCode;
	/**
	 * 产品审核状态code:{cfg_gen: 类型0084}		db_column: prod_audit_status_code */
	private String prodAuditStatusCode;
	/**
	 * 会所关闭审核状态code:{cfg_gen:类型0088}		db_column: close_audit_status_code */
	private String closeAuditStatusCode;
	/**
	 * 会所关闭审核审批人		db_column: close_audit_approver */
	private String closeAuditApprover;
	/**
	 * 是否允许会所管理员登录后台		db_column: is_allow_subsy_admin_login */
	private Integer isAllowSubsyAdminLogin;
	/**
	 * 均价		db_column: price */
	private Integer price;
	/**
	 * 人气值		db_column: popul_val */
	private BigDecimal populVal;
	/**
	 * 服务评分		db_column: serv_score */
	private BigDecimal servScore;
	/**
	 * 首页显示预约flag:{0：不预约首页展示；1：预约首页展示}		db_column: home_disp_resv_flg */
	private Boolean homeDispResvFlg;
	/**
	 * 促销描述		db_column: promotion_desc */
	private String promotionDesc;
	/**
	 * 预定描述		db_column: book_desc */
	private String bookDesc;
	/**
	 * 会所类型code:{cfg_gen：类型0079}		db_column: subsy_type */
	private String subsyType;
	/**
	 * 会所可用flag:{0：不可用  1：可用}		db_column: subsy_activ_flg */
	private Integer subsyActivFlg;
	/**
	 * 会所有效期开始时间		db_column: subsy_activ_start_time */
	private Date subsyActivStartTime;
	/**
	 * 会所有效期结束时间		db_column: subsy_activ_end_time */
	private Date subsyActivEndTime;
		/**
	 * 会所是否对外公开		db_column: subsy_open_flg */
	private Integer subsyOpenFlg;

	//columns END

	private String brandName;

	private String auditStatusName;


	private String provName;

	private String cityName;

	/**
	 * 会所有效期（年）
	 */
	private String subsyActivYears;
	private String subsyActivStartTimeDisplay;



	private String bannerCode;
	private String thumbnailPicCode;
	private String detailPicCode;


	//columns END


	//get set START
	/** 业务基础会所基本id		db_column: mst_subsy_base_id */
	public void setMstSubsyBaseId(Integer mstSubsyBaseId) {
		this.mstSubsyBaseId = mstSubsyBaseId;
	}
	/** 业务基础会所基本id		db_column: mst_subsy_base_id */
	public Integer getMstSubsyBaseId() {
		return this.mstSubsyBaseId;
	}
	/** 会所code		db_column: subsy_code */
	public void setSubsyCode(String subsyCode) {
		this.subsyCode = subsyCode;
	}
	/** 会所code		db_column: subsy_code */
	public String getSubsyCode() {
		return this.subsyCode;
	}
	/** 会所名称		db_column: subsy_name */
	public void setSubsyName(String subsyName) {
		this.subsyName = subsyName;
	}
	/** 会所名称		db_column: subsy_name */
	public String getSubsyName() {
		return this.subsyName;
	}
	/** 会所显示名称		db_column: subsy_disp_name */
	public void setSubsyDispName(String subsyDispName) {
		this.subsyDispName = subsyDispName;
	}
	/** 会所显示名称		db_column: subsy_disp_name */
	public String getSubsyDispName() {
		return this.subsyDispName;
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
	/** 所在市code		db_column: loct_area_code */
	public void setLoctAreaCode(String loctAreaCode) {
		this.loctAreaCode = loctAreaCode;
	}
	/** 所在市code		db_column: loct_area_code */
	public String getLoctAreaCode() {
		return this.loctAreaCode;
	}
	/** 会所地址		db_column: subsy_addr */
	public void setSubsyAddr(String subsyAddr) {
		this.subsyAddr = subsyAddr;
	}
	/** 会所地址		db_column: subsy_addr */
	public String getSubsyAddr() {
		return this.subsyAddr;
	}
	/** 所在经度		db_column: loct_lon */
	public void setLoctLon(Double loctLon) {
		this.loctLon = loctLon;
	}
	/** 所在经度		db_column: loct_lon */
	public Double getLoctLon() {
		return this.loctLon;
	}
	/** 所在纬度		db_column: loct_lat */
	public void setLoctLat(Double loctLat) {
		this.loctLat = loctLat;
	}
	/** 所在纬度		db_column: loct_lat */
	public Double getLoctLat() {
		return this.loctLat;
	}
	/** 电话号码		db_column: phone_num */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	/** 电话号码		db_column: phone_num */
	public String getPhoneNum() {
		return this.phoneNum;
	}
	/** 手机号码		db_column: mob_num */
	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}
	/** 手机号码		db_column: mob_num */
	public String getMobNum() {
		return this.mobNum;
	}
	/** 邮政编号		db_column: post_no */
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	/** 邮政编号		db_column: post_no */
	public String getPostNo() {
		return this.postNo;
	}
	/** 会所描述		db_column: subsy_desc */
	public void setSubsyDesc(String subsyDesc) {
		this.subsyDesc = subsyDesc;
	}
	/** 会所描述		db_column: subsy_desc */
	public String getSubsyDesc() {
		return this.subsyDesc;
	}
	/** 营业时间描述		db_column: busi_time_desc */
	public void setBusiTimeDesc(String busiTimeDesc) {
		this.busiTimeDesc = busiTimeDesc;
	}
	/** 营业时间描述		db_column: busi_time_desc */
	public String getBusiTimeDesc() {
		return this.busiTimeDesc;
	}
	/** 品牌code:{cfg_gen：类型0003}		db_column: brand_code */
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	/** 品牌code:{cfg_gen：类型0003}		db_column: brand_code */
	public String getBrandCode() {
		return this.brandCode;
	}
	/** bannerurl		db_column: banr_url */
	public void setBanrUrl(String banrUrl) {
		this.banrUrl = banrUrl;
	}
	/** bannerurl		db_column: banr_url */
	public String getBanrUrl() {
		return this.banrUrl;
	}
	/** 会所审核状态code:{cfg_gen: 类型0066}		db_column: audit_status_code */
	public void setAuditStatusCode(String auditStatusCode) {
		this.auditStatusCode = auditStatusCode;
	}
	/** 会所审核状态code:{cfg_gen: 类型0066}		db_column: audit_status_code */
	public String getAuditStatusCode() {
		return this.auditStatusCode;
	}
	/** 产品审核状态code:{cfg_gen: 类型0084}		db_column: prod_audit_status_code */
	public void setProdAuditStatusCode(String prodAuditStatusCode) {
		this.prodAuditStatusCode = prodAuditStatusCode;
	}
	/** 产品审核状态code:{cfg_gen: 类型0084}		db_column: prod_audit_status_code */
	public String getProdAuditStatusCode() {
		return this.prodAuditStatusCode;
	}
	/** 会所关闭审核状态code:{cfg_gen:类型0088}		db_column: close_audit_status_code */
	public void setCloseAuditStatusCode(String closeAuditStatusCode) {
		this.closeAuditStatusCode = closeAuditStatusCode;
	}
	/** 会所关闭审核状态code:{cfg_gen:类型0088}		db_column: close_audit_status_code */
	public String getCloseAuditStatusCode() {
		return this.closeAuditStatusCode;
	}
	/** 会所关闭审核审批人		db_column: close_audit_approver */
	public void setCloseAuditApprover(String closeAuditApprover) {
		this.closeAuditApprover = closeAuditApprover;
	}
	/** 会所关闭审核审批人		db_column: close_audit_approver */
	public String getCloseAuditApprover() {
		return this.closeAuditApprover;
	}
	/** 是否允许会所管理员登录后台		db_column: is_allow_subsy_admin_login */
	public void setIsAllowSubsyAdminLogin(Integer isAllowSubsyAdminLogin) {
		this.isAllowSubsyAdminLogin = isAllowSubsyAdminLogin;
	}
	/** 是否允许会所管理员登录后台		db_column: is_allow_subsy_admin_login */
	public Integer getIsAllowSubsyAdminLogin() {
		return this.isAllowSubsyAdminLogin;
	}
	/** 均价		db_column: price */
	public void setPrice(Integer price) {
		this.price = price;
	}
	/** 均价		db_column: price */
	public Integer getPrice() {
		return this.price;
	}
	/** 人气值		db_column: popul_val */
	public void setPopulVal(BigDecimal populVal) {
		this.populVal = populVal;
	}
	/** 人气值		db_column: popul_val */
	public BigDecimal getPopulVal() {
		return this.populVal;
	}
	/** 服务评分		db_column: serv_score */
	public void setServScore(BigDecimal servScore) {
		this.servScore = servScore;
	}
	/** 服务评分		db_column: serv_score */
	public BigDecimal getServScore() {
		return this.servScore;
	}
	/** 首页显示预约flag:{0：不预约首页展示；1：预约首页展示}		db_column: home_disp_resv_flg */
	public void setHomeDispResvFlg(Boolean homeDispResvFlg) {
		this.homeDispResvFlg = homeDispResvFlg;
	}
	/** 首页显示预约flag:{0：不预约首页展示；1：预约首页展示}		db_column: home_disp_resv_flg */
	public Boolean getHomeDispResvFlg() {
		return this.homeDispResvFlg;
	}

	public String getProvName() {
		return provName;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public String getPromotionDesc() {
		return promotionDesc;
	}

	public void setPromotionDesc(String promotionDesc) {
		this.promotionDesc = promotionDesc;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}


	//get set End


	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getAuditStatusName() {
		return auditStatusName;
	}

	public void setAuditStatusName(String auditStatusName) {
		this.auditStatusName = auditStatusName;
	}



	public String getBannerCode() {
		return bannerCode;
	}

	public void setBannerCode(String bannerCode) {
		this.bannerCode = bannerCode;
	}

	public String getSubsyType() {
		return subsyType;
	}

	public void setSubsyType(String subsyType) {
		this.subsyType = subsyType;
	}

	public Integer getSubsyActivFlg() {
		return subsyActivFlg;
	}

	public void setSubsyActivFlg(Integer subsyActivFlg) {
		this.subsyActivFlg = subsyActivFlg;
	}

	public Date getSubsyActivStartTime() {
		return subsyActivStartTime;
	}

	public void setSubsyActivStartTime(Date subsyActivStartTime) {
		this.subsyActivStartTime = subsyActivStartTime;
	}

	public Date getSubsyActivEndTime() {
		return subsyActivEndTime;
	}

	public void setSubsyActivEndTime(Date subsyActivEndTime) {
		this.subsyActivEndTime = subsyActivEndTime;
	}

	public String getThumbnailPicCode() {
		return thumbnailPicCode;
	}

	public void setThumbnailPicCode(String thumbnailPicCode) {
		this.thumbnailPicCode = thumbnailPicCode;
	}

	public String getDetailPicCode() {
		return detailPicCode;
	}

	public void setDetailPicCode(String detailPicCode) {
		this.detailPicCode = detailPicCode;
	}

	public String getSubsyBrandType() {
		return subsyBrandType;
	}

	public void setSubsyBrandType(String subsyBrandType) {
		this.subsyBrandType = subsyBrandType;
	}

	public Integer getSubsyOpenFlg() {
		return subsyOpenFlg;
	}

	public void setSubsyOpenFlg(Integer subsyOpenFlg) {
		this.subsyOpenFlg = subsyOpenFlg;
	}

	public String getSubsyActivYears() {
		return subsyActivYears;
	}

	public void setSubsyActivYears(String subsyActivYears) {
		this.subsyActivYears = subsyActivYears;
	}

	public String getSubsyActivStartTimeDisplay() {
		return subsyActivStartTimeDisplay;
	}

	public void setSubsyActivStartTimeDisplay(String subsyActivStartTimeDisplay) {
		this.subsyActivStartTimeDisplay = subsyActivStartTimeDisplay;
	}

	@Override
	public String toString() {
		return "MstSubsyBaseEntity [" +
				"MstSubsyBaseId=" + getMstSubsyBaseId() + ", " +
				"SubsyCode=" + getSubsyCode() + ", " +
				"SubsyName=" + getSubsyName() + ", " +
				"SubsyDispName=" + getSubsyDispName() + ", " +
				"LoctProvCode=" + getLoctProvCode() + ", " +
				"LoctCityCode=" + getLoctCityCode() + ", " +
				"LoctAreaCode=" + getLoctAreaCode() + ", " +
				"SubsyAddr=" + getSubsyAddr() + ", " +
				"LoctLon=" + getLoctLon() + ", " +
				"LoctLat=" + getLoctLat() + ", " +
				"PhoneNum=" + getPhoneNum() + ", " +
				"MobNum=" + getMobNum() + ", " +
				"PostNo=" + getPostNo() + ", " +
				"SubsyDesc=" + getSubsyDesc() + ", " +
				"BusiTimeDesc=" + getBusiTimeDesc() + ", " +
				"BrandCode=" + getBrandCode() + ", " +
				"SubsyBrandType=" + getSubsyBrandType() + ", " +
				"BanrUrl=" + getBanrUrl() + ", " +
				"AuditStatusCode=" + getAuditStatusCode() + ", " +
				"ProdAuditStatusCode=" + getProdAuditStatusCode() + ", " +
				"CloseAuditStatusCode=" + getCloseAuditStatusCode() + ", " +
				"CloseAuditApprover=" + getCloseAuditApprover() + ", " +
				"IsAllowSubsyAdminLogin=" + getIsAllowSubsyAdminLogin() + ", " +
				"Price=" + getPrice() + ", " +
				"PopulVal=" + getPopulVal() + ", " +
				"ServScore=" + getServScore() + ", " +
				"CrtTime=" + getCrtTime() + ", " +
				"CrtUserCode=" + getCrtUserCode() + ", " +
				"UpdTime=" + getUpdTime() + ", " +
				"UpdUserCode=" + getUpdUserCode() + ", " +
				"DelFlg=" + getDelFlg() + ", " +
				"VerNum=" + getVerNum() + ", " +
				"HomeDispResvFlg=" + getHomeDispResvFlg() + ", " +
				"PromotionDesc=" + getPromotionDesc() + ", " +
				"BookDesc=" + getBookDesc() + ", " +
				"SubsyType=" + getSubsyType() + ", " +
				"SubsyActivFlg=" + getSubsyActivFlg() + ", " +
				"SubsyActivStartTime=" + getSubsyActivStartTime() + ", " +
				"SubsyActivEndTime=" + getSubsyActivEndTime() + ", " +
				"SubsyOpenFlg=" + getSubsyOpenFlg() +
				"]";
	}



}


