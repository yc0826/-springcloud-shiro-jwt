package com.haochen.provider.auth.entity;


import com.haochen.common.entity.BaseEntity;

/**
 * db_table: mst_inter_user_subsy
 * @author YangChao
 */
public class MstInterUserSubsyEntity extends BaseEntity {
	private static final long serialVersionUID = -6619435780529786253L;

	//columns START
	/** 
	 * 业务基础内部用户会所id		db_column: mst_inter_user_subsy_id */
	private Integer mstInterUserSubsyId;
	/**
	 * 内部用户code		db_column: inter_user_code */
	private String interUserCode;
	/**
	 * 会所code		db_column: subsy_code */
	private String subsyCode;
	/**
	 * 默认会所flag:{0：非默认会所；1：默认会所}		db_column: dflt_subsy_flg */
	private Boolean dfltSubsyFlg;

	private String subsyDispName;

	//columns END



	//get set START
	/** 业务基础内部用户会所id		db_column: mst_inter_user_subsy_id */
	public void setMstInterUserSubsyId(Integer mstInterUserSubsyId) {
		this.mstInterUserSubsyId = mstInterUserSubsyId;
	}
	/** 业务基础内部用户会所id		db_column: mst_inter_user_subsy_id */
	public Integer getMstInterUserSubsyId() {
		return this.mstInterUserSubsyId;
	}
	/** 内部用户code		db_column: inter_user_code */
	public void setInterUserCode(String interUserCode) {
		this.interUserCode = interUserCode;
	}
	/** 内部用户code		db_column: inter_user_code */
	public String getInterUserCode() {
		return this.interUserCode;
	}
	/** 会所code		db_column: subsy_code */
	public void setSubsyCode(String subsyCode) {
		this.subsyCode = subsyCode;
	}
	/** 会所code		db_column: subsy_code */
	public String getSubsyCode() {
		return this.subsyCode;
	}
	/** 默认会所flag:{0：非默认会所；1：默认会所}		db_column: dflt_subsy_flg */
	public void setDfltSubsyFlg(Boolean dfltSubsyFlg) {
		this.dfltSubsyFlg = dfltSubsyFlg;
	}
	/** 默认会所flag:{0：非默认会所；1：默认会所}		db_column: dflt_subsy_flg */
	public Boolean getDfltSubsyFlg() {
		return this.dfltSubsyFlg;
	}

	public String getSubsyDispName() {
		return subsyDispName;
	}

	public void setSubsyDispName(String subsyDispName) {
		this.subsyDispName = subsyDispName;
	}


	//get set End

	@Override
	public String toString() {
		return "MstInterUserSubsyEntity [" +
				"MstInterUserSubsyId=" + getMstInterUserSubsyId() + ", " +
				"InterUserCode=" + getInterUserCode() + ", " +
				"SubsyCode=" + getSubsyCode() + ", " +
				"DfltSubsyFlg=" + getDfltSubsyFlg() + ", " +
				"CrtTime=" + getCrtTime() + ", " +
				"CrtUserCode=" + getCrtUserCode() + ", " +
				"UpdTime=" + getUpdTime() + ", " +
				"UpdUserCode=" + getUpdUserCode() + ", " +
				"DelFlg=" + getDelFlg() + ", " +
				"VerNum=" + getVerNum() +
				"]";
	}
	
}


