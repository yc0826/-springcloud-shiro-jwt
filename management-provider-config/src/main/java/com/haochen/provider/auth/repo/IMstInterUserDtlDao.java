package com.haochen.provider.auth.repo;

import com.haochen.provider.auth.entity.MstInterUserDtlEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@Mapper
public interface IMstInterUserDtlDao {


    int updateById(MstInterUserDtlEntity mstInterUserDtlEntity);

    void insert(MstInterUserDtlEntity mstInterUserDtlEntity);

    MstInterUserDtlEntity queryById(String id);

    MstInterUserDtlEntity queryByCondition(Map map);

    List<MstInterUserDtlEntity> queryList(MstInterUserDtlEntity mstInterUserDtlEntity);

    List<MstInterUserDtlEntity> queryList(Map map);

    List<MstInterUserDtlEntity> queryAll();

    int queryCount(MstInterUserDtlEntity mstInterUserDtlEntity);

    int deleteById(String id);

    int deleteLogicById(String id);

    int updateByCondition(MstInterUserDtlEntity mstInterUserDtlEntity);

    MstInterUserDtlEntity findByUserCode(String interUserCode);

    void deleteByUserCode(String interUserCode);


    //-- user-defined start --








    //-- user-defined end --
}