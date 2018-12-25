package com.haochen.provider.auth.entity;

import com.haochen.common.entity.BaseEntity;


/**
 * db_table: mst_roll_reso_oper
 * @author YangChao
 */
public class MstRollResoOperEntity extends BaseEntity {
	private static final long serialVersionUID = 6931597489446472512L;

	//columns START
	/** 
	 * 业务基础角色资源id		db_column: mst_roll_reso_id */
	private Integer mstRollResoId;
	/** 
	 * 角色code		db_column: roll_code */
	private String rollCode;
	/** 
	 * 资源code		db_column: reso_code */
	private String resoCode;
	/** 
	 * 资源操作code:{mst_gen：类型0006}		db_column: reso_oper_code */
	private String resoOperCode;
	//columns END

	
	
	//get set START
	/** 业务基础角色资源id		db_column: mst_roll_reso_id */
	public void setMstRollResoId(Integer mstRollResoId) {
		this.mstRollResoId = mstRollResoId;
	}
	/** 业务基础角色资源id		db_column: mst_roll_reso_id */
	public Integer getMstRollResoId() {
		return this.mstRollResoId;
	}
	/** 角色code		db_column: roll_code */
	public void setRollCode(String rollCode) {
		this.rollCode = rollCode;
	}
	/** 角色code		db_column: roll_code */
	public String getRollCode() {
		return this.rollCode;
	}
	/** 资源code		db_column: reso_code */
	public void setResoCode(String resoCode) {
		this.resoCode = resoCode;
	}
	/** 资源code		db_column: reso_code */
	public String getResoCode() {
		return this.resoCode;
	}
	/** 资源操作code:{mst_gen：类型0006}		db_column: reso_oper_code */
	public void setResoOperCode(String resoOperCode) {
		this.resoOperCode = resoOperCode;
	}
	/** 资源操作code:{mst_gen：类型0006}		db_column: reso_oper_code */
	public String getResoOperCode() {
		return this.resoOperCode;
	}
	//get set End

	@Override
	public String toString() {
		return "MstRollResoOperEntity [" +
				"MstRollResoId=" + getMstRollResoId() + ", " +
				"RollCode=" + getRollCode() + ", " +
				"ResoCode=" + getResoCode() + ", " +
				"ResoOperCode=" + getResoOperCode() + ", " +
				"CrtTime=" + getCrtTime() + ", " +
				"CrtUserCode=" + getCrtUserCode() + ", " +
				"UpdTime=" + getUpdTime() + ", " +
				"UpdUserCode=" + getUpdUserCode() + ", " +
				"DelFlg=" + getDelFlg() + ", " +
				"VerNum=" + getVerNum() +
				"]";
	}
	
}


