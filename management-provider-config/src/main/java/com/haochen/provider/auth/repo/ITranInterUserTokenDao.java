package com.haochen.provider.auth.repo;

import com.haochen.provider.auth.entity.TranInterUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@Mapper
public interface ITranInterUserTokenDao {


    int updateById(TranInterUserTokenEntity tranInterUserTokenEntity);

    void insert(TranInterUserTokenEntity tranInterUserTokenEntity);

    TranInterUserTokenEntity queryById(String id);

    TranInterUserTokenEntity queryByCondition(Map map);

    List<TranInterUserTokenEntity> queryList(TranInterUserTokenEntity tranInterUserTokenEntity);

    List<TranInterUserTokenEntity> queryList(Map map);

    List<TranInterUserTokenEntity> queryAll();

    int queryCount(TranInterUserTokenEntity tranInterUserTokenEntity);

    int deleteById(String id);

    int deleteLogicById(String id);

    int updateByCondition(TranInterUserTokenEntity tranInterUserTokenEntity);




    //-- user-defined start --


    TranInterUserTokenEntity findByUserCode(String userCode);

    Integer checkJwtToken(Map<String, Object> paramMap);


    //-- user-defined end --
}