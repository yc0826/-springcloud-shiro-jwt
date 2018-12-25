package com.haochen.provider.auth.repo;

import com.haochen.provider.auth.entity.MstRollResoOperEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author YangChao
 */
@Mapper
public interface IMstRollResoOperDao {


    /**
     * @param mstRollResoOperEntity
     * @return
     */
    int updateById(MstRollResoOperEntity mstRollResoOperEntity);

    /**
     * @param mstRollResoOperEntity
     */
    void insert(MstRollResoOperEntity mstRollResoOperEntity);

    /**
     * @param mstRollResoOperEntity
     * @return
     */
    List<MstRollResoOperEntity> queryList(MstRollResoOperEntity mstRollResoOperEntity);

    /**
     * @return
     */
    List<MstRollResoOperEntity> queryAll();

    /**
     * @param id
     * @return
     */
    int deleteById(String id);


    //-- user-defined start --








    //-- user-defined end --
}