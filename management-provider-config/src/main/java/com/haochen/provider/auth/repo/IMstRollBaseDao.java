package com.haochen.provider.auth.repo;

import com.haochen.provider.auth.entity.MstRollBaseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author YangChao
 */
@Mapper
public interface IMstRollBaseDao {


    int updateById(MstRollBaseEntity mstRollBaseEntity);

    void insert(MstRollBaseEntity mstRollBaseEntity);

    MstRollBaseEntity queryById(String id);

    MstRollBaseEntity queryByCondition(Map map);

    List<MstRollBaseEntity> queryList(MstRollBaseEntity mstRollBaseEntity);

    List<MstRollBaseEntity> queryList(Map map);

    List<MstRollBaseEntity> queryAll();

    int deleteById(String id);

    int deleteLogicById(String id);

    int updateByCondition(MstRollBaseEntity mstRollBaseEntity);


    //-- user-defined start --


    MstRollBaseEntity findByCode(String rollCode);

    void deleteRoleResource(String rollCode);

    void insertRoleResource(Map<String, Object> paramMap);

    List<MstRollBaseEntity> findPage(Map<String, Object> map);

    void deleteRoleByCode(String rollCode);

    Set<String> findResourceCodesByRoleCodes(String[] roleCodes);

    Integer count(Map<String, Object> paramMap);

    String findNamesByRollCodes(String[] rollCodes);

    List<MstRollBaseEntity> findByFilter(Map<String, Object> paramMap);

    //-- user-defined end --
}