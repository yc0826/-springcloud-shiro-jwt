package com.haochen.provider.auth.repo;

import com.haochen.provider.auth.entity.MstInterUserBaseEntity;
import com.haochen.provider.auth.dto.InterUserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@Mapper
public interface IMstInterUserBaseDao {

    MstInterUserBaseEntity findByCode(String userCode);

    MstInterUserBaseEntity findByUsername(String username);

    List<InterUserDto> findPage(Map<String, Object> paramMap);

    Integer count(Map<String, Object> paramMap);

    String findUserSubyCodesByUserCode(String interUserCode);

    List<MstInterUserBaseEntity> findBySubsyCodes(Map<String, Object> subsyCodeArray);

    List<MstInterUserBaseEntity> findAll();

    void insert(MstInterUserBaseEntity user);

    void inserUserSubsy(Map<String, Object> map);

    void updateUser(MstInterUserBaseEntity user);

    void deleteUserSubsyByUserCode(String interUserCode);


    MstInterUserBaseEntity findByMobile(Map map);

    Integer querySameMobileCount(String mobNum);
}