package com.haochen.provider.auth.service;


import com.haochen.provider.auth.dto.UserInfoOutputBean;
import com.haochen.provider.auth.entity.MstInterUserBaseEntity;
import com.haochen.provider.auth.entity.MstInterUserDtlEntity;
import com.haochen.provider.auth.dto.InterUserDto;
import com.haochen.common.exception.SystemException;
import com.haochen.provider.auth.entity.TranInterUserTokenEntity;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
public interface MstInterUserBaseService {


    MstInterUserBaseEntity findByCode(String userCode);

    MstInterUserBaseEntity findByUsername(String username);

    List<InterUserDto> findPage(Map<String, Object> paramMap);

    Integer count(Map<String, Object> paramMap);

    void createUser(MstInterUserBaseEntity user) throws SystemException;

    void updateUser(MstInterUserBaseEntity user) throws SystemException;

    void deleteUser(String interUserCode);

    void changePassword(String interUserCode, String newPassword);

    List<MstInterUserBaseEntity> findAll();

    List<MstInterUserBaseEntity> findBySubsyCodes(String subsyCodes);

    MstInterUserDtlEntity findDtlByUserCode(String userCode);

    void validate(String interUserCode, String currentUserCode);

    String generateInterUserForMmatron(MstInterUserBaseEntity mstInterUserBaseEntity, String[] mmatronServSpeciDescArray) throws SystemException;


    MstInterUserBaseEntity findByMobile(String mobNum) throws SystemException;

    String hello();

    List<String> findRoleCodeByUserCode(String userCode);

    UserInfoOutputBean getUserInfo(String userName);

    void updateJwtToken(TranInterUserTokenEntity tranInterUserTokenEntity);

    Integer checkJwtToken(String token);
}
