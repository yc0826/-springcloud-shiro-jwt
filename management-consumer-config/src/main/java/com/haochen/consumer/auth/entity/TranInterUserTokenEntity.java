package com.haochen.consumer.auth.entity;


import com.haochen.common.entity.BaseEntity;

/**
 * db_table: tran_inter_user_token 
 */
public class TranInterUserTokenEntity extends BaseEntity {
	
	//columns START
	/** 
	 * tranInterUserTokenId		db_column: tran_inter_user_token_id */
	private Integer tranInterUserTokenId;
	/** 
	 * userCode		db_column: user_code */
	private String userCode;
	/** 
	 * jwtToken		db_column: jwt_token */
	private String jwtToken;
	/** 
	 * expaireTime		db_column: expaire_time */
	private Long expireTime;
	//columns END

	
	
	//get set START
	/** tranInterUserTokenId		db_column: tran_inter_user_token_id */
	public void setTranInterUserTokenId(Integer tranInterUserTokenId) {
		this.tranInterUserTokenId = tranInterUserTokenId;
	}
	/** tranInterUserTokenId		db_column: tran_inter_user_token_id */
	public Integer getTranInterUserTokenId() {
		return this.tranInterUserTokenId;
	}
	/** userCode		db_column: user_code */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/** userCode		db_column: user_code */
	public String getUserCode() {
		return this.userCode;
	}
	/** jwtToken		db_column: jwt_token */
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	/** jwtToken		db_column: jwt_token */
	public String getJwtToken() {
		return this.jwtToken;
	}

	public Long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}

	//get set End

    @Override
    public String toString() {
    return "TranInterUserTokenEntity ["
    + "TranInterUserTokenId=" + getTranInterUserTokenId() + ", " 
        + "UserCode=" + getUserCode() + ", " 
        + "JwtToken=" + getJwtToken() + ", " 
        + "ExpireTime=" + getExpireTime() + ", "
        + "CrtTime=" + getCrtTime() + ", " 
        + "CrtUserCode=" + getCrtUserCode() + ", " 
        + "UpdTime=" + getUpdTime() + ", " 
        + "UpdUserCode=" + getUpdUserCode() + ", " 
        + "DelFlg=" + getDelFlg() + ", " 
        + "VerNum=" + getVerNum()
     + "]";
    }
	
}


