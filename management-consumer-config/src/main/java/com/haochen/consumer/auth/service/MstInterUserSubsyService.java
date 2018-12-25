package com.haochen.consumer.auth.service;


import com.haochen.consumer.auth.entity.MstInterUserSubsyEntity;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
public interface MstInterUserSubsyService {

    /**
     * 根据DeptCode获得用户会所权限信息列表
     *
     * @param params
     * @return
     */
    List<MstInterUserSubsyEntity> getUserSubsyListByDeptCode(Map params);

    int queryCount(MstInterUserSubsyEntity mstInterUserSubsyEntity);

    boolean isInterUserExsist(String interUserCode, String subsyCode);


    /**
     * 根据内部用户code获取所属会所信息
     *
     * @param interUserCode
     * @return
     */
    List<Map> getInterUserSubsyInfoListByUserCode(String interUserCode);

    /**
     * 根据内部用户code获取他所属的所有会所code
     *
     * @param interUserCode
     * @return
     */
    List<String> getInterUserSubsyCodeListByUserCode(String interUserCode);

    /**
     * 检查内部用户是否属于给予判断的会所code
     * @param interUserCode
     * @param subsyCode
     * @return
     */
    boolean isSubsyCodeBelongToInterUser(String interUserCode, String subsyCode);

}
