package com.haochen.provider.auth.repo;

import com.haochen.provider.auth.dto.InterUserRollDto;
import com.haochen.provider.auth.entity.MstInterUserRollEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@Mapper
public interface IMstInterUserRollDao {


    int updateById(MstInterUserRollEntity mstInterUserRollEntity);

    void insert(MstInterUserRollEntity mstInterUserRollEntity);

    MstInterUserRollEntity queryById(String id);

    MstInterUserRollEntity queryByCondition(Map map);

    List<MstInterUserRollEntity> queryList(MstInterUserRollEntity mstInterUserRollEntity);

    List<MstInterUserRollEntity> queryList(Map map);

    List<MstInterUserRollEntity> queryAll();

    int queryCount(MstInterUserRollEntity mstInterUserRollEntity);

    int deleteById(String id);

    int deleteLogicById(String id);

    int updateByCondition(MstInterUserRollEntity mstInterUserRollEntity);

    List<String> findByUserCode(String userCode);

    List<InterUserRollDto> findPage(Map<String, Object> paramMap);

    Integer count(Map<String, Object> paramMap);

    MstInterUserRollEntity findEntityByUserCodeAndSubsyCode(Map<String, Object> map);

    void deleteUserRollByUserCode(String interUserCode, String subsyCode);

    void insertUserRoll(Map<String, Object> paramMap);


    //-- user-defined start --
    List<String> getUsersByRollCode(Map map);

    List<String> getInterUserRollSubsyCodesByUserCode(String interUserCode);

    Integer queryMmatronOtherRollExist(String interUserCode);

    Integer getCount();

    //-- user-defined end --
}