package com.haochen.provider.auth.repo;


import com.haochen.provider.auth.entity.MstInterUserSubsyEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@Mapper
public interface IMstInterUserSubsyDao {


    void updateById(MstInterUserSubsyEntity mstInterUserSubsyEntity);

    void insert(MstInterUserSubsyEntity mstInterUserSubsyEntity);

    MstInterUserSubsyEntity queryById(String id);

    List<MstInterUserSubsyEntity> queryList(MstInterUserSubsyEntity mstInterUserSubsyEntity);

    List<MstInterUserSubsyEntity> queryAll();

    int queryCount(MstInterUserSubsyEntity mstInterUserSubsyEntity);

    int deleteById(String id);

    int deleteLogicById(String id);

    //-- user-defined start --


    public List<MstInterUserSubsyEntity> getUserSubsyList(MstInterUserSubsyEntity param);

    List<MstInterUserSubsyEntity> getUserSubsyListBySubSyCode(MstInterUserSubsyEntity param);

//    List<MstInterUserSubsyEntity> getUserSubsyListByInterUserCode(String interUserCode);

    List<MstInterUserSubsyEntity> getUserSubsyListByDeptCode(Map params);


    List<Map> getInterUserSubsyListByUserCode(String interUserCode);
    //-- user-defined end --
 
}
